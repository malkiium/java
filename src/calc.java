import java.util.Scanner;

public class calc {
    public static void main(String[] args) {
        // declaring the scanner object
        @SuppressWarnings("resource")
        Scanner input = new Scanner(System.in); System.out.println("what is your first number ? : "); int firstNum = input.nextInt(); System.out.println("what is your second number ? : "); int secNum = input.nextInt();

        // asking what type of operation
        System.out.println("what is your operation ? \n 1 = addition \n 2 = subtraction \n 3 = multiplication \n 4 = division");
        int operationType = input.nextInt();

        //testing and doing the operation
        if (operationType ==1) {
            System.out.println("\n the answer is : " + (firstNum + secNum));
        } else if (operationType ==2) {
            System.out.println("\n the answer is : " + (firstNum - secNum));
        } else if (operationType ==3) {
            System.out.println("\n the answer is : " + (firstNum * secNum));
        } else if (operationType ==4 && secNum!=0) {
            System.out.println("\n the answer is : " + (firstNum / secNum));
        } else if (secNum == 0) {
            System.out.println("\n sorry, you tried to divide with 0, this is impossible.");
        } else {
            System.out.println("there was an error. please try again later.");
        }
    }
}