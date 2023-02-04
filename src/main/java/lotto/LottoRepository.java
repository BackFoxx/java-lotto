package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoRepository {
    private static final ThreadLocal<List<List<Integer>>> lottos = new ThreadLocal<>();

    static {
        lottos.set(new ArrayList<>());
    }

    public static void saveLottos(List<Integer> lottoNumbers) {
        lottos.get().add(lottoNumbers);
    }

    public static List<List<Integer>> findAll() {
        return lottos.get();
    }
}
