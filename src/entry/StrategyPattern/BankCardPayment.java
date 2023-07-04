package entry.StrategyPattern;

public class BankCardPayment implements Payment {
    @Override
    public String pay() {
        System.out.println("Bank card payment.");
        return "Bank card payment";
    }

    @Override
    public PayTypeEnum getPayType() {
        return PayTypeEnum.BANK_CARD;
    }
}
