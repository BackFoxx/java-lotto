package lotto.inputview;

import lotto.system.IOTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class MoneyInputViewTest extends IOTest {
    @Nested
    @DisplayName("로또 구매금액 입력값 테스트")
    class InputValidationTest {
        @Test
        @DisplayName("로또 구매 금액이 1개도 못 사는 금액이면 예외가 발생한다.")
        void givenLottoAmountLowerThenMinAmount_thenThrowsException() {
            systemIn("900");
            assertThatThrownBy(MoneyInputView::getInput)
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("최소 1개 이상 구입 가능해야 합니다.");
        }

        @Test
        @DisplayName("로또 구매 금액이 1,000원으로 나누어지지 않는 금액이면 예외가 발생한다.")
        void givenLottoAmountNotDividedIn1000_thenThrowsException() {
            systemIn("5500");
            assertThatThrownBy(MoneyInputView::getInput)
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("1000원으로 나누어지지 않는 값입니다.");
        }

        @Test
        @DisplayName("입력한 값이 숫자가 아니면 예외가 발생한다.")
        void givenLottoAmountNotNumber_thenThrowsException() {
            systemIn("숫자");
            assertThatThrownBy(MoneyInputView::getInput)
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("숫자 형태가 아닙니다.");
        }
    }
}