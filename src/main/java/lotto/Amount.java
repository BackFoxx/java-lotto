package lotto;

public class Amount {
    private final Long money;
    private final Long amount;

    public Amount(Long money) {
        this.money = money;
        this.amount = money / 1000;
    }

    public Long getAmount() {
        return amount;
    }
}
