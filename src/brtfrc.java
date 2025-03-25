import java.util.Random;

public class brtfrc {
    private static final String CHARSET = 
        "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789"
        + "!@#$%^&*()_+-=,./<>?;:'\"[]{}`~|\\¡¿€£¥©®±×÷"; // Printable UTF-8 characters

    public static void main(String[] args) {
        int passwordLength = 5;  // Set password length
        String password = generateRandomPassword(passwordLength);
        System.out.println("🎯 Generated password: " + password);

        bruteForce(password);
    }

    private static String generateRandomPassword(int length) {
        Random random = new Random();
        StringBuilder sb = new StringBuilder(length);

        for (int i = 0; i < length; i++) {
            sb.append(CHARSET.charAt(random.nextInt(CHARSET.length())));
        }
        return sb.toString();
    }

    private static void bruteForce(String targetPassword) {
        int length = 1;
        long attempts = 0;

        while (true) {
            System.out.println("🔎 Trying length " + length + "...");

            if (attemptCombinations("", targetPassword, length, attempts)) {
                break;
            }

            length++; // Increase password length if not found
        }
    }

    private static boolean attemptCombinations(String prefix, String target, int length, long attempts) {
        if (prefix.length() == length) {
            attempts++;

            // Reduce print frequency for performance
            if (attempts % 1000000 == 0) {
                System.out.println("Attempt " + attempts + ": " + prefix);
            }

            if (prefix.equals(target)) {
                System.out.println("✅ Password found after " + attempts + " attempts: " + prefix);
                return true;
            }
            return false;
        }

        for (char ch : CHARSET.toCharArray()) {
            if (attemptCombinations(prefix + ch, target, length, attempts)) {
                return true;
            }
        }

        return false;
    }
}
