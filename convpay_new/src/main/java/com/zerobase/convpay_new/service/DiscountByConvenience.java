package com.zerobase.convpay_new.service;

import com.zerobase.convpay_new.dto.PayRequest;

public class DiscountByConvenience implements DiscountInterface{
    @Override
    public Integer getDiscountedAmount(PayRequest payRequest) {
        switch (payRequest.getConvenienceType()) {

            case G25 -> {
                return payRequest.getPayAmount() * 8 / 10;
            }
            case GU -> {
                return payRequest.getPayAmount() * 9 / 10;
            }
            case SEVEN -> {
                return payRequest.getPayAmount();
            }
        }
        return payRequest.getPayAmount();
    }
}
