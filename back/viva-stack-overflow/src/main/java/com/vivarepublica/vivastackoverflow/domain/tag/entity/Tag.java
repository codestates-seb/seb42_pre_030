package com.vivarepublica.vivastackoverflow.domain.tag.entity;

import com.vivarepublica.vivastackoverflow.domain.question.entity.Question;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "tag")
public class Tag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tagId;

    @Column(length = 10, nullable = false, updatable = false)
    @Enumerated(EnumType.STRING)
    private HashTag tagName;

    @ToString.Exclude    //무한참조 방지
    @ManyToMany(mappedBy = "tags", cascade = CascadeType.ALL)
    private Set<Question> questions = new LinkedHashSet<>();

    public void addQuestion(Question question) {
        this.questions.add(question);
    }



}
