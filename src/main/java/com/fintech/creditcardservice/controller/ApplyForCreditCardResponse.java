package com.fintech.creditcardservice.controller;

import com.fintech.creditcardservice.domain.CreditCardStatus;

public class ApplyForCreditCardResponse {

    private final CreditCardStatus status;

    public ApplyForCreditCardResponse(CreditCardStatus status) {
        this.status = status;
    }

    public CreditCardStatus getStatus() {
        return status;
    }
}
