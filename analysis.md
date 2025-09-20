## The Asymptotic Run Time Analysis

Let <b>L</b> be the number of players (rows in the input file).

Let <b>J</b> be the length of Lottery Number in 1 ticket, in this case is constant value 5

Let <b>K</b> be the number of winning numbers input by user.

### Preprocessing Phase (Winning Number Maps)

#### Reading the file

1. Time Complexity: O(N)
    - Read each player's numbers once and construct array of lottery number.
    - Each time read the line, construct it to integer value as many as J (total numbers in 1
      ticket)
    - The complexity should be <b>O(L * J)</b>, in this case the J is constant value of 5,
    - The final complexity is <b>O(L) ~ O(N)</b>
2. Space Complexity: O(1)
    - Reading the file each line and construct an array of lottery number.
    - The space of the array lottery number is O(J), but in this case the J is a constant value of 5
    - The final complexity is <b>O(1)</b>
3. Data Structure: Array Lottery Number
    - Use an Array to store the 5 lottery numbers

#### Storing Winning Number Combination

1. Time Complexity: O(1)
    - From the array of lottery numbers, create a HashMap of combination of 2, 3, 4, and 5 lottery
      numbers.
    - Each of Combination 2, 3, 4, and 5 numbers will be stored to 1 HashMap, and each combination
      will do:
        - The combination of 2 numbers, do iteration as much as <b>J * (J-1)</b>, but the J is
          constant
          value 5, so the complexity is <b>O(5 * 4) = O(20) ~ O(1)</b>
        - The combination of 3 numbers, do iteration as much as <b>J * (J-1) * (J-2)</b>, but the J
          is
          constant value 5, so the complexity is <b>O(5 * 4 * 3) = O(60) ~ O(1)</b>
        - The combination of 4 numbers, do iteration as much as <b>J * J</b>, but the J is constant
          value
          5, so the complexity is <b>O(5 * 5) = O(25) ~ O(1)</b>
        - The combination of 5 numbers, directly store it, so the complexity is O(1)
    - The final complexity will be <b>O(1 + 1 + 1 + 1) ~ O(1)</b>
    - <b>Side notes</b>: The complexity should be O($M^3$) (max on the combination of 3 numbers), so
      the complexity of combination will increase if the total lottery number is increase. In this
      case, Since the J is constant value of 5 the final complexity is O(1)
2. Space Complexity: O(N)
    - Creating the HashMap for each of Combination 2, 3, 4, and 5 numbers.
    - The total combination of each will be like this:
        - The combination of 2 numbers, can have at most $\binom{90}{2}$ = 4,005 entries.
        - The combination of 3 numbers, can have at most $\binom{90}{3}$ = 117,480 entries.
        - The combination of 4 numbers, can have at most $\binom{90}{4}$ = 2,555,190 entries.
        - The combination of 5 numbers, can have at most $\binom{90}{5}$ = 43,949,268 entries.
    - The max total entries is the worst case, so in practice, only combos that appear in the input
      get stored, so actual memory depends on L number of input.
    - The final space complexity is <b>O(L) ~ O(N)</b>
3. Data Structure: 4 HashMap for each of Combination 2, 3, 4, and 5 numbers.
    - Use a HashMap for each combination number.

### Drawing Winner Phase

#### Reading each line of Winning Lottery Numbers

1. Time Complexity: O(N)
    - Read each player's numbers once and construct array of lottery number.
    - Each time read the line, construct it to integer value as many as J (total numbers in 1
      ticket)
    - The complexity should be <b>O(J * K)</b>, in this case the J is constant value of 5,
    - The final complexity is <b>O(K) ~ O(N)</b>
2. Space Complexity: O(1)
    - Reading each line and construct an array of lottery number.
    - The space of the array lottery number is O(J), but in this case the J is a constant value of 5
    - The final complexity is <b>O(1)</b>
3. Data Structure: Array Lottery Number
    - Use an Array to store the 5 lottery numbers

#### Pick up total Winners

1. Time Complexity: O(1)
    - For each line (representing winning numbers), check how many players win by 2, 3, 4, and 5
      combination numbers.
    - Create a HashKey of 2, 3, 4, and 5 combination numbers, with details:
        - The combination of 2 numbers, do iteration as much as <b>J * (J-1)</b>, but the J is
          constant value 5, so the complexity is <b>O(5 * 4) = O(20) ~ O(1)</b>
        - The combination of 3 numbers, do iteration as much as <b>J * (J-1) * (J-2)</b>, but the J
          is constant value 5, so the complexity is <b>O(5 * 4 * 3) = O(60) ~ O(1)</b>
        - The combination of 4 numbers, do iteration as much as <b>J * J</b>, but the J is constant
          value 5, so the complexity is <b>O(5 * 5) = O(25) ~ O(1)</b>
        - The combination of 5 numbers, directly store it, so the complexity is O(1)
    - Then print the total winners of 2, 3, 4, and 5 combination numbers.
    - The final complexity will be <b>O(1 + 1 + 1 + 1) ~ O(1)</b>
    - <b>Side notes</b>: The complexity should be O($M^3$) (max on the combination of 3 numbers), so
      the complexity of combination will increase if the total lottery number is increase. In this
      case, Since the J is constant value of 5 the final complexity is O(1)
2. Space Complexity: O(1)
    - Only use a fixed amount of space for counting wins.
3. Data Structure: 4 integer counters
    - to keep track of how many players win by 2, 3, 4, and 5 numbers.

## Overall Summary

- Overall Time Complexity: <b>O(L + (J * K)) ~ O(N + M)</b>
- Overall Space Complexity: <b>O(N)</b>
    - in practice (bounded by unique combos inserted)

## Final Notes

- Justification: This overall approach is efficient for large datasets, balancing time and space
  complexity effectively.
- Worst Case: In the worst case, if all players have unique numbers and all winning numbers are
  present among players, the time complexity remains O(N + M).
- Best Case: In the best case, if there are many duplicate numbers among players and winning
  numbers, the time complexity is still O(N + M).
- Average Case: On average, the time complexity is O(N + M), as the distribution of player numbers
  and winning numbers is likely to be uniform.
- Scalability: The approach scales well with increasing L, and K, making it suitable for large-scale
  applications. But if the J increases significantly, the combination generation should be
  re-defined
- Limitations: The main limitation is memory usage for storing player numbers, especially if L is
  huge. The other problem is if the J increases significantly, the combination generation should be
  re-defined and the complexity might increase.
- Improvements: Further optimizations could be made in data storage or processing techniques if
  performance becomes a concern. One of the improvement, is to use cache of lottery number on
  pre-process and getting the result. This will reduce the time complexity of drawing winner phase
  to O(1) on the best case.
- Real-world Implications: This approach is practical for real-world applications like lottery
  systems, where efficiency and responsiveness are critical.
- Final Note: Considering the specific requirements and constraints on this case this approach give
  a balanced time and space complexity.
