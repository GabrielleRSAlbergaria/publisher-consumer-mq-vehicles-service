package com.grs.models;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(
        name = "vehicle",
        schema = "auto_maia"
)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class VehicleModel {

    @Id
    @Column(length = 36)
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;

    @Column
    private String marca;

    @Column
    private String modelo;

    @Column
    private Boolean disponivel;
}
