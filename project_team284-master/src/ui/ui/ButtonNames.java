package ui.ui;

public enum ButtonNames {
    TICKETS("Buy Tickets"),
    SNACK("Buy snacks"),
    ATICKETS("Movie A"),
    BTICKETS("Movie B"),
    CTICKETS("Movie C"),
    GENERATE_REPORT ("Receipt");


    private final String name;
    ButtonNames(String s) {
        this.name = s;
    }
    public String getValue(){
        return name;
    }
}

