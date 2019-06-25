package com.fintech.creditcheckservice.controller;

import com.fintech.creditcheckservice.domain.Score;

import java.util.UUID;

public class CreditCheckResponse {

    private String uuid = UUID.randomUUID().toString();
    private Score score;

    public CreditCheckResponse(Score score) {
        this.score = score;
    }

    public String getUuid() {
        return uuid;
    }

    public Score getScore() {
        return score;
    }

    public void setScore(Score score) {
        this.score = score;
    }
}
