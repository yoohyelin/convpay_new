package com.zerobase.convpay_new.service;

import com.zerobase.convpay_new.dto.PayRequest;
import com.zerobase.convpay_new.type.ConvenienceType;
import com.zerobase.convpay_new.type.PayMethodType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DiscountByConvenienceTest {
    DiscountByConvenience discountByConvenience = new DiscountByConvenience();
    @Test
        void discountTest() {
            //given
        PayRequest payRequestG25 = new PayRequest(PayMethodType.MONEY, ConvenienceType.G25,1000);
        PayRequest payRequestGU = new PayRequest(PayMethodType.MONEY, ConvenienceType.GU,1000);
        PayRequest payRequestSEVEN = new PayRequest(PayMethodType.MONEY, ConvenienceType.SEVEN,1000);
            //when
        Integer discountAmountG25 = discountByConvenience.getDiscountedAmount(payRequestG25);
        Integer discountAmountGU = discountByConvenience.getDiscountedAmount(payRequestGU);
        Integer discountAmountSeven = discountByConvenience.getDiscountedAmount(payRequestSEVEN);
            //then
        assertEquals(800,discountAmountG25);
        assertEquals(900,discountAmountGU);
        assertEquals(1000,discountAmountSeven);
        }

}