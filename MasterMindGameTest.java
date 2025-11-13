import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.*;
import java.util.regex.*;

public class MasterMindGameTest {

    private static final String SYMBOLS = "0123456789";
    private static final Pattern CODE_PATTERN = 
        Pattern.compile("[" + Pattern.quote(SYMBOLS) + "]{4}");


@Test
void isExactlyFourSymbols() {

    String code = CodeGenerator.generateCode();
    assertEquals(4, code.length(), "Code should be 4 symbol long");

}

@Test
void areFromSymbolSet() {

    String code = CodeGenerator.generateCode();
    assertTrue(CODE_PATTERN.matcher(code).matches(), "Code must be from this symbol set: " + SYMBOLS);

}

@Test
void isNotMoreThanTwiceTheSize() {

    Map<String, Integer> counts = new HashMap<>();
    int sampleSize = 100;

    for (int i = 0; i < sampleSize; i++) {
        String code = CodeGenerator.generateCode();
        counts.merge(code, 1, Integer::sum);
    }

    counts.forEach((code, count) ->
        assertTrue(count <= 2, "Code '" + code + "' appeared " + count + " times"));
}

}