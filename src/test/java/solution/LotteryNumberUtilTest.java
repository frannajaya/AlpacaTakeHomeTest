package solution;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import java.util.HashMap;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class LotteryNumberUtilTest {

  @Nested
  class CalculateHashKeyOfMatchesTest {

    @Test
    public void testCalculateHashKeyOfMatches() throws Exception {
      HashMap<Long, Boolean> map1 = new HashMap<>();
      HashMap<Long, Boolean> map2 = new HashMap<>();
      HashMap<Long, Boolean> map3 = new HashMap<>();
      HashMap<Long, Boolean> map4 = new HashMap<>();
      HashMap<Long, Boolean> map5 = new HashMap<>();
      for (int i = 1; i < LotteryNumberUtil.HASH_FACTOR_LOTTERY_NUMBER; i++) {
        assertThat(map1.put(LotteryNumberUtil.calculateHashKeyOfMatches(i), true))
            .isNull();
        for (int j = i + 1; j < LotteryNumberUtil.HASH_FACTOR_LOTTERY_NUMBER; j++) {
          assertThat(map2.put(LotteryNumberUtil.calculateHashKeyOfMatches(i, j), true))
              .isNull();
          for (int k = j + 1; k < LotteryNumberUtil.HASH_FACTOR_LOTTERY_NUMBER; k++) {
            assertThat(map3.put(LotteryNumberUtil.calculateHashKeyOfMatches(i, j, k), true))
                .isNull();
            for (int l = k + 1; l < LotteryNumberUtil.HASH_FACTOR_LOTTERY_NUMBER; l++) {
              assertThat(map4.put(LotteryNumberUtil.calculateHashKeyOfMatches(i, j, k, l), true))
                  .isNull();
              for (int m = l + 1; m < LotteryNumberUtil.HASH_FACTOR_LOTTERY_NUMBER; m++) {
                assertThat(map5.put(LotteryNumberUtil.calculateHashKeyOfMatches(i, j, k, l, m), true))
                    .isNull();
              }
            }
          }
        }
      }
    }
  }

  @Nested
  class ReadLotteryNumbersTest {

    @Test
    public void testSuccess() throws Exception {
      assertThat(LotteryNumberUtil.readLotteryNumbers("1 2 3 4 5")).isEqualTo(
          new int[]{1, 2, 3, 4, 5});
      assertThat(LotteryNumberUtil.readLotteryNumbers("  1  2 3   4 5 ")).isEqualTo(
          new int[]{1, 2, 3, 4, 5});

      assertThat(LotteryNumberUtil.readLotteryNumbers("10 20 30 40 50")).isEqualTo(
          new int[]{10, 20, 30, 40, 50});
    }

    @Test
    public void testFailure() {
      assertThatThrownBy(() -> LotteryNumberUtil.readLotteryNumbers("1 2 3 4"))
          .isInstanceOf(IndexOutOfBoundsException.class);
    }
  }
}
