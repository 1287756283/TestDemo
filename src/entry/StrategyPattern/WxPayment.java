package entry.StrategyPattern;

public class WxPayment implements Payment {
    @Override
    public String pay() {
        System.out.println("Wechat payment.");
        return "Wechat payment";
    }

    @Override
    public PayTypeEnum getPayType() {
        return PayTypeEnum.WX;
    }
}
