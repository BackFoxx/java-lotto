package lotto;

import lotto.inputview.MoneyInputView;
import lotto.outputview.MoneyOutputView;
import lotto.system.Controller;

public class MoneyController implements Controller {
    @Override
    public void run() {
        MoneyOutputView.print();
        MoneyInputView.getInput();
    }
}
