package com.vivarepublica.vivastackoverflow.domain.response;

import com.vivarepublica.vivastackoverflow.exception.ExceptionCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;

import javax.validation.ConstraintViolation;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
@NoArgsConstructor
public class ErrorResponse {
    private int statusCode;
    private String message;
    private List<FieldError> fieldErrors;
    private List<ConstraintViolationError> violationErrors;

    private ErrorResponse(List<FieldError> fieldErrors, List<ConstraintViolationError> violationErrors) {
        this.fieldErrors = fieldErrors;
        this.violationErrors = violationErrors;
    }

    private ErrorResponse(int statusCode, String message) {
        this.statusCode = statusCode;
        this.message = message;
    }

    // MethodArgumentNotValidException 에 대한 ErrorResponse 객체를 생성
    public static ErrorResponse of(BindingResult bindingResult) {
        return new ErrorResponse(FieldError.of(bindingResult), null);
    }

    // ConstraintViolationException 에 대한 ErrorResponse 객체를 생성
    public static ErrorResponse of(Set<ConstraintViolation<?>> violations) {
        return new ErrorResponse(null, ConstraintViolationError.of(violations));
    }

    // BusinessLogicException 에 대한 ErrorResponse 객체를 생성
    public static ErrorResponse of(ExceptionCode exceptionCode) {
        return new ErrorResponse(exceptionCode.getStatusCode(), exceptionCode.getMessage());
    }

    // HttpRequestMethodNotSupportedException 에 대한 ErrorResponse 객체를 생성
    public static ErrorResponse of(HttpStatus httpStatus) {
        return new ErrorResponse(httpStatus.value(), httpStatus.getReasonPhrase());
    }

    @Getter
    public static class FieldError { // Valid Error 정보 구조체
        private String field;
        private Object rejectedValue;
        private String reason;

        private FieldError(String field, Object rejectedValue, String reason) {
            this.field = field;
            this.rejectedValue = rejectedValue;
            this.reason = reason;
        }

        public static List<FieldError> of(BindingResult bindingResult) {
            List<org.springframework.validation.FieldError> fieldErrors =
                    bindingResult.getFieldErrors();

            return fieldErrors.stream()
                    .map(fieldError -> new FieldError(
                            fieldError.getField(),
                            fieldError.getRejectedValue() == null ?
                                    "" : fieldError.getRejectedValue().toString(),
                            fieldError.getDefaultMessage()))
                    .collect(Collectors.toList());
        }
    }

    @Getter
    public static class ConstraintViolationError {
        private String propertyPath;
        private Object rejectedValue;
        private String reason;

        private ConstraintViolationError(String propertyPath, Object rejectedValue, String reason) {
            this.propertyPath = propertyPath;
            this.rejectedValue = rejectedValue;
            this.reason = reason;
        }

        public static List<ConstraintViolationError> of(
                Set<ConstraintViolation<?>> constraintViolations) {
            return constraintViolations.stream()
                    .map(constraintViolation -> new ConstraintViolationError(
                            constraintViolation.getPropertyPath().toString(),
                            constraintViolation.getInvalidValue().toString(),
                            constraintViolation.getMessage()))
                    .collect(Collectors.toList());
        }
    }
}
