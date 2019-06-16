package com.fintech.creditcheckservice;

import com.fintech.creditcheckservice.controller.CreditCheckController;
import com.fintech.creditcheckservice.controller.CreditCheckResponse;
import com.fintech.creditcheckservice.service.CreditCheckService;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.Before;

import static com.fintech.creditcheckservice.domain.Score.HIGH;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class BaseContractTest {

    @Before
    public void setUp() {
        final CreditCheckService mock = mock(CreditCheckService.class);

        when(mock.doCreditCheck(1234))
            .thenReturn(new CreditCheckResponse(HIGH));

        RestAssuredMockMvc
            .standaloneSetup(new CreditCheckController(mock));
    }
}
