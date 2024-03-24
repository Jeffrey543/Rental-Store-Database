public class Movie {
    public String name;
    public String barcode;
    public String borrowed;

    public Movie(String name, String barcode) {
        this.name = name;
        this.barcode = barcode;
        this.borrowed = "";
    }
}