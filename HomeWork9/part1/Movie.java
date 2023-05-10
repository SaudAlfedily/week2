public class Movie extends Product {
    private String director;

    public Movie() {
    }

    @Override
    public double getDiscount() {
        //assume discount 5% in Movie
        double x ;
        x= getPrice()*0.05;
        return (getPrice()-x);
    }

    public Movie(String director) {
        this.director = director;
    }

    public Movie(String name, double price, String director) {
        super(name, price);
        this.director = director;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

}
