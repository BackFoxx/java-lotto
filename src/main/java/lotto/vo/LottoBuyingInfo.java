package lotto.vo;

import lotto.system.validator.ConvertingToLottoBuyingInfoValidator;

public class LottoBuyingInfo {
	private final int money;
	private final int amount;

	public LottoBuyingInfo(String input) {
		ConvertingToLottoBuyingInfoValidator.validate(input);
		int money = Integer.parseInt(removeCommaFrom(input));

		this.money = money;
		this.amount = money / 1000;
	}

	private static String removeCommaFrom(String target) {
		return target.replaceAll(",", "");
	}

	public int getMoney() {
		return money;
	}

	public int getAmount() {
		return amount;
	}
}
