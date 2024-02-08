package com.zerobase.convpay_new.service;

import com.zerobase.convpay_new.dto.PayRequest;

public interface DiscountInterface {
    Integer getDiscountedAmount(PayRequest payRequest);
}
