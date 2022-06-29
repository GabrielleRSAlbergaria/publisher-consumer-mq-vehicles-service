package com.grs.configurations;

import com.grs.constants.RabbitmqConstants;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class RabbitMQConection {
    private static final String NOME_EXCHANGE = "amq.direct";

    private AmqpAdmin amqpAdmin;

    public RabbitMQConection(AmqpAdmin amqpAdmin) {
        this.amqpAdmin = amqpAdmin;
    }

    private Queue queue(String queueName) {
        return new Queue(queueName, true, false, false);
    }

    private DirectExchange directExchange() {
        return new DirectExchange(NOME_EXCHANGE);
    }

    private Binding binding(Queue fila, DirectExchange troca) {
        return new Binding(fila.getName(), Binding.DestinationType.QUEUE, troca.getName(), fila.getName(), null);
    }

    @PostConstruct
    private void add() {
        Queue queueVehicles = this.queue(RabbitmqConstants.QUEUE_VEHICLE);

        DirectExchange exchange = this.directExchange();

        Binding bindindVehicles = this.binding(queueVehicles, exchange);

        //Create a queue in RabbitMQ
        this.amqpAdmin.declareQueue(queueVehicles);

        this.amqpAdmin.declareExchange(exchange);

        this.amqpAdmin.declareBinding(bindindVehicles);
    }
}