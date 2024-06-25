package n3ejercicio4;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


class ListOfObjectsTest {
    ListOfObjects list;
    
    @DisplayName("Initialization")
    @BeforeEach
    public void init() {
        list=new ListOfObjects();
        list.addObject(123456);
        list.addObject(false);
        list.addObject("String");
        //list.addObject("Removable");
    }
    
    @DisplayName("Order Verification")
    @Test
    public void testOrder () {
        assertThat(list.getList()).containsExactly(123456, false, "String");
    }
    
    @DisplayName("Any Order Verification")
    @Test
    public void testAnyOrder () {
        assertThat(list.getList()).contains(false, "String", 123456);
    }
    
    @DisplayName("Only Once Object")
    @Test
    public void onluOnce () {
        assertThat(list.getList()).containsOnlyOnce(123456);
    }
    
    @DisplayName("Not Contains")
    @Test
    public void notContains () {
        assertThat(list.getList()).doesNotContain("Removable");
    }
    
}

