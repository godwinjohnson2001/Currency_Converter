package com.gjk.hello.dto;
import lombok.Data;

@Data
public class CurrencyConversionRequest {
    private String from;
    private String to;
    private double amount;
}

