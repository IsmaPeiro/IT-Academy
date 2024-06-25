package n1Exercise1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class YearArrayTest {
    //Verifica amb jUnit que la llista té 12 posicions,
    // que no és nul·la i que en la seva posició 8 conté el nom 'agost'.
    private YearArray year;
    
    @DisplayName("Initialization")
    @BeforeEach
    public void init() {
        year=new YearArray();
    }
    
    @DisplayName("Size test")
    @Test
    public void testTotalPositions () {
        assertEquals(12, year.getYear().size());
    }
    
    @DisplayName("Not Null Test")
    @Test
    public void testNotNull () {
        assertNotNull(year.getYear());
    }
    
    @DisplayName("August Position Test")
    @Test
    public void testAugustPosition () {
       assertEquals(7,year.getYear().indexOf("August"));
    }
}