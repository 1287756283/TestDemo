package entry.StrategyPattern;

public class AlipayPayment implements Payment {
    @Override
    public String pay() {
        System.out.println("Alipay payment.");
        return "Alipay payment";
    }

    @Override
    public PayTypeEnum getPayType() {
        return PayTypeEnum.ALIPAY;
    }
}
