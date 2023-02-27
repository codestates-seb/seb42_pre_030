package com.vivarepublica.vivastackoverflow.domain.question.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QQuestion is a Querydsl query type for Question
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QQuestion extends EntityPathBase<Question> {

    private static final long serialVersionUID = -1506460067L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QQuestion question = new QQuestion("question");

    public final com.vivarepublica.vivastackoverflow.audit.QAuditable _super = new com.vivarepublica.vivastackoverflow.audit.QAuditable(this);

    public final ListPath<com.vivarepublica.vivastackoverflow.domain.answer.entity.Answer, com.vivarepublica.vivastackoverflow.domain.answer.entity.QAnswer> answers = this.<com.vivarepublica.vivastackoverflow.domain.answer.entity.Answer, com.vivarepublica.vivastackoverflow.domain.answer.entity.QAnswer>createList("answers", com.vivarepublica.vivastackoverflow.domain.answer.entity.Answer.class, com.vivarepublica.vivastackoverflow.domain.answer.entity.QAnswer.class, PathInits.DIRECT2);

    public final StringPath content = createString("content");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final NumberPath<Integer> likeCount = createNumber("likeCount", Integer.class);

    public final com.vivarepublica.vivastackoverflow.domain.member.entity.QMember member;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> modifiedAt = _super.modifiedAt;

    public final NumberPath<Long> questionId = createNumber("questionId", Long.class);

    public final SetPath<com.vivarepublica.vivastackoverflow.domain.tag.entity.Tag, com.vivarepublica.vivastackoverflow.domain.tag.entity.QTag> tags = this.<com.vivarepublica.vivastackoverflow.domain.tag.entity.Tag, com.vivarepublica.vivastackoverflow.domain.tag.entity.QTag>createSet("tags", com.vivarepublica.vivastackoverflow.domain.tag.entity.Tag.class, com.vivarepublica.vivastackoverflow.domain.tag.entity.QTag.class, PathInits.DIRECT2);

    public final StringPath title = createString("title");

    public final NumberPath<Integer> views = createNumber("views", Integer.class);

    public QQuestion(String variable) {
        this(Question.class, forVariable(variable), INITS);
    }

    public QQuestion(Path<? extends Question> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QQuestion(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QQuestion(PathMetadata metadata, PathInits inits) {
        this(Question.class, metadata, inits);
    }

    public QQuestion(Class<? extends Question> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.member = inits.isInitialized("member") ? new com.vivarepublica.vivastackoverflow.domain.member.entity.QMember(forProperty("member")) : null;
    }

}

