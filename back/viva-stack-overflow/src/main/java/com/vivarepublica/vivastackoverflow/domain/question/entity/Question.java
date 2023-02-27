package com.vivarepublica.vivastackoverflow.domain.question.entity;

import com.vivarepublica.vivastackoverflow.audit.Auditable;
import com.vivarepublica.vivastackoverflow.domain.member.entity.Member;
import com.vivarepublica.vivastackoverflow.domain.tag.entity.Tag;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

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

//       @Column(nullable = true)
//       private Blob files;

       //tag join
       @ToString.Exclude    //무한참조 방지
       @ManyToMany
       @JoinTable(name = "question_tag", joinColumns = @JoinColumn(name ="question_id"),
               inverseJoinColumns = @JoinColumn(name = "tag_id"))
       private Set<Tag> tags = new LinkedHashSet<>();

       public void addTag(Tag tag) {
              this.tags.add(tag);
       }

       //member join
       @ManyToOne(fetch = LAZY)
       @JoinColumn(name = "member_id")
       private Member member;

       public void addMember(Member member) {
              this.member = member;
       }


}
