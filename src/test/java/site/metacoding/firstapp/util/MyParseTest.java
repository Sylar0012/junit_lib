package site.metacoding.firstapp.util;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class MyParseTest {

    @Test
    public void changeStringToInt_test() {
        // given
        String value = "1";

        // when
        int result = Integer.parseInt(value);

        // then
        assertEquals(1, result);
    }
}