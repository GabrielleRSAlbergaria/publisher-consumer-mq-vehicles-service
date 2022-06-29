package com.grs.consumers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.grs.constants.RabbitmqConstants;
import com.grs.models.dto.VehicleDTO;
import com.grs.services.VehicleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class VehiclesConsumer {
    @Autowired
    private VehicleService vehicleService;

    @RabbitListener(queues = RabbitmqConstants.QUEUE_VEHICLE)
    private void consumer(String mensagem) throws Exception {
        var vehicle = new ObjectMapper().readValue(mensagem, VehicleDTO.class);
        log.info("Read object: {}", vehicle);
        vehicleService.saveVehicleDTO(vehicle);
    }
}
