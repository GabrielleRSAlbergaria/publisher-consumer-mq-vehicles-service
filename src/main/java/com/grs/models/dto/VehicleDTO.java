package com.grs.models.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
@Builder
public class VehicleDTO implements Serializable {

    private String marca;
    private String modelo;
    private Boolean disponivel;
}
