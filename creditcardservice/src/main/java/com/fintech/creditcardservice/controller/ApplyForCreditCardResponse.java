package com.fintech.creditcardservice.controller;

import com.fintech.creditcardservice.domain.CardStatus;

public class ApplyForCreditCardResponse {

    private final CardStatus status;

    public ApplyForCreditCardResponse(CardStatus status) {
        this.status = status;
    }

    public CardStatus getStatus() {
        return status;
    }
}
