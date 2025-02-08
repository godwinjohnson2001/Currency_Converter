package com.gjk.hello.service;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import com.gjk.hello.dto.ExchangeRateResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

class ExchangeRateServiceTest {

    @InjectMocks
    private ExchangeRateService exchangeRateService;

    @Mock
    private RestTemplate restTemplate;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetExchangeRates() {
        ExchangeRateResponse mockResponse = new ExchangeRateResponse();
        mockResponse.setRates(Map.of("EUR", 0.94, "GBP", 0.82));
        when(restTemplate.getForObject(anyString(), eq(ExchangeRateResponse.class)))
                .thenReturn(mockResponse);

        Map<String, Double> rates = exchangeRateService.getExchangeRates("USD");
        assertNotNull(rates);
        assertEquals(0.94, rates.get("EUR"));
    }

    @Test
    void testConvertCurrency() {
        ExchangeRateService service = spy(new ExchangeRateService());
        doReturn(Map.of("EUR", 0.94)).when(service).getExchangeRates("USD");

        double convertedAmount = service.convertCurrency("USD", "EUR", 100);
        assertEquals(94.0, convertedAmount);
    }
}


