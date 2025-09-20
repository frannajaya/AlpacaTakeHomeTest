## Lottery Winner Prompter

This repository contains a simple Java that store lottery player and it owns numbers.
It will help to show how many user win by 2 numbers, 3 numbers, 4 numbers, 5 numbers.

### What it does

- Read from file contain N number of row data, each row is each player numbers
- The ticket numbers length is 5, and each number is between 1 and 90
- Then at the end of the processing file, it will listen to input from user prompt to input winning
  numbers
- After each of the input winning numbers, it will show how many player win by 2 numbers, 3 numbers,
  4 numbers, and 5 numbers.
- The program will continue to listen to user input until user input "exit"
- The program will ignore invalid input and show error message

### How to Run

#### Run the program that already compiled in this root directory

1. Clone the repository
2. Run the program that already compiled by me in the root directory named solution

```aiignore
 ./solution input.txt
```

#### Compile by yourself, then run the program

1. Prerequisite
    - <b>Java 21</b> or above (see
      installation [here](https://docs.oracle.com/en/java/javase/21/install/overview-jdk-installation.html))
    - <b>GraalVM for JDK21</b> (see installation [here](https://www.graalvm.org/getting-started/))
    - <b>native-image</b> installed.
        - You can install it by running the command (after installing GraalVM)
         ```aiignore
           gu install native-image
         ```
        - Or you can follow the
          instruction [here](https://www.graalvm.org/reference-manual/native-image/)
2. Clone the repository
3. Compile the program by running the command in the root directory

```aiignore
 javac -d out src/main/java/solution/*.java
```

4. Build the jar

```aiignore
 jar cfm solution.jar MANIFEST.MF -C out .
```

5. Create a native image by running the command in the root directory

```aiignore
 native-image -jar solution.jar solution
```

2. Run the program that you just compiled. With the file as input

```aiignore
 ./solution input.txt
```

For the analysis document, please see [here](analysis.md)
