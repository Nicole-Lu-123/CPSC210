package mtest;


import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import ui.model.Snack;
import ui.model.Stuffs;
import ui.model.Tickets;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

//public class StuffTest {
//    private Stuffs suffs;
//    private Tickets tickets;
//    private Snack snack;
//    private int f;
//    private int a;
//    private int k;
//
//    @BeforeEach
//    public void begin(){
//        tickets = new Tickets();
//        snack = new Snack();
//        f = 30;
//        a = 12;
//        k = 5;
//    }
//
//    @Test
//    public void testminNum(){
//        assertEquals(0,snack.minNum());
//        assertEquals(0,tickets.minNum());
//    }
//    @Test
//    public void testmaxNum(){
//        assertEquals(8,snack.maxNum());
//        assertEquals(10,tickets.maxNum());
//    }
//    @Test
//    public void testcount() throws IOException {
//        snack.count("16 oz",1);
//        assertEquals(3,snack.num);
//        snack.count("12 oz",2);
//        assertEquals(4,snack.num);
//        tickets.count("kid",2);
//        assertEquals(2*k,tickets.num);
//        tickets.count("family",2);
//        assertEquals(2*f,tickets.num);
//        tickets.count("adult",1);
//        assertEquals(a,tickets.num);
//    }
//}
