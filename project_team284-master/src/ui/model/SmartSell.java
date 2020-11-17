package ui.model;



import java.util.ArrayList;
import java.util.List;

public class SmartSell {
    private List<Stuffs> stuffs;


    public SmartSell(){
        stuffs = new ArrayList<>();
    }

    public void install(Stuffs s){
        stuffs.add(s);
    }
}
