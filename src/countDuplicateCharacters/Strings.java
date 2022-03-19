package countDuplicateCharacters;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public final class Strings {
    private Strings() {
        throw new AssertionError("cannot be instantiated");
    }

    public static Map<Character, Integer> countDuplicateCharacters(String string){
        if(string == null || string.isBlank()){
            return Collections.emptyMap();
        }

        Map<Character, Integer> result = new HashMap<>();
        for(int i = 0; i < string.length(); i++){
            Character ch = string.charAt(i);
            result.compute(ch, (k, v) -> (v == null) ? 1 : ++v);
        }

        return result;
    }
    public static Map<Character, Long> countDuplicateCharactersViaStreams(String string){
        if(string == null || string.isBlank()){
            return Collections.emptyMap();
        }

        Map<Character, Long> result = string.chars().mapToObj(ch -> (char) ch)
                .collect(Collectors.groupingBy(ch -> ch, Collectors.counting()));

        return result;
    }
    public static Map<String, Integer> countDuplicateCharactersAndSurrogatePairs(String string){
        if(string == null || string.isBlank()){
            return Collections.emptyMap();
        }

        Map<String, Integer> result = new HashMap<>();

        for(int i = 0; i < string.length(); i++){
            int cp = string.codePointAt(i); //
            String ch = String.valueOf(Character.toChars(cp));
            if(Character.charCount(cp) == 2){
                i++;
            }
            result.compute(ch, (key, value) -> (value == null) ? 1 : ++value);
        }
        return result;
    }

    public static Map<String, Long> countDuplicateCharactersAndSurrogatePairsViaStreams(String string){
        if(string == null || string.isBlank()){
            return Collections.emptyMap();
        }
        Map<String, Long> result = string.codePoints()
                .mapToObj(cp -> String.valueOf(Character.toChars(cp)))
                .collect(Collectors.groupingBy(c -> c, Collectors.counting()));
        return result;
    }
}
