package lotto;

import lotto.inputview.MoneyInputView;
import lotto.outputview.LottoOutputView;
import lotto.outputview.MoneyOutputView;
import lotto.system.Controller;

public class MoneyController implements Controller {
    @Override
    public void run() {
        MoneyOutputView.print();
        Amount amount = MoneyInputView.getInput();

        LottoOutputView.printAmount(amount);
        LottoService.makeLotto(amount);
    }
}
