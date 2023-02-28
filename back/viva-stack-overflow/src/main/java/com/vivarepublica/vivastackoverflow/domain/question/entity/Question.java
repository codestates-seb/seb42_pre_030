package com.vivarepublica.vivastackoverflow.domain.question.entity;

import com.vivarepublica.vivastackoverflow.audit.Auditable;
import com.vivarepublica.vivastackoverflow.domain.answer.entity.Answer;
import com.vivarepublica.vivastackoverflow.domain.member.entity.Member;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.FetchType.LAZY;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "question")
public class Question extends Auditable {

       @Id
       @GeneratedValue(strategy = GenerationType.IDENTITY)
       private Long questionId;

       @Column(length = 100, nullable = false)
       private String title;

       @Column(length = 9999, nullable = false)
       private String content;

       @Column(nullable = false)
       private int views;
       
       @Column(nullable = false)
       private int likeCount;

       @OneToMany(mappedBy = "question", cascade = {CascadeType.PERSIST, CascadeType.REMOVE}) // Todo: Question을 참조중인 Answer의 영속성 전이(Cascade)위해 양방향 매핑 적용
       private List<Answer> answers = new ArrayList<>();

       //tag join
//       @ToString.Exclude    //무한참조 방지
//       @ManyToMany
//       @JoinTable(name = "question_tag", joinColumns = @JoinColumn(name ="question_id"),
//               inverseJoinColumns = @JoinColumn(name = "tag_id"))
//       private Set<Tag> tags = new LinkedHashSet<>();
//
//       public void addTag(Tag tag) {
//              this.tags.add(tag);
//       }

       //member join
       @ManyToOne(fetch = LAZY)
       @JoinColumn(name = "member_id")
       private Member member;

       public void addMember(Member member) {
              this.member = member;
       }

       public Question(String title, String content) {
              this.title = title;
              this.content = content;
       }

       public Question(Long questionId, String title, String content) {
              this.questionId = questionId;
              this.title = title;
              this.content = content;
       }
}
