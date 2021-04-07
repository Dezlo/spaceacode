package ru.dezlo.room.core.models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "hash_tags")
public class ModelHashTag {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer hashTagId;

    @Column(name = "hash_tag")
    private String hashTagName;

}
