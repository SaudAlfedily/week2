public class Main {


    public static void  main(String[] args){
Book b1=new Book("book",100,"ibra");
        System.out.println("price "+ b1.getPrice());

        System.out.println(b1.getDiscount());
        b1.setPrice(500);
        System.out.println("price "+ b1.getPrice());
        System.out.println(b1.getDiscount());


        Movie m1=new Movie("Movie",100,"Saud");

        System.out.println("price "+ m1.getPrice());

        System.out.println(m1.getDiscount());
        m1.setPrice(500);
        System.out.println("price "+ m1.getPrice());
        System.out.println(m1.getDiscount());

//        Movie m2=new Movie("Movie",1000,"ali");
//        System.out.println(m2.getDiscount());


    }
}
