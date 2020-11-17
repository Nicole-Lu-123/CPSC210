package mtest;

import org.junit.jupiter.api.Test;
import ui.model.Tickets;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FeesTest {
    int n1 = -1;
    int x = 2;
    int y = 3;
    String t1 = "team";
    String t2 = "kid";
    Tickets t = new Tickets();
    public boolean validType(String type) {
        return type.equals("kid") || type.equals("family") || type.equals("adult");
    }
    public boolean validNum(int n){
        return n >= 0;
    }
    public boolean validMul(int a, int b) {
        return a >= 0 && b >= 0;
    }

//    @Test
//    public void testtickets(){
//        assertFalse(validType(t1));
//        assertTrue(validType(t2));
//
//        assertFalse(validNum(n1));
//        assertTrue(validNum(x));
//
//
//    }
    @Test
    public void testMultiply(){
        assertFalse(validNum(n1));
       assertTrue(validNum(x));
        assertTrue(validNum(y));
        assertTrue(validMul(x,y));
        assertFalse(validMul(x,n1));
    }
    @Test
    public void testFees(){
        assertFalse(validType(t1));
        assertTrue(validType(t2));
        assertEquals(t.Fees(t2,1),5);
        assertEquals(t.Fees(t1,3),0);
    }
}



