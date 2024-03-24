public class MovieNode {
    public Movie m;
    public MovieNode movieNext;

    public MovieNode(Movie m) {
        this.m = m;
        this.movieNext = null;
    }
}