package countDuplicateCharacters;

import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class Driver {

    private static final String TEXT = "Be strong, be fearless, be beautiful. "
            + "And believe that anything is possible when you have the right "
            + "people there to support you. ";

    private static final String TEXT_CP = TEXT + "😍 I love 💕 you Ӝ so much 💕 😍 🎼🎼🎼!";

    public static void main(String[] args) {
        System.out.println("HashMap based solution");
        long startTime1 = System.nanoTime();
        Map<Character, Integer> duplicates1 = Strings.countDuplicateCharacters(TEXT);
        displayExecutionTime(System.nanoTime() - startTime1);
        System.out.println(Arrays.toString(duplicates1.entrySet().toArray()));

        System.out.println();

        System.out.println("Functional-style 1");
        long startTime2 = System.nanoTime();
        Map<Character, Long> duplicates2 = Strings.countDuplicateCharactersViaStreams(TEXT);
        displayExecutionTime(System.nanoTime() - startTime2);
        System.out.println(Arrays.toString(duplicates2.entrySet().toArray()));

        System.out.println("\n--------------------------------------\n");
        System.out.println("Input text: \n" + TEXT_CP + "\n");
        System.out.println("\n\nIncluding Unicode surrogate pairs examples:\n");

        System.out.println("HashMap based solution:");
        long startTime3 = System.nanoTime();
        Map<String, Integer> duplicates3 = Strings.countDuplicateCharactersAndSurrogatePairs(TEXT_CP);
        displayExecutionTime(System.nanoTime()-startTime3);
        System.out.println(Arrays.toString(duplicates3.entrySet().toArray()));

        System.out.println("functional-style based solution:");
        long startTime4 = System.nanoTime();
        Map<String, Long> duplicates4 = Strings.countDuplicateCharactersAndSurrogatePairsViaStreams(TEXT_CP);
        displayExecutionTime(System.nanoTime()-startTime4);
        System.out.println(Arrays.toString(duplicates4.entrySet().toArray()));

    }

    private static void displayExecutionTime(long time){
        System.out.println("Execution time: " + time + " ns" + " (" +
                TimeUnit.MILLISECONDS.convert(time, TimeUnit.NANOSECONDS) + " ms)");
    }
}
