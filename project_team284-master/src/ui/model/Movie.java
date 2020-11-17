package ui.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Movie {
    HashMap<String, Integer> ticketssum;
    List<Tickets> tickets;



    public Movie() {
        super();
        ticketssum = new HashMap<>();
        ticketssum.put("A", 20);
        ticketssum.put("B", 30);
        ticketssum.put("C", 25);
        tickets = new ArrayList<>();


    }


    public void addToTickets(Tickets t) {
        if (t == null) return;
        if (!tickets.contains(t)) {
            tickets.add(t);
            t.addToMovies(this);
        }
    }

    public void RemoveTicket(Tickets t) {
        if (t != null){
            tickets.remove(t);
            t.RemoveFromMovie(this);
        }

    }

//    public boolean substracttickets(String m, String s, int n) {
//        if (s.equals("family")) {
//            int sum = getSum(m);
//            sum -= 2 * n;
//            if (sum < 0) {
//                return false;
//            } else {
//                ticketssum.put(m, sum);
//                return true;
//            }
//        } else {
//            int sum = getSum(m);
//            sum -= n;
//            if (sum < 0) {
//                return false;
//            } else {
//                ticketssum.put(m, sum);
//                return true;
//            }
//        }


    public int getSum(String s) {
        return ticketssum.get(s);
    }

}
