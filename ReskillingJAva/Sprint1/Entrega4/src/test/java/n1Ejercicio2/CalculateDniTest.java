package n1Ejercicio2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CalculateDniTest {
    List<String> numsDNI = Arrays.asList(
            "00000000-T",
            "11111111-H",
            "22222222-J",
            "33333333-P",
            "44444444-A",
            "55555555-K",
            "66666666-Q",
            "77777777-B",
            "88888888-Y",
            "99999999-R"
    );
    
    @DisplayName("DNI Letter Test")
    @Test
    public void testLetterDni() {
        numsDNI.forEach(dni -> {
            char letter = CalculateDni.getLetterDni(Integer.parseInt(dni.split("-")[0]));
            assertEquals(dni.split("-")[1].charAt(0), letter);
        });
    }
    
    
}