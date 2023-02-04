package lotto;

import lotto.system.ControllerHolder;
import lotto.system.ControllerName;

public class LottoApplication {
    public void run() {
        ControllerHolder controllerHolder = new ControllerHolder();
        controllerHolder.run(ControllerName.MONEY);
    }
}
