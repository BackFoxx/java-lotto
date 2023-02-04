package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoServiceTest {
    @Test
    @DisplayName("파라미터로 넘어온 로또 구매 개수만큼 로또를 생성한다.")
    void givenLottoAmount_thenSavingLottosAmountOfGiven() {
        Amount amount = new Amount(9000L);

        LottoService.makeLotto(amount);

        List<List<Integer>> findLottos = LottoRepository.findAll();
        assertThat(findLottos).hasSize(9);
    }
}