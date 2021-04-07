package ru.dezlo.room.core.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@IdClass(ModelUserToClan.class)
@Table(name = "user_to_clan")
public class ModelUserToClan implements Serializable {
    @Id
    @Column(name = "user_id")
    private Integer userId;

    @Id
    @Column(name = "clan_id")
    private Integer clanId;

}
