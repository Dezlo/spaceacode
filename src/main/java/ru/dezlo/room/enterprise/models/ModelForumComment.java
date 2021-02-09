package ru.dezlo.room.enterprise.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Formula;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "forum_comment")
public class ModelForumComment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "author_id")
    private Integer authorId;

    @Formula("(select u.nickname from users u where u.id = author_id)")
    private String nickname;

    @Column(name = "message")
    private String message;

    @Column(name = "date_created")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Europe/Moscow")
    private Date dateCreated;

    @Formula("(select now()::timestamp - a.date_created::timestamp from forum_comment a where a.id = id)")
    private String timeAfter;

    @Column(name = "article_id")
    private Integer articleId;


}
