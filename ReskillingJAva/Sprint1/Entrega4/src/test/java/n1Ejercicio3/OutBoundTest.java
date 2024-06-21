package n1Ejercicio3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OutBoundTest {
    
    OutBound out=new OutBound();
    
    @Test
    public void outOfBoundsTest () {
        assertThrows(IndexOutOfBoundsException.class, ()->out.getOutBounds());
    }
}
