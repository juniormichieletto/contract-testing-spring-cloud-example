package com.fintech.creditcardservice.service;

import com.fintech.creditcardservice.controller.ApplyForCreditCardRequest;
import com.fintech.creditcardservice.controller.ApplyForCreditCardResponse;
import com.fintech.creditcardservice.domain.CardType;
import com.fintech.creditcardservice.domain.CardStatus;
import com.fintech.creditcardservice.domain.Score;
import com.fintech.creditcardservice.gateway.CreditCheckGateway;
import com.fintech.creditcardservice.gateway.CreditCheckResponse;
import org.springframework.stereotype.Service;

@Service
public class CreditCheckService {

    private final CreditCheckGateway creditCheckGateway;

    public CreditCheckService(CreditCheckGateway creditCheckGateway) {
        this.creditCheckGateway = creditCheckGateway;
    }

    public ApplyForCreditCardResponse doCheckForCitizen(ApplyForCreditCardRequest applyForCreditCardRequest) {

        final CreditCheckResponse creditCheckResponse =
            creditCheckGateway.doCreditCheckForCitizen(applyForCreditCardRequest.getCitizenNumber());

        final Score score = creditCheckResponse.getScore();
        final String uuid = creditCheckResponse.getUuid();

        if (score == Score.HIGH && applyForCreditCardRequest.getCardType() == CardType.GOLD) {
            return new ApplyForCreditCardResponse(CardStatus.GRANTED, uuid);
        }
        return new ApplyForCreditCardResponse(CardStatus.DENIED, uuid);
    }
}
