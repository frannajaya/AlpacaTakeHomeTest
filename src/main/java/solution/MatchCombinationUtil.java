package solution;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public final class MatchCombinationUtil {

  private MatchCombinationUtil() {
  }

  public static void validateLotteryNumbersLength(int[] numbers) {
    if (numbers.length != 5) {
      throw new IllegalArgumentException("The length of numbers must be 5");
    }
  }

  /**
   * Construct a list of hash keys for each combination of 2 numbers of the numbers param.
   *
   * @param numbers the lottery numbers of a player, with the length of 5 and Sorted.
   * @return a list of hash keys for each combination of 2 numbers.
   */
  public static List<Long> constructKeyArrayMatchCombinationOf2Number(final int[] numbers) {
    validateLotteryNumbersLength(numbers);
    List<Long> keys = new ArrayList<>();
    for (int i = 0; i < 5; i++) {
      for (int j = i + 1; j < 5; j++) {
        long key = LotteryNumberUtil.calculateHashKeyOfMatches(numbers[i], numbers[j]);
        keys.add(key);
      }
    }

    return keys;
  }

  /**
   * Construct a list of hash keys for each combination of 3 numbers of the numbers param.
   *
   * @param numbers the lottery numbers of a player, with the length of 5 and Sorted.
   * @return a list of hash keys for each combination of 3 numbers.
   */
  public static List<Long> constructKeyArrayMatchCombinationOf3Number(final int[] numbers) {
    validateLotteryNumbersLength(numbers);

    List<Long> keys = new ArrayList<>();
    for (int i = 0; i < 5; i++) {
      for (int j = i + 1; j < 5; j++) {
        for (int k = j + 1; k < 5; k++) {
          long key = LotteryNumberUtil.calculateHashKeyOfMatches(numbers[i], numbers[j],
              numbers[k]);
          keys.add(key);
        }
      }
    }
    return keys;
  }

  /**
   * Construct a list of hash keys for each combination of 4 numbers of the numbers param.
   *
   * @param numbers the lottery numbers of a player, with the length of 5 and Sorted.
   * @return a list of hash keys for each combination of 4 numbers.
   */
  public static List<Long> constructKeyArrayMatchCombinationOf4Number(final int[] numbers) {
    validateLotteryNumbersLength(numbers);

    List<Long> keys = new ArrayList<>();
    // The implementation of putMatchCombinationOf4Number is O(5 * 4) = O(20) ~ O(1)
    for (int i = 0; i < 5; i++) {
      int[] c = new int[4];
      int idx = 0;
      for (int j = 0; j < 5; j++) {
        if (j != i) {
          c[idx++] = numbers[j];
        }
      }

      long key = LotteryNumberUtil.calculateHashKeyOfMatches(c);
      keys.add(key);
    }

    return keys;
  }

  /**
   * For each combination of 2 numbers of the numbers param. Construct a hash key, then check if the
   * key already exists, increment its value by 1. If not, add this key to the map with the value of
   * 1.
   *
   * @param numbers   the lottery numbers of a player, with the length of 5 and Sorted.
   * @param container the container to store the combination of 2 numbers as a key and the number of
   *                  winners as value.
   */
  public static void putMatchCombinationOf2Number(
      final int[] numbers,
      final ConcurrentHashMap<Long, Integer> container
  ) {
    validateLotteryNumbersLength(numbers);

    List<Long> keys = constructKeyArrayMatchCombinationOf2Number(numbers);

    for (Long key : keys) {
      container.merge(key, 1, Integer::sum);
    }
  }

  /**
   * For each combination of 3 numbers of the numbers param. Construct a hash key, then check if the
   * key already exists, increment its value by 1. If not, add this key to the map with the value of
   * 1.
   *
   * @param numbers   the lottery numbers of a player, with the length of 5 and Sorted.
   * @param container the container to store the combination of 3 numbers as a key and the number of
   *                  winners as value.
   */
  public static void putMatchCombinationOf3Number(
      final int[] numbers,
      final ConcurrentHashMap<Long, Integer> container
  ) {
    validateLotteryNumbersLength(numbers);

    List<Long> keys = constructKeyArrayMatchCombinationOf3Number(numbers);

    for (Long key : keys) {
      container.merge(key, 1, Integer::sum);
    }
  }

  /**
   * For each combination of 4 numbers of the numbers param. Construct a hash key, then check if the
   * key already exists, increment its value by 1. If not, add this key to the map with the value of
   * 1.
   *
   * @param numbers   the lottery numbers of a player, with the length of 5 and Sorted.
   * @param container the container to store the combination of 4 numbers as a key and the number of
   *                  winners as value.
   */
  public static void putMatchCombinationOf4Number(
      final int[] numbers,
      final ConcurrentHashMap<Long, Integer> container
  ) {
    validateLotteryNumbersLength(numbers);

    List<Long> keys = constructKeyArrayMatchCombinationOf4Number(numbers);

    for (Long key : keys) {
      container.merge(key, 1, Integer::sum);
    }
  }

  /**
   * For the combination of all 5 numbers of the numbers param. Construct a hash key, then check if
   * the key already exists, increment its value by 1. If not, add this key to the map with the
   * value of 1.
   *
   * @param numbers   the lottery numbers of a player, with the length of 5 and Sorted.
   * @param container the container to store the combination of 5 numbers as a key and the number of
   *                  winners as value.
   */
  public static void putMatchCombinationOf5Number(
      final int[] numbers,
      final ConcurrentHashMap<Long, Integer> container
  ) {
    validateLotteryNumbersLength(numbers);

    long key = LotteryNumberUtil.calculateHashKeyOfMatches(numbers);

    container.merge(key, 1, Integer::sum);
  }

  /**
   * For each combination of 2 numbers of the lotteryNumbers param. Construct a hash key, then check
   * if the key exists in the map, if yes, sum up its value to get the total number of winners for
   * this combination. Producing the total number of winners has all combinations of 2 numbers in
   * its lottery numbers.
   *
   * @param lotteryNumbers           the lottery numbers of a player, with the length of 5 and
   *                                 Sorted.
   * @param map2MatchNumberToNWinner the container that stores the combination of 2 numbers as a key
   *                                 and the number of winners as value.
   * @return the total number of winners has all combinations of 2 numbers in its lottery numbers.
   */
  public static int getNWinnersForMatchCombinationOf2Number(
      int[] lotteryNumbers,
      ConcurrentHashMap<Long, Integer> map2MatchNumberToNWinner
  ) {
    validateLotteryNumbersLength(lotteryNumbers);

    int combo2Winner = 0;
    List<Long> keys = constructKeyArrayMatchCombinationOf2Number(lotteryNumbers);
    for (Long key : keys) {
      combo2Winner += map2MatchNumberToNWinner.getOrDefault(key, 0);
    }
    return combo2Winner;
  }

  /**
   * For each combination of 3 numbers of the lotteryNumbers param. Construct a hash key, then check
   * if the key exists in the map, if yes, sum up its value to get the total number of winners for
   * this combination. Producing the total number of winners has all combinations of 3 numbers in
   * its lottery numbers.
   *
   * @param lotteryNumbers           the lottery numbers of a player, with the length of 5 and
   *                                 Sorted.
   * @param map3MatchNumberToNWinner the container that stores the combination of 3 numbers as a key
   *                                 and the number of winners as value.
   * @return the total number of winners has all combinations of 3 numbers in its lottery numbers.
   */
  public static int getNWinnersForMatchCombinationOf3Number(
      int[] lotteryNumbers,
      ConcurrentHashMap<Long, Integer> map3MatchNumberToNWinner
  ) {
    validateLotteryNumbersLength(lotteryNumbers);

    int combo3Winner = 0;
    List<Long> keys = constructKeyArrayMatchCombinationOf3Number(lotteryNumbers);
    for (Long key : keys) {
      combo3Winner += map3MatchNumberToNWinner.getOrDefault(key, 0);
    }
    return combo3Winner;
  }

  /**
   * For each combination of 4 numbers of the lotteryNumbers param. Construct a hash key, then check
   * if the key exists in the map, if yes, sum up its value to get the total number of winners for
   * this combination. Producing the total number of winners has all combinations of 4 numbers in
   * its lottery numbers.
   *
   * @param lotteryNumbers           the lottery numbers of a player, with the length of 5 and
   *                                 Sorted.
   * @param map4MatchNumberToNWinner the container that stores the combination of 4 numbers as a key
   *                                 and the number of winners as value.
   * @return the total number of winners has all combinations of 4 numbers in its lottery numbers.
   */
  public static int getNWinnersForMatchCombinationOf4Number(
      int[] lotteryNumbers,
      ConcurrentHashMap<Long, Integer> map4MatchNumberToNWinner
  ) {
    validateLotteryNumbersLength(lotteryNumbers);

    int combo4Winner = 0;
    List<Long> keys = constructKeyArrayMatchCombinationOf4Number(lotteryNumbers);
    for (Long key : keys) {
      combo4Winner += map4MatchNumberToNWinner.getOrDefault(key, 0);
    }
    return combo4Winner;
  }

  /**
   * For the combination of all 5 numbers of the lotteryNumbers param. Construct a hash key, then
   * check if the key exists in the map, if yes, get its value to get the total number of winners
   * for this combination. Producing the total number of winners has all combinations of 5 numbers
   * in its lottery numbers.
   *
   * @param lotteryNumbers           the lottery numbers of a player, with the length of 5 and
   *                                 Sorted.
   * @param map5MatchNumberToNWinner the container that stores the combination of 5 numbers as a key
   *                                 and the number of winners as value.
   * @return the total number of winners has all combinations of 5 numbers in its lottery numbers.
   */
  public static int getNWinnersForMatchCombinationOf5Number(
      int[] lotteryNumbers,
      ConcurrentHashMap<Long, Integer> map5MatchNumberToNWinner
  ) {
    validateLotteryNumbersLength(lotteryNumbers);

    long key = LotteryNumberUtil.calculateHashKeyOfMatches(lotteryNumbers);
    return map5MatchNumberToNWinner.getOrDefault(key, 0);
  }
}
