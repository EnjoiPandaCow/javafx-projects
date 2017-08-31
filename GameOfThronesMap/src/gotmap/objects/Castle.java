package gotmap.objects;

public class Castle {
    public String castleName;
    public CastleDisplayInfo display;

    public Castle(String castleName) {
        this.castleName = castleName;
    }

    public Castle(String castleName, CastleDisplayInfo display) {
        this.castleName = castleName;
        this.display = display;
    }
}
