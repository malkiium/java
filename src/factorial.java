public class factorial {
    public static void main(String[] args) {

        long i = 1;
        long y = 1;

        System.out.println("\n\n\n" + Long.MAX_VALUE + "\n");

        while(i<= 65) {
            y = y * i;
            System.out.println(i + "! =" + y);
            i++;
        }

    }
}
