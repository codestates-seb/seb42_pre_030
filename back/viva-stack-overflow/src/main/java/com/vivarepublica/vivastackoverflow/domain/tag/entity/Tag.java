package com.vivarepublica.vivastackoverflow.domain.tag.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

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

//    @ToString.Exclude    //무한참조 방지
//    @ManyToMany(mappedBy = "tags", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
//    private Set<Question> questions = new LinkedHashSet<>();
//
//    public void addQuestion(Question question) {
//        this.questions.add(question);
//    }

    public Tag(Long tagId, HashTag tagName) {
        this.tagId = tagId;
        this.tagName = tagName;
    }
}
