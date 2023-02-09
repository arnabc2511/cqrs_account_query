package com.techbank.account.query.infrastruture.consumers;

import com.techbank.account.common.events.AccountClosedEvent;
import com.techbank.account.common.events.AccountOpenedEvent;
import com.techbank.account.common.events.FundDepositedEvent;
import com.techbank.account.common.events.FundsWithdrawnEvent;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.messaging.handler.annotation.Payload;

public interface EventConsumer {

    void consume(@Payload AccountOpenedEvent event, Acknowledgment acknowledgment);
    void consume(@Payload FundDepositedEvent event, Acknowledgment acknowledgment);
    void consume(@Payload FundsWithdrawnEvent event, Acknowledgment acknowledgment);
    void consume(@Payload AccountClosedEvent event, Acknowledgment acknowledgment);
}
