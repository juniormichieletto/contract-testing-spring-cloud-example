package com.fintech.creditcardservice.gateway;

import com.fintech.creditcardservice.domain.Score;

public class CreditCheckResponse {
    private Score score;
    private String uuid;

    public Score getScore() {
        return score;
    }

    public void setScore(Score score) {
        this.score = score;
    }

    public String getUuid() {
        return uuid;
    }

    public CreditCheckResponse setUuid(String uuid) {
        this.uuid = uuid;
        return this;
    }
}
