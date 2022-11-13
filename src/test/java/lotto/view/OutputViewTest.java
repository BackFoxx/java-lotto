package lotto.view;

import lotto.domain.ScoreInfo;
import lotto.system.LottoApplication;
import lotto.vo.Lotto;
import lotto.vo.LottoBuyingInfo;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class OutputViewTest {
    private final OutputView outputView = new OutputViewImpl();

    @BeforeEach
    void setup() {
        LottoApplication.initializeValidators();
        LottoApplication.initializeConverters();
    }

    @AfterEach
    void runAfter() {
        LottoApplication.doAfter();
    }

    @Test
    @DisplayName("발행한 로또 개수를 메시지 포맷에 담아 출력할 수 있다.")
    void givenLottoAmount_whenRunningOutputView_thenPrintsLottoAmountMessage() {
        //given
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        LottoBuyingInfo lottoBuyingInfo = new LottoBuyingInfo(10000, 10);

        //when
        outputView.printLottoBuyingInfo(lottoBuyingInfo);

        //then
        assertThat(out.toString())
                .isEqualTo(String.format("%s\n", String.format(OutputViewImpl.BUYED_LOTTO_AMOUNT_MESSAGE_FORMAT, 10)));
    }

    @Test
    @DisplayName("요청한 로또 개수 수만큼 발행한 로또 번호를 출력할 수 있다.")
    void givenLottoList_whenRunningOutputView_thenPrintsLottosMessage() {
        //given
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        List<Lotto> lottos = Arrays.asList(
                new Lotto(Arrays.asList(8, 21, 23, 41, 42, 43)),
                new Lotto(Arrays.asList(3, 5, 11, 16, 32, 38)),
                new Lotto(Arrays.asList(7, 11, 16, 35, 36, 44)),
                new Lotto(Arrays.asList(1, 8, 11, 31, 41, 42))
        );

        //when
        outputView.printLottos(lottos);

        //then
        assertThat(out.toString())
                .isEqualTo(
                        "[8, 21, 23, 41, 42, 43]\n" +
                                "[3, 5, 11, 16, 32, 38]\n" +
                                "[7, 11, 16, 35, 36, 44]\n" +
                                "[1, 8, 11, 31, 41, 42]\n\n"
                );
    }

    @Test
    @DisplayName("주어진 당첨 점보를 바탕으로 당첨 내역 메시지를 출력한다.")
    void givenScoreInfo_whenRunningOutputView_thenPrintsScoreMessage() {
        // given
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        ScoreInfo scoreInfo = new ScoreInfo();

        // when
        outputView.printScoreMessage(scoreInfo);

        // then
        assertThat(out.toString())
                .isEqualTo("당첨 통계\n" +
                        "---\n" +
                        "3개 일치 (5,000원) - 0개\n" +
                        "4개 일치 (50,000원) - 0개\n" +
                        "5개 일치 (1,500,000원) - 0개\n" +
                        "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개\n" +
                        "6개 일치 (2,000,000,000원) - 0개\n"
                );
    }

    @Test
    @DisplayName("수익률 값이 주어지면 수익률 메시지를 출력한다.")
    void givenProfitPercentage_whenRunningOutputView_thenPrintsProfitMessage() {
        //given
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        double profit = 62.5f;

        //when
        outputView.printProfitPercentageMessage(profit);

        //then
        assertThat(out.toString())
                .isEqualTo("총 수익률은 62.5%입니다.\n");
    }
}