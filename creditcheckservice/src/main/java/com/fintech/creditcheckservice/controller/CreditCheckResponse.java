package com.fintech.creditcheckservice.controller;

import com.fintech.creditcheckservice.domain.Score;

public class CreditCheckResponse {

    private Score score;

    public CreditCheckResponse(Score score) {
        this.score = score;
    }

    public Score getScore() {
        return score;
    }

    public void setScore(Score score) {
        this.score = score;
    }
}
