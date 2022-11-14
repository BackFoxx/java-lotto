package lotto.system;

import lotto.controller.LottoController;
import lotto.service.LottoService;
import lotto.service.LottoServiceImpl;
import lotto.view.InputView;
import lotto.view.InputViewImpl;
import lotto.view.OutputView;
import lotto.view.OutputViewImpl;

public class LottoApplication {
	private LottoController lottoController;
	private LottoService lottoService;
	private InputView inputView;
	private OutputView outputView;

	public void run() {
		doSetting();
		try {
			lottoController.runLotto();
		} catch (IllegalArgumentException exception) {
			outputView.printErrorMessage(exception);
		}
	}

	private void doSetting() {
		inputView = new InputViewImpl();
		outputView = new OutputViewImpl();
		lottoService = new LottoServiceImpl();
		lottoController = new LottoController(inputView, outputView, lottoService);
	}
}
