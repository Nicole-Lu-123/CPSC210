package ui.model;


import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class Tickets implements Stuffs {

    private int num;
    private int f = 30;
    private int a = 12;
    private int k = 5;
    List<Movie> movies;
    StringBuilder sb ;

    public Tickets(){
        num = 0;
        movies = new ArrayList<>();
        sb = new StringBuilder("");
    }


    public void addToMovies(Movie m) {
        if (!movies.contains(m)) {
            movies.add(m);
            m.addToTickets(this);
        }
    }

    public void RemoveFromMovie(Movie m) {
        if (!movies.contains(m)) return;
        if (movies.contains(m)) {
            movies.remove(m);
            m.RemoveTicket(this);
        }
    }
    public int Fees(String type, int num) {
        if (num >= 0) {
            switch (type) {
                case "family":
                    return f * num;
                case "adult":
                    return a * num;
                case "kid":
                    return k * num;
                default:
                    return 0;
            }
        } else return 0;
    }



    @Override
    public int minNum() {
        return 0;
    }

    @Override
    public int maxNum() {
        return 10;
    }



    public static void Save(String s) throws IOException {
        PrintWriter writer = new PrintWriter(new FileWriter("output", true));
        writer.println(s);
        writer.close();
    }

    @Override
    public void infoadd(String s) throws IOException {
        Save(s);
    }

    @Override
    public void count(String type,int n) throws IOException {
        num = Fees(type,n);
        System.out.println(Integer.toString(num));
        Save(Integer.toString(num));
    }
        }

