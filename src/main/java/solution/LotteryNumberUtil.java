package solution;

public final class LotteryNumberUtil {

  public static int HASH_FACTOR_LOTTERY_NUMBER = 91;

  private LotteryNumberUtil() {
  }

  /**
   * Convert a line of lottery numbers in a String which separated by space, to an array of
   * integers.
   *
   * @param line a line of lottery numbers in a String which separated by space.
   * @return an array of integers representing the lottery numbers.
   */
  public static int[] readLotteryNumbers(String line) throws NumberFormatException {
    String[] parts = line.trim().split("\\s+");
    int[] lotteryNumbers = new int[5];
    for (int i = 0; i < 5; i++) {
      lotteryNumbers[i] = Integer.parseInt(parts[i]);
    }

    return lotteryNumbers;
  }

  /**
   * Calculate a hash key for a given sorted set of match numbers.
   * <br>
   * For example, if the match numbers are <code>(1, 2, 3)</code>, then the hash key will be
   * calculated as: <code>1 * 91^2 + 2 * 91^1 + 3 * 91^0 = 8195</code>.
   *
   * @param matchNumbers the sorted match numbers to calculate the hash key for
   * @return the calculated hash key.
   */
  public static long calculateHashKeyOfMatches(int... matchNumbers) {
    long key = 0;

    for (int number : matchNumbers) {
      key = key * HASH_FACTOR_LOTTERY_NUMBER + number;
    }

    return key;
  }
}
