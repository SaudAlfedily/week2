import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Arrays;
public class Main {
    public static void main(String[] args) {

        Scanner scanner=new Scanner(System.in);
        
        System.out.print("Enter the number of elements you want to store: ");
       try {
           int size = scanner.nextInt();
           int[] array = new int[size];

           while (size==0){
              System.out.println("please enter larger number ");
                size = scanner.nextInt();
                array = new int[size];}


           System.out.println("Accept elements of an array: ");
           for (int i = 0; i < size; i++) {
               array[i] = scanner.nextInt();
           }

           System.out.println("Array elements are: ");
           for (int i = 0; i < size; i++) {
               System.out.println(array[i]);
           }


           mainLoop:
           while (true) {
               Scanner choice = new Scanner(System.in);
               System.out.println("\n***Menu***");
               System.out.println("1.Display elements of an array");
               System.out.println("2.Search the element within array ");
               System.out.println("3.sort the array ");
               System.out.println("4. Terminate the program");
               int command;

               command = choice.nextInt();


               switch (command) {
                   case 1:
                       System.out.println("Array elements are: ");
                       for (int i = 0; i < size; i++) {
                           System.out.println(array[i]);
                       }

                       break;
                   case 2:
                       boolean no = true;
                       System.out.println("Enter elements you want to find ");
                       int find = scanner.nextInt();


                       for (int element : array) {

                           if (element == find) {
                               no = false;

                               System.out.println(find + " is in the array ");
                               break;

                           }

                       }

                       if (no) {
                           System.out.println(find
                                   + " is not  in the array .");
                       }
                       break;


                   case 3:

                       Arrays.sort(array);

                       System.out.println("Array elements are  sort : ");
                       System.out.printf(Arrays.toString(array));
                       break;
                   case 4:
                       System.out.println("program end ");
                       break mainLoop;
                   default:
                       System.out.println("Wrong choice!!");

               }
           }
       }catch (InputMismatchException | NegativeArraySizeException e1){

           System.out.println("please enter valid number");
       }

    }}