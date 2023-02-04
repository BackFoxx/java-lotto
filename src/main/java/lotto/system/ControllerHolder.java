package lotto.system;

import lotto.MoneyController;

import java.util.HashMap;
import java.util.Map;

public class ControllerHolder {
    private final Map<ControllerName, Controller> holder = new HashMap<>();

    public ControllerHolder() {
        holder.put(ControllerName.MONEY, new MoneyController());
    }

    public void run(ControllerName controllerName) {
        holder.get(controllerName).run();
    }
}
