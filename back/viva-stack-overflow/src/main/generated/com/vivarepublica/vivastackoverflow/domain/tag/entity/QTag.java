package com.vivarepublica.vivastackoverflow.domain.tag.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QTag is a Querydsl query type for Tag
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QTag extends EntityPathBase<Tag> {

    private static final long serialVersionUID = -1267840649L;

    public static final QTag tag = new QTag("tag");

    public final SetPath<com.vivarepublica.vivastackoverflow.domain.question.entity.Question, com.vivarepublica.vivastackoverflow.domain.question.entity.QQuestion> questions = this.<com.vivarepublica.vivastackoverflow.domain.question.entity.Question, com.vivarepublica.vivastackoverflow.domain.question.entity.QQuestion>createSet("questions", com.vivarepublica.vivastackoverflow.domain.question.entity.Question.class, com.vivarepublica.vivastackoverflow.domain.question.entity.QQuestion.class, PathInits.DIRECT2);

    public final NumberPath<Long> tagId = createNumber("tagId", Long.class);

    public final EnumPath<HashTag> tagName = createEnum("tagName", HashTag.class);

    public QTag(String variable) {
        super(Tag.class, forVariable(variable));
    }

    public QTag(Path<? extends Tag> path) {
        super(path.getType(), path.getMetadata());
    }

    public QTag(PathMetadata metadata) {
        super(Tag.class, metadata);
    }

}

