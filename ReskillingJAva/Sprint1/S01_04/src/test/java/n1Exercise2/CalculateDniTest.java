package n1Exercise2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CalculateDniTest {
    
    @DisplayName("DNI Letter Test")
    @ParameterizedTest
    @CsvSource({
            "00000000,T",
            "11111111,H",
            "22222222,J",
            "33333333,P",
            "44444444,A",
            "55555555,K",
            "66666666,Q",
            "77777777,B",
            "88888888,Y",
            "99999999,R"
    })
    public void testLetterDni(int num, char chr) {
        assertEquals(CalculateDni.getLetterDni(num),chr);
    }
}