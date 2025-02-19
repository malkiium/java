public class trilcount {
    public static void main(String[] args) {
        long nwMillis = System.currentTimeMillis();
        long endMillis = 0;

        for(long i=1; i<=1_000_000_000L; i++) {
            System.out.println(i);
        }
        endMillis = System.currentTimeMillis();
        System.out.println((endMillis-nwMillis)/1000 + "." + (endMillis-nwMillis) );
    }
}
