package solution;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class MatchCombinationUtilTest {

  @Nested
  class ConstructKeyArrayMatchCombinationOf2NumberTests {

    @Test
    void throwsExceptionForInvalidLength() {
      assertThrows(IllegalArgumentException.class, () ->
          MatchCombinationUtil.constructKeyArrayMatchCombinationOf2Number(new int[]{1, 2, 3}));
    }

    @Test
    void returnsAllCombinationsForValidInput() {
      int[] numbers = {1, 2, 3, 4, 5};
      List<Long> keys = MatchCombinationUtil.constructKeyArrayMatchCombinationOf2Number(numbers);
      assertThat(keys).hasSize(10);
    }
  }

  @Nested
  class ConstructKeyArrayMatchCombinationOf3NumberTests {

    @Test
    void throwsExceptionForInvalidLength() {
      assertThrows(IllegalArgumentException.class, () ->
          MatchCombinationUtil.constructKeyArrayMatchCombinationOf3Number(new int[]{1, 2, 3}));
    }

    @Test
    void returnsAllCombinationsForValidInput() {
      int[] numbers = {1, 2, 3, 4, 5};
      List<Long> keys = MatchCombinationUtil.constructKeyArrayMatchCombinationOf3Number(numbers);
      assertThat(keys).hasSize(10);
    }
  }

  @Nested
  class ConstructKeyArrayMatchCombinationOf4NumberTests {

    @Test
    void throwsExceptionForInvalidLength() {
      assertThrows(IllegalArgumentException.class, () ->
          MatchCombinationUtil.constructKeyArrayMatchCombinationOf4Number(new int[]{1, 2, 3}));
    }

    @Test
    void returnsAllCombinationsForValidInput() {
      int[] numbers = {1, 2, 3, 4, 5};
      List<Long> keys = MatchCombinationUtil.constructKeyArrayMatchCombinationOf4Number(numbers);
      assertThat(keys).hasSize(5);
    }
  }

  @Nested
  class PutMatchCombinationOf2NumberTests {

    @Test
    void throwsExceptionForInvalidLength() {
      assertThrows(IllegalArgumentException.class, () ->
          MatchCombinationUtil.putMatchCombinationOf2Number(new int[]{1, 2, 3},
              new ConcurrentHashMap<>()));
    }

    @Test
    void incrementsContainerForValidInput() {
      int[] numbers = {1, 2, 3, 4, 5};
      ConcurrentHashMap<Long, Integer> container = new ConcurrentHashMap<>();
      MatchCombinationUtil.putMatchCombinationOf2Number(numbers, container);
      assertThat(container.size()).isEqualTo(10);
      container.values().forEach(v -> assertThat(v).isEqualTo(1));
    }
  }

  @Nested
  class PutMatchCombinationOf3NumberTests {

    @Test
    void throwsExceptionForInvalidLength() {
      assertThrows(IllegalArgumentException.class, () ->
          MatchCombinationUtil.putMatchCombinationOf3Number(new int[]{1, 2, 3},
              new ConcurrentHashMap<>()));
    }

    @Test
    void incrementsContainerForValidInput() {
      int[] numbers = {1, 2, 3, 4, 5};
      ConcurrentHashMap<Long, Integer> container = new ConcurrentHashMap<>();
      MatchCombinationUtil.putMatchCombinationOf3Number(numbers, container);
      assertThat(container.size()).isEqualTo(10);
      container.values().forEach(v -> assertThat(v).isEqualTo(1));
    }
  }

  @Nested
  class PutMatchCombinationOf4NumberTests {

    @Test
    void throwsExceptionForInvalidLength() {
      assertThrows(IllegalArgumentException.class, () ->
          MatchCombinationUtil.putMatchCombinationOf4Number(new int[]{1, 2, 3},
              new ConcurrentHashMap<>()));
    }

    @Test
    void incrementsContainerForValidInput() {
      int[] numbers = {1, 2, 3, 4, 5};
      ConcurrentHashMap<Long, Integer> container = new ConcurrentHashMap<>();
      MatchCombinationUtil.putMatchCombinationOf4Number(numbers, container);
      assertThat(container.size()).isEqualTo(5);
      container.values().forEach(v -> assertThat(v).isEqualTo(1));
    }
  }

  @Nested
  class PutMatchCombinationOf5NumberTests {

    @Test
    void throwsExceptionForInvalidLength() {
      assertThrows(IllegalArgumentException.class, () ->
          MatchCombinationUtil.putMatchCombinationOf5Number(new int[]{1, 2, 3},
              new ConcurrentHashMap<>()));
    }

    @Test
    void incrementsContainerForValidInput() {
      int[] numbers = {1, 2, 3, 4, 5};
      ConcurrentHashMap<Long, Integer> container = new ConcurrentHashMap<>();
      MatchCombinationUtil.putMatchCombinationOf5Number(numbers, container);
      assertThat(container.size()).isEqualTo(1);
      container.values().forEach(v -> assertThat(v).isEqualTo(1));
    }
  }

  @Nested
  class GetNWinnersForMatchCombinationOf2NumberTests {

    @Test
    void throwsExceptionForInvalidLength() {
      assertThrows(IllegalArgumentException.class, () ->
          MatchCombinationUtil.getNWinnersForMatchCombinationOf2Number(new int[]{1, 2, 3},
              new ConcurrentHashMap<>()));
    }

    @Test
    void returnsSumOfWinners() {
      int[] numbers = {1, 2, 3, 4, 5};
      ConcurrentHashMap<Long, Integer> map = new ConcurrentHashMap<>();
      MatchCombinationUtil.putMatchCombinationOf2Number(numbers, map);
      int result = MatchCombinationUtil.getNWinnersForMatchCombinationOf2Number(numbers, map);
      assertThat(result).isEqualTo(10);
    }
  }

  @Nested
  class GetNWinnersForMatchCombinationOf3NumberTests {

    @Test
    void throwsExceptionForInvalidLength() {
      assertThrows(IllegalArgumentException.class, () ->
          MatchCombinationUtil.getNWinnersForMatchCombinationOf3Number(new int[]{1, 2, 3},
              new ConcurrentHashMap<>()));
    }

    @Test
    void returnsSumOfWinners() {
      int[] numbers = {1, 2, 3, 4, 5};
      ConcurrentHashMap<Long, Integer> map = new ConcurrentHashMap<>();
      MatchCombinationUtil.putMatchCombinationOf3Number(numbers, map);
      int result = MatchCombinationUtil.getNWinnersForMatchCombinationOf3Number(numbers, map);
      assertThat(result).isEqualTo(10);
    }
  }

  @Nested
  class GetNWinnersForMatchCombinationOf4NumberTests {

    @Test
    void throwsExceptionForInvalidLength() {
      assertThrows(IllegalArgumentException.class, () ->
          MatchCombinationUtil.getNWinnersForMatchCombinationOf4Number(new int[]{1, 2, 3},
              new ConcurrentHashMap<>()));
    }

    @Test
    void returnsSumOfWinners() {
      int[] numbers = {1, 2, 3, 4, 5};
      ConcurrentHashMap<Long, Integer> map = new ConcurrentHashMap<>();
      MatchCombinationUtil.putMatchCombinationOf4Number(numbers, map);
      int result = MatchCombinationUtil.getNWinnersForMatchCombinationOf4Number(numbers, map);
      assertThat(result).isEqualTo(5);
    }
  }

  @Nested
  class GetNWinnersForMatchCombinationOf5NumberTests {

    @Test
    void throwsExceptionForInvalidLength() {
      assertThrows(IllegalArgumentException.class, () ->
          MatchCombinationUtil.getNWinnersForMatchCombinationOf5Number(new int[]{1, 2, 3},
              new ConcurrentHashMap<>()));
    }

    @Test
    void returnsSumOfWinners() {
      int[] numbers = {1, 2, 3, 4, 5};
      ConcurrentHashMap<Long, Integer> map = new ConcurrentHashMap<>();
      MatchCombinationUtil.putMatchCombinationOf5Number(numbers, map);
      int result = MatchCombinationUtil.getNWinnersForMatchCombinationOf5Number(numbers, map);
      assertThat(result).isEqualTo(1);
    }
  }
}
