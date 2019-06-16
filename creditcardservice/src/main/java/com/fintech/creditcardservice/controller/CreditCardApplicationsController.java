package com.fintech.creditcardservice.controller;

import com.fintech.creditcardservice.domain.CardType;
import com.fintech.creditcardservice.domain.CreditCardStatus;
import com.fintech.creditcardservice.domain.Score;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CreditCardApplicationsController {

    private final RestTemplate restTemplate;

    public CreditCardApplicationsController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @PostMapping(
            value = "/credit-card-applications",
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public ApplyForCreditCardResponse applyForCreditCard(
            @RequestBody final ApplyForCreditCardRequest applyForCreditCardRequest
    ) {
        final Integer citizenNumber = applyForCreditCardRequest.getCitizenNumber();
        final CreditCheckResponse creditCheckResponse = restTemplate
                .postForObject(
                        "http://localhost:8080/credit-scores",
                        new CreditCheckRequest(citizenNumber),
                        CreditCheckResponse.class);

        if (Score.HIGH == creditCheckResponse.getScore() &&
                CardType.GOLD == applyForCreditCardRequest.getCardType()) {
            return new ApplyForCreditCardResponse(CreditCardStatus.GRANTED);
        }
        throw new RuntimeException("Card and score not yet implemented");
    }

}
