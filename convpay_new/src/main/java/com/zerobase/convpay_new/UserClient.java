package com.zerobase.convpay_new;

import com.zerobase.convpay_new.dto.PayCancelRequest;
import com.zerobase.convpay_new.dto.PayCancelResponse;
import com.zerobase.convpay_new.dto.PayRequest;
import com.zerobase.convpay_new.dto.PayResponse;
import com.zerobase.convpay_new.service.ConveniencePayService;
import com.zerobase.convpay_new.type.ConvenienceType;
import com.zerobase.convpay_new.type.PayMethodType;

public class UserClient {
    public static void main(String[] args) {
        // 사용자 -> 편결이 -> 머니

        ConveniencePayService conveniencePayService = new ConveniencePayService();

        // G25, 결제 1000원
        PayRequest payRequest = new PayRequest(PayMethodType.CARD, ConvenienceType.G25,1000);
        PayResponse payResponse = conveniencePayService.pay(payRequest);

        System.out.println(payResponse);
        // G25, 취소 500원
        PayCancelRequest payCancelRequest = new PayCancelRequest(PayMethodType.MONEY, ConvenienceType.G25,500);
        PayCancelResponse payCancelResponse = conveniencePayService.payCancel(payCancelRequest);

        System.out.println(payCancelResponse);

    }
}
