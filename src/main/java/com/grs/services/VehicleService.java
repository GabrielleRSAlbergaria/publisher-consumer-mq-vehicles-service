package com.grs.services;

import com.grs.constants.RabbitmqConstants;
import com.grs.models.VehicleModel;
import com.grs.models.dto.VehicleDTO;
import com.grs.repositories.VehicleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class VehicleService {
    @Autowired
    private VehicleRepository vehicleRepository;
    @Autowired
    private RabbitmqService rabbitmqService;

    public void saveVehicleDTO(VehicleDTO vehicleDTO) {
        var vehicleModel = VehicleModel.builder()
                .marca(vehicleDTO.getMarca())
                .modelo(vehicleDTO.getModelo())
                .disponivel(vehicleDTO.getDisponivel())
                .build();
        vehicleRepository.save(vehicleModel);

    }

    public void sendVehicleToQueue(VehicleDTO vehicleDTO) {
        rabbitmqService.postMessage(RabbitmqConstants.QUEUE_VEHICLE, vehicleDTO);
    }
}
