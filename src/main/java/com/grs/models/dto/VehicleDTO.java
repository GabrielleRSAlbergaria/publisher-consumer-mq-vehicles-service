package com.grs.models.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class VehicleDTO implements Serializable {

    private String marca;
    private String modelo;
    private Boolean disponivel;
}
