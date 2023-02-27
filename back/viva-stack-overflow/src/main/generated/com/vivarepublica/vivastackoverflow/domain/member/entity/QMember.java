package com.vivarepublica.vivastackoverflow.domain.member.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QMember is a Querydsl query type for Member
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QMember extends EntityPathBase<Member> {

    private static final long serialVersionUID = 1872273285L;

    public static final QMember member = new QMember("member1");

    public final com.vivarepublica.vivastackoverflow.audit.QAuditable _super = new com.vivarepublica.vivastackoverflow.audit.QAuditable(this);

    public final ListPath<com.vivarepublica.vivastackoverflow.domain.answer.entity.Answer, com.vivarepublica.vivastackoverflow.domain.answer.entity.QAnswer> answers = this.<com.vivarepublica.vivastackoverflow.domain.answer.entity.Answer, com.vivarepublica.vivastackoverflow.domain.answer.entity.QAnswer>createList("answers", com.vivarepublica.vivastackoverflow.domain.answer.entity.Answer.class, com.vivarepublica.vivastackoverflow.domain.answer.entity.QAnswer.class, PathInits.DIRECT2);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final StringPath email = createString("email");

    public final NumberPath<Long> memberId = createNumber("memberId", Long.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> modifiedAt = _super.modifiedAt;

    public final StringPath nickname = createString("nickname");

    public final StringPath password = createString("password");

    public final ListPath<String, StringPath> roles = this.<String, StringPath>createList("roles", String.class, StringPath.class, PathInits.DIRECT2);

    public QMember(String variable) {
        super(Member.class, forVariable(variable));
    }

    public QMember(Path<? extends Member> path) {
        super(path.getType(), path.getMetadata());
    }

    public QMember(PathMetadata metadata) {
        super(Member.class, metadata);
    }

}

