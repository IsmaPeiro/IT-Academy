package n3Exercise3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class IntArrayTest {
    IntArray array1;
    IntArray array2;
    
    @DisplayName("Initialization")
    @BeforeEach
    public void init() {
        array1=new IntArray(new int[] {1,2,3,4,5});
        array2=new IntArray(new int[] {1,2,3,4,5});
    }
    
    @DisplayName("Equals Test")
    @Test
    public void testEquals () {
        assertThat(array1.getArray()).isEqualTo(array2.getArray());
    }
    
    @DisplayName("Non Equals Test")
    @Test
    public void testNonEquals () {
        assertThat(array1.getArray()).isNotEqualTo(array2.getArray());
    }
}