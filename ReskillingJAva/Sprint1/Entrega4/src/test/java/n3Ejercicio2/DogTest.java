package n3Ejercicio2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class DogTest {
    Dog dog1;
    Dog dog2
            ;
    
    @DisplayName("Initialization")
    @BeforeEach
    public void init() {
        dog1=new Dog("Fido", 5.25f);
        dog2=new Dog("Fido", 5.25f);
    }
    
    @DisplayName("Equals Test")
    @Test
    public void testEquals () {
        assertThat(dog1).isEqualTo(dog2);
    }
    
    @DisplayName("Non Equals Test")
    @Test
    public void testNonEquals () {
        assertThat(dog1).isNotEqualTo(dog2);
    }
}
