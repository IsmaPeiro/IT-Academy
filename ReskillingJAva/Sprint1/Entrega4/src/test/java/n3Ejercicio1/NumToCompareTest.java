package n3Ejercicio1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class NumToCompareTest {
    IntNum num1;
    IntNum num2;
    
    @DisplayName("Initialization")
    @BeforeEach
    public void init() {
        num1=new IntNum(1);
        num2=new IntNum(2);
    }
    
    @DisplayName("Equals Test")
    @Test
    public void testEquals () {
        assertThat(num1.getNum()).isEqualTo(num2.getNum());
    }
    
    @DisplayName("Non Equals Test")
    @Test
    public void testNonEquals () {
        assertThat(num1.getNum()).isNotEqualTo(num2.getNum());
    }
}