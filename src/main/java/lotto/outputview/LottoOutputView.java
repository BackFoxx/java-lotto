package lotto.outputview;

import lotto.Amount;

public class LottoOutputView {
    public static void printAmount(Amount amount) {
        System.out.printf("%d개를 구매했습니다.%n", amount.getAmount());
    }
}
