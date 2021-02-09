package ru.dezlo.room.enterprise.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@IdClass(ModelForumCommentLike.class)
@Table(name = "forum_comment_like")
public class ModelForumCommentLike implements Serializable {
    @Id
    @Column(name = "user_id")
    private Integer userId;

    @Id
    @Column(name = "comment_id")
    private Integer commentId;

}
