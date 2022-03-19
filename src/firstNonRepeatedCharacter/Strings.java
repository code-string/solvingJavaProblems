package firstNonRepeatedCharacter;

public class Strings {

    public char firstNonDuplicateCharacter(String string){
        if(string == null || string.isBlank()){
            return Character.MIN_VALUE;
        }

        for(int i = 0; i < string.length(); i++){

            char aChar = string.charAt(i);

            int counter = 0;
            for(int j = 0; j < string.length(); j++){
                if(aChar == string.charAt(j) && i != j){
                    counter++;
                    break;
                }
            }

            if(counter > 0){
                return aChar;
            }
        }

        return Character.MIN_VALUE;
    }
}
