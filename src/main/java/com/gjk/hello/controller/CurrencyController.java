package com.gjk.hello.controller;
import com.gjk.hello.dto.CurrencyConversionRequest;
import com.gjk.hello.dto.CurrencyConversionResponse;
//import com.gjk.hello.dto.ExchangeRateResponse;
import com.gjk.hello.service.ExchangeRateService;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class CurrencyController {

    private final ExchangeRateService exchangeRateService;

    public CurrencyController(ExchangeRateService exchangeRateService) {
        this.exchangeRateService = exchangeRateService;
    }

    @GetMapping("/rates")
    public Map<String, Double> getExchangeRates(@RequestParam(defaultValue = "USD") String base) {
        return exchangeRateService.getExchangeRates(base);
    }

    @PostMapping("/convert")
    public CurrencyConversionResponse convertCurrency(@RequestBody CurrencyConversionRequest request) {
        double convertedAmount = exchangeRateService.convertCurrency(request.getFrom(), request.getTo(), request.getAmount());
        CurrencyConversionResponse response = new CurrencyConversionResponse();
        response.setFrom(request.getFrom());
        response.setTo(request.getTo());
        response.setAmount(request.getAmount());
        response.setConvertedAmount(convertedAmount);
        return response;
    }
}

