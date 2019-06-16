package com.fintech.creditcardservice.service;

import com.fintech.creditcardservice.controller.ApplyForCreditCardRequest;
import com.fintech.creditcardservice.controller.ApplyForCreditCardResponse;
import com.fintech.creditcardservice.domain.CardType;
import com.fintech.creditcardservice.domain.CardStatus;
import com.fintech.creditcardservice.domain.Score;
import com.fintech.creditcardservice.gateway.CreditCheckGateway;
import org.springframework.stereotype.Service;

@Service
public class CreditCheckService {

    private final CreditCheckGateway creditCheckGateway;

    public CreditCheckService(CreditCheckGateway creditCheckGateway) {
        this.creditCheckGateway = creditCheckGateway;
    }

    public ApplyForCreditCardResponse doCheckForCitizen(ApplyForCreditCardRequest applyForCreditCardRequest) {

        final Score score = creditCheckGateway.doCreditCheckForCitizen(applyForCreditCardRequest.getCitizenNumber());

        if (score == Score.HIGH && applyForCreditCardRequest.getCardType() == CardType.GOLD) {
            return new ApplyForCreditCardResponse(CardStatus.GRANTED);
        }
        throw new RuntimeException("Card and score not yet implemented");
    }
}
