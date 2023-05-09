public class Square extends  Rectangle{
//all side of square are the same  so side =length =width

    public Square() {
    }

    public Square(double side) {
        super(side, side);
    }

    public Square(double side ,String color,  Boolean filled) {
        super(color,filled,side,side);
    }
    public double getSide(){

        return super.getWidth();
    }
public void setSide(double width){
        super.setLength(width);
        super.setWidth(width);

}

    @Override
    public String toString() {
        return "Square{" +
                "side= " + getSide() +
                '}' +" which is a subclass of " + super.toString();
    }
}
