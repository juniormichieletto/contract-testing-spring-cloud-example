package com.fintech.creditcardservice.controller;

import com.fintech.creditcardservice.domain.Score;

public class CreditCheckResponse {
    private Score score;

    public Score getScore() {
        return score;
    }

    public void setScore(Score score) {
        this.score = score;
    }
}
