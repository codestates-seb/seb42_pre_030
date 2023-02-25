package com.vivarepublica.vivastackoverflow.domain.answer.entity;

import com.vivarepublica.vivastackoverflow.audit.Auditable;
import com.vivarepublica.vivastackoverflow.domain.member.entity.Member;
import com.vivarepublica.vivastackoverflow.domain.question.entity.Question;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@NoArgsConstructor
@Getter
@Setter
@Entity
public class Answer extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // AUTO_INCREMENT
    private Long answerId;

    @ManyToOne
    @JoinColumn(name = "QUESTION_ID")  // Question Table 참조
    private Question question;

    @ManyToOne
    @JoinColumn(name = "MEMBER_ID")  // Member Table 참조
    private Member member;

    @Column(nullable = false, length = 9999) // Content length = ? | columnDefinition = "TEXT" <- DataBase 타입 결정
    private String content;

    private String prettyCreatedAt;
    private String prettyModifiedAt;

    // Todo: 첨부파일 Advanced

    public void setMember(Member member) { // 양방향 매핑
        this.member = member;
        if (!this.member.getAnswers().contains(this)) {
            this.member.getAnswers().add(this);
        }
    }
    public void setQuestion(Question question) { // 양방향 매핑
        this.question = question;
        if (!this.question.getAnswers().contains(this)) {
            this.question.getAnswers().add(this);
        }
    }

    public void setPrettyCreatedAt() { // 작성일 LocalDateTime 이쁘게 format (2023-02-25 11:28:30)
        this.prettyCreatedAt = dataTimeFormat(getCreatedAt()) ;
    }

    public void setPrettyModifiedAt() { // 수정일 LocalDateTime 이쁘게 format (2023-02-25 11:28:30)
        this.prettyModifiedAt = dataTimeFormat(getModifiedAt()) ;
    }

    public Answer(String content) { // Slice Test에서 Stub 데이터를 생성하기 위한 생성자
        this.content = content;
    }

    private String dataTimeFormat(LocalDateTime localDateTime) { // LocalDateTime String 이쁘게 format
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return localDateTime.format(formatter);
    }
}
