package ui.model;


import java.io.*;


public class Snack implements Stuffs {
    public int num;



    public Snack() {

        num = 0;
    }

    public int Fees(String type, int num) {
        if (type.equals("16 oz")) {
            return 3 * num;
        }
        if (type.equals("12 oz")) {
            return 2 * num;
        }
        if (type.equals("8 oz")) {
            return num;
        }
        return 0;
    }


    @Override
    public int minNum() {
        return 0;
    }

    @Override
    public int maxNum() {
        return 8;
    }

    @Override
    public void count(String type, int n) throws IOException {
        num = Fees(type, n);
        System.out.println(Integer.toString(num));
        Save(Integer.toString(num));
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


}

