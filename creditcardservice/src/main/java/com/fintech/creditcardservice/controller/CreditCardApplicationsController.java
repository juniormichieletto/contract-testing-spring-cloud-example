package com.fintech.creditcardservice.controller;

import com.fintech.creditcardservice.domain.CardType;
import com.fintech.creditcardservice.domain.CreditCardStatus;
import com.fintech.creditcardservice.domain.Score;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
public class CreditCardApplicationsController {

    private final RestTemplate restTemplate;
    private final String creditCheckServiceBaseUrl;

    public CreditCardApplicationsController(
        RestTemplate restTemplate,
        @Value("${creditcheckservice.baseurl}") String creditCheckServiceBaseUrl
    ) {
        this.restTemplate = restTemplate;
        this.creditCheckServiceBaseUrl = creditCheckServiceBaseUrl;
    }

    @PostMapping(
            value = "/credit-card-applications",
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public ApplyForCreditCardResponse applyForCreditCard(
            @RequestBody final ApplyForCreditCardRequest applyForCreditCardRequest
    ) {
        final Integer citizenNumber = applyForCreditCardRequest.getCitizenNumber();

        final String url = UriComponentsBuilder.fromHttpUrl(creditCheckServiceBaseUrl)
            .path("credit-scores")
            .toUriString();

        final CreditCheckResponse creditCheckResponse = restTemplate
            .postForObject(
                url,
                new CreditCheckRequest(citizenNumber),
                CreditCheckResponse.class);

        if (Score.HIGH == creditCheckResponse.getScore() &&
                CardType.GOLD == applyForCreditCardRequest.getCardType()) {

            return new ApplyForCreditCardResponse(CreditCardStatus.GRANTED);
        }
        throw new RuntimeException("Card and score not yet implemented");
    }

}
