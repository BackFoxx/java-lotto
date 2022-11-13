package lotto.view;

import lotto.domain.ScoreInfo;
import lotto.vo.Lotto;
import lotto.vo.LottoBuyingInfo;
import lotto.vo.Score;

import java.text.DecimalFormat;
import java.util.List;

public class OutputViewImpl implements OutputView {

	public static final String ERROR_MESSAGE_FORMAT = "[ERROR] %s";
	public static final String BUYED_LOTTO_AMOUNT_MESSAGE_FORMAT = "%d개를 구매했습니다.";

	@Override
	public void printLottoBuyingInfo(LottoBuyingInfo lottoBuyingInfo) {
		System.out.printf((BUYED_LOTTO_AMOUNT_MESSAGE_FORMAT) + "%n", lottoBuyingInfo.getAmount());
	}

	@Override
	public void printLottos(List<Lotto> lottos) {
		for (Lotto lotto : lottos) {
			System.out.println(lotto.toString());
		}
		System.out.println();
	}

	@Override
	public void printErrorMessage(Exception e) {
		System.out.printf((ERROR_MESSAGE_FORMAT) + "%n", e.getMessage());
	}

	@Override
	public void printScoreMessage(ScoreInfo scoreInfo) {
		System.out.println("당첨 통계");
		System.out.println("---");
		for (Score score : Score.values()) {
			System.out.printf("%s (%s원) - %d개" + "\n",
					score.getDescription(),
					convertPriceToMoneyFormat(score.getPrice()),
					scoreInfo.get(score)
			);
		}
	}

	private String convertPriceToMoneyFormat(Integer price) {
		return new DecimalFormat("###,###").format(price);
	}

	@Override
	public void printProfitPercentageMessage(double profit) {
		System.out.printf("총 수익률은 %.1f%%입니다.\n", profit);
	}
}
