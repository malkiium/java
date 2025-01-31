public class factorial {
    public static void main(String[] args) {

        long nwMillis = System.currentTimeMillis();
        long i = 1;
        long y = 1;
        long endMillis = 0;

        System.out.println("\n\n\n" + Long.MAX_VALUE + "\n");

        while(i<= 999) {
            y = y * i;
            System.out.println(i + "! =" + y);
            i++;
        }
        endMillis = System.currentTimeMillis();
        System.out.println((endMillis-nwMillis));

    }
}
