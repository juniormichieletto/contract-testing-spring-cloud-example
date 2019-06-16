package com.fintech.creditcheckservice.service;

import com.fintech.creditcheckservice.controller.CreditCheckResponse;
import com.fintech.creditcheckservice.domain.Score;
import org.springframework.stereotype.Service;

@Service
public class CreditCheckService {

    public CreditCheckResponse doCreditCheck(int citizenNumber) {
        if (citizenNumber > 1230)
            return new CreditCheckResponse(Score.HIGH);

        return new CreditCheckResponse(Score.LOW);
    }
}
