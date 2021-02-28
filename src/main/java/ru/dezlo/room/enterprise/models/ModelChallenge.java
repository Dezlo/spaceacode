package ru.dezlo.room.enterprise.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "challenge")
@Entity
public class ModelChallenge {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "hash_tag_id")
    private Integer hashTagId;

    @Column(name = "title")
    private String title;

    @Column(name = "date_created")
    private Date dateCreated;

    @Column(name = "time_interval")
    private Date timeInterval;

    @Column(name = "description")
    private String description;
}
