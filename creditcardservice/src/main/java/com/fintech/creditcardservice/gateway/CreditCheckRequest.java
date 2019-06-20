package com.fintech.creditcardservice.gateway;

import java.time.LocalDate;

public class CreditCheckRequest {

    private final int citizenNumber;
    private final String requestDate = LocalDate.now().toString();

    public CreditCheckRequest(int citizenNumber) {
        this.citizenNumber = citizenNumber;
    }

    public int getCitizenNumber() {
        return citizenNumber;
    }

    public String getRequestDate() {
        return requestDate;
    }
}
