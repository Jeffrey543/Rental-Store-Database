public class MovieLinkedList {
    public MovieNode movieHead;

    public MovieLinkedList() {
        movieHead = null;
    }

    public void movieAdd(MovieNode m) {
        m.movieNext = movieHead;
        movieHead = m;
    }

    public String getBorrowed(String movieName) {
        MovieNode current = movieHead;
        while (current != null) {
            if (current.m.name.equalsIgnoreCase(movieName)) {
                return current.m.borrowed;
            }
            current = current.movieNext;
        }
        return "";
    }

    public Movie findBarcode(String barcode) {
        MovieNode current = movieHead;
        while (current != null) {
            if (current.m.barcode.equalsIgnoreCase(barcode)) {
                return current.m;
            }
            current = current.movieNext;
        }
        return null;
    }
}