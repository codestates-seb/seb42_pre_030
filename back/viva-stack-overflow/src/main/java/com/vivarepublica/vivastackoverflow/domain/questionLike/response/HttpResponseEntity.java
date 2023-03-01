//package com.vivarepublica.vivastackoverflow.domain.questionLike.response;
//
//import lombok.Getter;
//import org.springframework.http.HttpStatus;
//import org.apache.commons.lang3.builder.ToStringBuilder;
//
//public class HttpResponseEntity {
//
//    public static <T> ResponseResult<T> success(T response) {
//        return new ResponseResult
//    }
//
//    @Getter
//    public static class ResponseError {
//        private final String message;
//        private final int status;
//
//        ResponseError(Throwable throwable, HttpStatus status) {
//            this(throwable.getMessage(), status);
//        }
//
//        ResponseError(String message, HttpStatus status) {
//            this.message = message;
//            this.status = status.value();
//        }
//
//        public String toString() {
//            return new ToStringBuilder
//        }
//
//    }
//
//    @Getter
//    private static class ResponseResult<T> {
//        private final boolean success;
//        private final T response;
//        private final ResponseError error;
//    }
//
//
//}
