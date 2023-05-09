public class Circle extends Shape {

    private double radios=1.0;
    final double pi=3.14;
public Circle(){



}

    public Circle(double radios) {
        this.radios = radios;
    }

    public Circle(String color, boolean filled, double radios) {
        super(color, filled);
        this.radios = radios;
    }

    public double getRadios() {
        return radios;
    }

    public void setRadios(double radios) {
        this.radios = radios;
    }

    public double getArea(){

    return ((radios*radios)*pi);




    }

    public double getPerimeter(){

   return (2*pi*radios);
    }

    @Override
    public String toString() {
        return "Circle{" +
                "radios=" + radios +
                ", pi=" + pi +
                '}'+" which is a subclass of " + super.toString();
    }

}
