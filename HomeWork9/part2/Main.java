public class Main {
    public static void main(String[] args) {
        MovablePoint m1=new MovablePoint(2,2,1,1);

        m1.moveUp();
      //y=  2-1 = 1
        m1.moveLeft();
        //x 2-1 =1
        System.out.println("x=  "+m1.getX()+" y = " +m1.getY());

        m1.moveDown();
        //y=  1+1 = 2
        m1.moveRight();
        //x 1+1 =2
        System.out.println("x=  "+m1.getX()+" y = " +m1.getY());


    }
}
