package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class LottoService {
    public static void makeLotto(Amount amount) {
        for (int count = 0; count < amount.getAmount(); count++) {
            List<Integer> lottoNumbers
                    = Randoms.pickUniqueNumbersInRange(Lotto.MIN_NUMBER, Lotto.MAX_NUMBER, Lotto.LOTTO_AMOUNT);
            LottoRepository.saveLottos(lottoNumbers);
        }
    }
}
