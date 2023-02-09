package com.techbank.account.query.infrastruture.handlers;

import com.techbank.account.common.events.AccountClosedEvent;
import com.techbank.account.common.events.AccountOpenedEvent;
import com.techbank.account.common.events.FundDepositedEvent;
import com.techbank.account.common.events.FundsWithdrawnEvent;

public interface EventHandler {

    void on(AccountOpenedEvent event);
    void on(FundDepositedEvent event);
    void on(FundsWithdrawnEvent event);
    void on(AccountClosedEvent event);
}
