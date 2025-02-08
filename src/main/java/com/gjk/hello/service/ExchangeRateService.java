package com.gjk.hello.service;
import com.gjk.hello.dto.ExchangeRateResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Service
public class ExchangeRateService {
    
    @Value("${exchange.api.url}")
    private String apiUrl;
    
    private final RestTemplate restTemplate = new RestTemplate();

    public Map<String, Double> getExchangeRates(String baseCurrency) {
        String url = apiUrl + "?base=" + baseCurrency;
        ExchangeRateResponse response = restTemplate.getForObject(url, ExchangeRateResponse.class);
        if (response == null || response.getRates() == null) {
            throw new RuntimeException("Failed to fetch exchange rates");
        }
        return response.getRates();
    }

    public double convertCurrency(String from, String to, double amount) {
        Map<String, Double> rates = getExchangeRates(from);
        if (!rates.containsKey(to)) {
            throw new IllegalArgumentException("Invalid target currency: " + to);
        }
        return amount * rates.get(to);
    }
}

