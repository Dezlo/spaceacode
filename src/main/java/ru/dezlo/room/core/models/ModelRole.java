package ru.dezlo.room.core.models;

import lombok.Data;

import javax.persistence.*;


@Entity
@Table(name = "users_role")
@Data
public class ModelRole {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
}