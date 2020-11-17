package ui.model;



import java.io.IOException;


public interface Stuffs {

    int minNum();

    int maxNum();

    void count(String type,int num) throws IOException;


    void infoadd(String s) throws IOException;
}
