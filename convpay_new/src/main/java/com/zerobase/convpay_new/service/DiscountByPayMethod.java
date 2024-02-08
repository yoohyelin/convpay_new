package com.zerobase.convpay_new.service;

import com.zerobase.convpay_new.dto.PayRequest;

public class DiscountByPayMethod implements DiscountInterface{
    @Override
    public Integer getDiscountedAmount(PayRequest payRequest) {
        switch (payRequest.getPayMethodType()) {

            case MONEY -> {
                return payRequest.getPayAmount() * 7 /10;
            }
            case CARD -> {
                return payRequest.getPayAmount();
            }
        }
        return payRequest.getPayAmount();
    }
}
