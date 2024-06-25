package n3Exercise5;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MapTest {
    Map m;
    
    @DisplayName("Initialization")
    @BeforeEach
    public void init() {
        m=new Map();
        m.add(1, "One");
        m.add(2, "Two");
        m.add(3, "Three");
        m.add(4, "Four");
    }
    
    @DisplayName("Contains Key")
    @Test
    public void testOrder () {
        assertThat(m.getMap()).containsKeys(3);
    }
    
    
    
}
