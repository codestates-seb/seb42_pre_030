package com.vivarepublica.vivastackoverflow.domain.questionLike.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QQuestionLike is a Querydsl query type for QuestionLike
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QQuestionLike extends EntityPathBase<QuestionLike> {

    private static final long serialVersionUID = -1777028917L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QQuestionLike questionLike = new QQuestionLike("questionLike");

    public final NumberPath<Long> likeId = createNumber("likeId", Long.class);

    public final com.vivarepublica.vivastackoverflow.domain.member.entity.QMember member;

    public final com.vivarepublica.vivastackoverflow.domain.question.entity.QQuestion question;

    public QQuestionLike(String variable) {
        this(QuestionLike.class, forVariable(variable), INITS);
    }

    public QQuestionLike(Path<? extends QuestionLike> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QQuestionLike(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QQuestionLike(PathMetadata metadata, PathInits inits) {
        this(QuestionLike.class, metadata, inits);
    }

    public QQuestionLike(Class<? extends QuestionLike> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.member = inits.isInitialized("member") ? new com.vivarepublica.vivastackoverflow.domain.member.entity.QMember(forProperty("member")) : null;
        this.question = inits.isInitialized("question") ? new com.vivarepublica.vivastackoverflow.domain.question.entity.QQuestion(forProperty("question"), inits.get("question")) : null;
    }

}

