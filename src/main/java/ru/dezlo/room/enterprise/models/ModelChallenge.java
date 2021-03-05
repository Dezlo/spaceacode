package ru.dezlo.room.enterprise.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Formula;

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

    @Builder.Default
    @Column(name = "date_created")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "UTC-3")
    private Date dateCreated = new Date();

    @Column(name = "time_interval")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "UTC-3")
    private Date timeInterval;

    @Formula("(select a.time_interval - now() +'-03:00  ' from challenge a where a.id = id)")
    private String timeLeft;

    @Column(name = "description")
    private String description;
}
