package firstNonRepeatedCharacter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringsTest {

    Strings stringClass;
   @BeforeEach
    void setUp() {
       stringClass = new Strings();
    }

    @Test
    void findNonRepeatedUsingNestedLoop(){
       String str = "Loop and break solution";
       char result = stringClass.firstNonDuplicateCharacter(str);
       assertEquals('p', result);
    }
}