package com.vivarepublica.vivastackoverflow.domain.answer.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QAnswer is a Querydsl query type for Answer
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QAnswer extends EntityPathBase<Answer> {

    private static final long serialVersionUID = -194889011L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QAnswer answer = new QAnswer("answer");

    public final com.vivarepublica.vivastackoverflow.audit.QAuditable _super = new com.vivarepublica.vivastackoverflow.audit.QAuditable(this);

    public final NumberPath<Long> answerId = createNumber("answerId", Long.class);

    public final StringPath content = createString("content");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final com.vivarepublica.vivastackoverflow.domain.member.entity.QMember member;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> modifiedAt = _super.modifiedAt;

    public final StringPath prettyCreatedAt = createString("prettyCreatedAt");

    public final StringPath prettyModifiedAt = createString("prettyModifiedAt");

    public final com.vivarepublica.vivastackoverflow.domain.question.entity.QQuestion question;

    public QAnswer(String variable) {
        this(Answer.class, forVariable(variable), INITS);
    }

    public QAnswer(Path<? extends Answer> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QAnswer(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QAnswer(PathMetadata metadata, PathInits inits) {
        this(Answer.class, metadata, inits);
    }

    public QAnswer(Class<? extends Answer> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.member = inits.isInitialized("member") ? new com.vivarepublica.vivastackoverflow.domain.member.entity.QMember(forProperty("member")) : null;
        this.question = inits.isInitialized("question") ? new com.vivarepublica.vivastackoverflow.domain.question.entity.QQuestion(forProperty("question"), inits.get("question")) : null;
    }

}

