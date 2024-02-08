package com.zerobase.convpay_new.service;

import com.zerobase.convpay_new.dto.PayRequest;
import com.zerobase.convpay_new.type.ConvenienceType;
import com.zerobase.convpay_new.type.PayMethodType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DiscountByPayMethodTest {
    DiscountByPayMethod discountByPayMethod = new DiscountByPayMethod();

    @Test
        void discountSuccess() {
            //given
        PayRequest payRequestMoney = new PayRequest(PayMethodType.MONEY,
                ConvenienceType.G25,1000);
        PayRequest payRequestCard = new PayRequest(PayMethodType.CARD,
                ConvenienceType.G25,1000);
            //when
        Integer discountAmountMoney = discountByPayMethod.getDiscountedAmount(payRequestMoney);
        Integer discountAmountCard = discountByPayMethod.getDiscountedAmount(payRequestCard);
            //then
        assertEquals(700,discountAmountMoney);
        assertEquals(1000,discountAmountCard);
        }

}