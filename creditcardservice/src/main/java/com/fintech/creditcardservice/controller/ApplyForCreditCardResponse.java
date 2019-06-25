package com.fintech.creditcardservice.controller;

import com.fintech.creditcardservice.domain.CardStatus;

public class ApplyForCreditCardResponse {

    private final CardStatus status;
    private final String uuid;

    public ApplyForCreditCardResponse(CardStatus status, String uuid) {
        this.status = status;
        this.uuid = uuid;
    }

    public CardStatus getStatus() {
        return status;
    }

    public String getUuid() {
        return uuid;
    }
}
