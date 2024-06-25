package n3Ejercicio7;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class EmptyOptionalTest {
    EmptyOptional o=new EmptyOptional();
    
    @Test
    @DisplayName("Empty Optional Test")
    public void emptyTest () {
        
        assertThat(o.getEmptyOptional()).isEmpty();
    }
}