package me.nssj.ultimatebows.bows;


public class Bow {
    private final String name;
    private final String[] description;

    public Bow(String name, String[] description) {
        this.name = name;
        this.description = description;

        BowsManager.addBow(this);
    }

    public String getName() {
        return name;
    }

    public String[] getDescription() {
        return description;
    }

}
