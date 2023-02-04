package lotto.inputview;

import camp.nextstep.edu.missionutils.Console;
import lotto.Amount;
import lotto.Lotto;

public class MoneyInputView {
    public static Amount getInput() {
        String input = Console.readLine();
        Validator.validateInput(input);
        return new Amount(Long.valueOf(input));
    }

    private static class Validator {

        public static final String NOT_NUMBER_EXCEPTION_MESSAGE = "숫자 형태가 아닙니다.";
        public static final String NOT_DIVIDED_EXCEPTION_MESSAGE = String.format("%d원으로 나누어지지 않는 값입니다.", Lotto.PRICE);
        public static final String LOWER_THEN_MIN = "최소 1개 이상 구입 가능해야 합니다.";

        public static void validateInput(String target) {
            Long number;
            number = convertToNumber(target);

            validateMin(number);
            validateDividing(number);
        }

        private static void validateMin(Long number) {
            if (number < Lotto.PRICE) {
                throw new IllegalArgumentException(LOWER_THEN_MIN);
            }
        }

        private static void validateDividing(Long number) {
            if (number % Lotto.PRICE != 0) {
                throw new IllegalArgumentException(NOT_DIVIDED_EXCEPTION_MESSAGE);
            }
        }

        private static Long convertToNumber(String target) {
            try {
                return Long.valueOf(target);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException(NOT_NUMBER_EXCEPTION_MESSAGE);
            }
        }
    }
}
