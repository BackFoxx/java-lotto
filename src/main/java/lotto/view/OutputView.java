package lotto.view;

import lotto.domain.ScoreInfo;
import lotto.vo.Lotto;
import lotto.vo.LottoBuyingInfo;

import java.util.List;

public interface OutputView {
	void printLottoBuyingInfo(LottoBuyingInfo lottoBuyingInfo);

	void printLottos(List<Lotto> lottos);

	void printErrorMessage(Exception e);

	void printScoreMessage(ScoreInfo scoreInfo);

    void printProfitPercentageMessage(double profit);
}
