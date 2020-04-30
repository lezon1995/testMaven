package runes;

public class Turret {
    public String code;
    public String name;
    public int cost;
    public String bondType;
    public String bondTypeImage;
    public String bondElement;
    public String bondElementImage;


    public Turret(String code, String name, int cost, String bondType, String bondTypeImage, String bondElement, String bondElementImage) {
        this.code = code;
        this.name = name;
        this.cost = cost;
        this.bondType = bondType;
        this.bondTypeImage = bondTypeImage;
        this.bondElement = bondElement;
        this.bondElementImage = bondElementImage;
    }
}
