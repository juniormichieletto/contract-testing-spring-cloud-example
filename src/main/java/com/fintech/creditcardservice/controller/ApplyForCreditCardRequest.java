package com.fintech.creditcardservice.controller;

import com.fintech.creditcardservice.domain.CardType;

public class ApplyForCreditCardRequest {

    private Integer citizenNumber;
    private CardType cardType;

    public Integer getCitizenNumber() {
        return citizenNumber;
    }

    public void setCitizenNumber(int citizenNumber) {
        this.citizenNumber = citizenNumber;
    }

    public CardType getCardType() {
        return cardType;
    }

    public void setCardType(CardType cardType) {
        this.cardType = cardType;
    }

}
