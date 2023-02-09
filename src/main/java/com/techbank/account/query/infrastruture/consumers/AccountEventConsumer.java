package com.techbank.account.query.infrastruture.consumers;

import com.techbank.account.common.events.AccountClosedEvent;
import com.techbank.account.common.events.AccountOpenedEvent;
import com.techbank.account.common.events.FundDepositedEvent;
import com.techbank.account.common.events.FundsWithdrawnEvent;
import com.techbank.account.query.infrastruture.handlers.EventHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Service;

@Service
public class AccountEventConsumer implements  EventConsumer{
    @Autowired
    private EventHandler eventHandler;
    /**
     * @param event
     * @param acknowledgment
     */
    @KafkaListener(topics = "AccountOpenedEvent",groupId = "${spring.kafka.consumer.group-id}")
    @Override
    public void consume(AccountOpenedEvent event, Acknowledgment acknowledgment) {
        eventHandler.on(event);
        acknowledgment.acknowledge();
    }

    /**
     * @param event
     * @param acknowledgment
     */
    @KafkaListener(topics = "FundDepositedEvent",groupId = "${spring.kafka.consumer.group-id}")
    @Override
    public void consume(FundDepositedEvent event, Acknowledgment acknowledgment) {
        eventHandler.on(event);
        acknowledgment.acknowledge();
    }

    /**
     * @param event
     * @param acknowledgment
     */
    @KafkaListener(topics = "FundsWithdrawnEvent",groupId = "${spring.kafka.consumer.group-id}")
    @Override
    public void consume(FundsWithdrawnEvent event, Acknowledgment acknowledgment) {
        eventHandler.on(event);
        acknowledgment.acknowledge();
    }

    /**
     * @param event
     * @param acknowledgment
     */
    @KafkaListener(topics = "AccountClosedEvent",groupId = "${spring.kafka.consumer.group-id}")
    @Override
    public void consume(AccountClosedEvent event, Acknowledgment acknowledgment) {
        eventHandler.on(event);
        acknowledgment.acknowledge();
    }
}
