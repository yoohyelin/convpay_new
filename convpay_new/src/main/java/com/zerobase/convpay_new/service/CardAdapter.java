package com.zerobase.convpay_new.service;

import com.zerobase.convpay_new.type.CancelPaymentResult;
import com.zerobase.convpay_new.type.CardUseCancelResult;
import com.zerobase.convpay_new.type.CardUseResult;
import com.zerobase.convpay_new.type.PaymentResult;

public class CardAdapter implements PaymentInterface{
    // 1.인증
    public void authorization() {
        System.out.println("authorization success.");
    }
    //2. 승인
    public void approval() {
        System.out.println("approval success.");

    }
    //3. 매입
    public CardUseResult capture(Integer payAmount) {
        if(payAmount > 100) {
            return CardUseResult.USE_FAIL;
        }
        return CardUseResult.USE_SUCCESS;
    }
    // 매입 취소
    public CardUseCancelResult cancelCapture(Integer cancelAmount) {
        if(cancelAmount < 1000) {
            return CardUseCancelResult.USE_CANCEL_FAIL;
        }
        return CardUseCancelResult.USE_CANCEL_SUCCESS;
    }

    @Override
    public PaymentResult payment(Integer payAmount) {
        authorization();
        approval();
        CardUseResult cardUseResult = capture(payAmount);

        if(cardUseResult == CardUseResult.USE_FAIL) {
            return PaymentResult.PAYMENT_FAIL;
        }
        return PaymentResult.PAYMENT_SUCCESS;
    }

    @Override
    public CancelPaymentResult cancelPayment(Integer cancelAmount) {
        CardUseCancelResult cardUseCancelResult = cancelCapture(cancelAmount);

        if(cardUseCancelResult == CardUseCancelResult.USE_CANCEL_FAIL) {
            return CancelPaymentResult.CANCEL_PAYMENT_FAIL;
        }

        return CancelPaymentResult.CANCEL_PAYMENT_SUCCESS;
    }
}
