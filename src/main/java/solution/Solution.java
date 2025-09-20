package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Stream;

public class Solution {

  static ConcurrentHashMap<Long, Integer> map2MatchNumberToNWinner = new ConcurrentHashMap<>();
  static ConcurrentHashMap<Long, Integer> map3MatchNumberToNWinner = new ConcurrentHashMap<>();
  static ConcurrentHashMap<Long, Integer> map4MatchNumberToNWinner = new ConcurrentHashMap<>();
  static ConcurrentHashMap<Long, Integer> map5MatchNumberToNWinner = new ConcurrentHashMap<>();

  /**
   * Constructs a Lottery Matching numbers combination and add this user as a winner of each
   * combination.
   * <br>
   * For example, if a player has lottery numbers of <code>[4, 2, 5, 1, 3]</code>. Then:
   * <br>
   * This player is a winner of a combination of 2 numbers:
   * <code>(1,2), (1,3), (1,4), (1,5), (2,3), (2,4), etc</code>
   * <br>
   * This player is also a winner of a combination of 3 numbers: <code>(1,2,3), (1,2,4), (1,2,5),
   * etc</code>
   * <br>
   * This player is also a winner of a combination of 4 numbers: <code>(1,2,3,4), (1,2,3,5),
   * etc</code>
   * <br>
   * This player is also a winner of a combination of 5 numbers: <code>(1,2,3,4,5)</code>
   * <br><br>
   * <b>The complexity of this method is O(1) + O(1) + O(1) + O(1) + O(1) = O(1)</b>
   *
   * @param lotteryNumbers the lottery numbers of a player, with the length of 5.
   */
  private static void addAsAWinnerBasedOnMatches(int[] lotteryNumbers) {
    // To ensure, a combination of 2 and 3 will equal to 3 and 2 respectively.
    // the implementation of the sorting is using quick sort which is O(n log n) where n in this case is a fixed number of 5.
    // So it is O(5 log 5) ~ O(1)
    Arrays.sort(lotteryNumbers);

    // Add this player as a winner of combination 2 numbers.
    // The complexity of putMatchCombinationOf2Number is O(5 * 4) = O(20) ~ O(1)
    MatchCombinationUtil.putMatchCombinationOf2Number(lotteryNumbers, map2MatchNumberToNWinner);

    // Add this player as a winner of combination 3 numbers.
    // The complexity of putMatchCombinationOf3Number is O(5 * 4 * 3) = O(60) ~ O(1)
    MatchCombinationUtil.putMatchCombinationOf3Number(lotteryNumbers, map3MatchNumberToNWinner);

    // Add this player as a winner of combination 4 numbers.
    // The complexity of putMatchCombinationOf4Number is O(5 * 5) = O(25) ~ O(1)
    MatchCombinationUtil.putMatchCombinationOf4Number(lotteryNumbers, map4MatchNumberToNWinner);

    // Add this player as a winner of combination 5 numbers.
    // The complexity of putMatchCombinationOf5Number is O(5) ~ O(1)
    MatchCombinationUtil.putMatchCombinationOf5Number(lotteryNumbers, map5MatchNumberToNWinner);
  }

  /**
   * Prints the number of winners based on the matching numbers.
   * <br>
   * For example, if the lottery numbers is <code>[4, 2, 5, 1, 3]</code>. Then:
   * <br>
   * The combination of 2 numbers like this: <code>(1,2), (1,3), (1,4), (1,5), (2,3), (2,4),
   * etc</code> are a winners, sum up the total of these 2 numbers combinations.
   * <br>
   * The combination of 3 numbers like this: <code>(1,2,3), (1,2,4), (1,2,5), etc</code> are a
   * winners, sum up the total of these 3 numbers combinations.
   * <br>
   * The combination of 3 numbers like this: <code>(1,2,3,4), (1,2,3,5), etc</code> are a winners,
   * sum up the total of these 4 numbers combinations.
   * <br>
   * The combination of 3 numbers like this: <code>(1,2,3,4,5)</code> are a winners, sum up the
   * total of these 5 numbers combinations.
   * <br><br>
   * Then print out all the total winner of that with format like: <code>winnerOfCombination2Num
   * winnerOfCombination3Num winnerOfCombination4Num winnerOfCombination5Num</code>
   * <br>example: <code>250561 8616 103 1</code>
   * <br><br>
   * <b>The complexity of this method is O(1) + O(1) + O(1) + O(1) + O(1) = O(1)</b>
   *
   * @param lotteryNumbers the lottery numbers of a player, with the length of 5.
   */
  private static void printWinnerBasedOnMatches(int[] lotteryNumbers) {
    // To ensure, a combination of 2 and 3 will equal to 3 and 2 respectively.
    // the implementation of the sorting is using quick sort which is O(n log n) where n in this case is a fixed number of 5.
    // So it is O(5 log 5) ~ O(1)
    Arrays.sort(lotteryNumbers);

    // Get the number of winners for each combination of 2 matching numbers.
    // The complexity of getNWinnersForMatchCombinationOf2Number is O(5 * 4) = O(20) ~ O(1)
    int n2Winners = MatchCombinationUtil.getNWinnersForMatchCombinationOf2Number(lotteryNumbers,
        map2MatchNumberToNWinner);

    // Get the number of winners for each combination of 3 matching numbers.
    // The complexity of getNWinnersForMatchCombinationOf3Number is O(5 * 4 * 3) = O(60) ~ O(1)
    int n3Winners = MatchCombinationUtil.getNWinnersForMatchCombinationOf3Number(lotteryNumbers,
        map3MatchNumberToNWinner);

    // Get the number of winners for each combination of 4 matching numbers.
    // The complexity of getNWinnersForMatchCombinationOf4Number is O(5 * 5) = O(25) ~ O(1)
    int n4Winners = MatchCombinationUtil.getNWinnersForMatchCombinationOf4Number(lotteryNumbers,
        map4MatchNumberToNWinner);

    // Get the number of winners for each combination of 5 matching numbers.
    // The complexity of getNWinnersForMatchCombinationOf5Number is O(5) ~ O(1)
    int n5Winners = MatchCombinationUtil.getNWinnersForMatchCombinationOf5Number(lotteryNumbers,
        map5MatchNumberToNWinner);

    System.out.printf("%d %d %d %d\n", n2Winners, n3Winners, n4Winners, n5Winners);
  }

  public static void main(String[] args) {
    if (args.length < 1) {
      System.out.println("Usage: ./yourapp <inputfile>");
      return;
    }

    String filename = args[0];
    System.out.println("Reading from file: " + filename);

    try (Stream<String> stream = Files.lines(Path.of(filename))) {
      stream.forEach(line -> {
        int[] lotteryNumbers;
        try {
          lotteryNumbers = LotteryNumberUtil.readLotteryNumbers(line);
        } catch (Exception e) {
          System.out.println("Got invalid Lottery Number format: " + line
              + ". Ignoring this player Lottery numbers");
          return;
        }

        // Constructs a Lottery Matching numbers combination and add this user as a winner of that combination.
        // The complexity of addAsAWinnerBasedOnMatches is O(1) + O(1) + O(1) + O(1) + O(1) ~ O(1)
        addAsAWinnerBasedOnMatches(lotteryNumbers);
      });
    } catch (IOException e) {
      System.err.println("Error reading file: " + e.getMessage());
    }

    System.out.println("READY");

    try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
      String line;

      while ((line = reader.readLine()) != null) {
        // Stop if "exit"
        if ("exit" .equalsIgnoreCase(line.trim())) {
          System.out.println("Exiting program...");
          break;
        }

        try {
          // long before = System.currentTimeMillis();
          int[] lotteryNumbers = LotteryNumberUtil.readLotteryNumbers(line);

          printWinnerBasedOnMatches(lotteryNumbers);
          // long after = System.currentTimeMillis();
          // System.out.println("Time taken: " + (after - before) + " ms"); // for debugging purpose
        } catch (Exception e) {
          System.out.println("❌ Invalid input, will ignore the input. Program continues...");
        }
      }
    } catch (IOException e) {
      System.out.println("Error reading input: " + e.getMessage());
    }
  }
}
