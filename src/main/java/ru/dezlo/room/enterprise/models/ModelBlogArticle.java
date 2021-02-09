package ru.dezlo.room.enterprise.models;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Formula;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "blog_article")
public class ModelBlogArticle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "author_id")
    private Integer authorId;

    @Formula("(select u.nickname from users u where u.id = author_id)")
    private String nickname;

    private String title;

    private String article;

    @Column(name = "date_created")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Europe/Moscow")
    private Date dateCreated;

    @Formula("(select now()::timestamp - a.date_created::timestamp from blog_article a where a.id = id)")
    private String timeAfter;

    @Column(name = "hash_tag_id")
    private Integer hashTagId;

    @Formula("(select h.hash_tag from hash_tags h where h.id = hash_tag_id)")
    private String hashTagName;

    @Builder.Default
    @JsonSerialize
    private Integer views = 0;

}