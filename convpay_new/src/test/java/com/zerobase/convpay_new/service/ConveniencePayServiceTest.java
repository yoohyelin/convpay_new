package com.zerobase.convpay_new.service;

import com.zerobase.convpay_new.dto.PayCancelRequest;
import com.zerobase.convpay_new.dto.PayCancelResponse;
import com.zerobase.convpay_new.type.ConvenienceType;
import com.zerobase.convpay_new.dto.PayRequest;
import com.zerobase.convpay_new.dto.PayResponse;
import com.zerobase.convpay_new.type.PayCancelResult;
import com.zerobase.convpay_new.type.PayMethodType;
import com.zerobase.convpay_new.type.PayResult;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConveniencePayServiceTest {
    ConveniencePayService conveniencePayService = new ConveniencePayService();
    @Test
        void pay_success() {
            //given
        PayRequest payRequest = new PayRequest(PayMethodType.MONEY,ConvenienceType.G25,50);
            //when
        PayResponse payResponse = conveniencePayService.pay(payRequest);
            //then
        assertEquals(PayResult.SUCCESS,payResponse.getPayResult());
        assertEquals(35,payResponse.getPaidAmount());
        }
    @Test
    void pay_fail() {
        //given
        PayRequest payRequest = new PayRequest(PayMethodType.MONEY,ConvenienceType.G25,1500_001);
        //when
        PayResponse payResponse = conveniencePayService.pay(payRequest);
        //then
        assertEquals(PayResult.FAIL,payResponse.getPayResult());
        assertEquals(0,payResponse.getPaidAmount());
    }
    @Test
    void pay_cancel_success() {
        //given
        PayCancelRequest payCancelRequest = new PayCancelRequest(PayMethodType.MONEY,ConvenienceType.G25,1000);
        //when
        PayCancelResponse payCancelResponse = conveniencePayService.payCancel(payCancelRequest);
        //then
        assertEquals(PayCancelResult.PAY_CANCEL_SUCCESS,payCancelResponse.getPayCancelResult());
        assertEquals(1000,payCancelResponse.getPayCanceledAmount());
    }
    @Test
    void pay_cancel_fail() {
        //given
        PayCancelRequest payCancelRequest = new PayCancelRequest(PayMethodType.MONEY,ConvenienceType.G25,99);
        //when
        PayCancelResponse payCancelResponse = conveniencePayService.payCancel(payCancelRequest);
        //then
        assertEquals(PayCancelResult.PAY_CANCEL_FAIL,payCancelResponse.getPayCancelResult());
        assertEquals(0,payCancelResponse.getPayCanceledAmount());
    }
}