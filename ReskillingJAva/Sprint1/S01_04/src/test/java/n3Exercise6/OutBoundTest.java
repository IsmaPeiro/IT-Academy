package n3Exercise6;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class OutBoundTest {
    OutBound out = new OutBound();
    
    @DisplayName("Validate Exveption")
    @Test
    public void testException() {
        try {
            out.getOutBounds();
            failBecauseExceptionWasNotThrown(IndexOutOfBoundsException.class);
        } catch (IndexOutOfBoundsException e) {
            assertThat(e).hasNoCause();
            
        }
        
        
    }
}