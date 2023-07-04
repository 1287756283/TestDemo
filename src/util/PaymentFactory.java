package util;

import entry.StrategyPattern.*;

import java.util.HashMap;
import java.util.Map;

public class PaymentFactory {
    private static final Map<PayTypeEnum, Payment> payStrategies = new HashMap<>();

    static {
        payStrategies.put(PayTypeEnum.WX, new WxPayment());
        payStrategies.put(PayTypeEnum.ALIPAY, new AlipayPayment());
        payStrategies.put(PayTypeEnum.BANK_CARD, new BankCardPayment());
    }

    public static Payment getPayment(PayTypeEnum payType) {
        if (payType == null) {
            throw new IllegalArgumentException("pay type is empty.");
        }
        if (!payStrategies.containsKey(payType)) {
            throw new IllegalArgumentException("pay type not supported.");
        }
        return payStrategies.get(payType);
    }

    public static void main(String[] args) {
        Payment payment = getPayment(PayTypeEnum.WX);
        System.out.println(payment.pay());
    }

}