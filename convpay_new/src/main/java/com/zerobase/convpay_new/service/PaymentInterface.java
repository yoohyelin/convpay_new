package com.zerobase.convpay_new.service;

import com.zerobase.convpay_new.type.CancelPaymentResult;
import com.zerobase.convpay_new.type.PaymentResult;

public interface PaymentInterface {
    // if else 로 하면 지저분하기 때문에 존재

    PaymentResult payment(Integer payAmount);
    public CancelPaymentResult cancelPayment(Integer cancelAmount);
}
