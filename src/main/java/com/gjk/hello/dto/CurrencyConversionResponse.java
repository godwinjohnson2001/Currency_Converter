package com.gjk.hello.dto;
import lombok.Data;

@Data
public class CurrencyConversionResponse {
    private String from;
    private String to;
    private double amount;
    private double convertedAmount;
}

