package util;
import java.util.Random;

public class UtilityCodes {

//generate random first name
    public static String generateRandomFirstName() {
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"; // Only uppercase letters
        StringBuilder sb = new StringBuilder();
        Random random = new Random();

        for (int i = 0; i < 10; i++) {
            int index = random.nextInt(chars.length());
            sb.append(chars.charAt(index));
        }

        return sb.toString();
    }

    //generate random Phone number
    public static String generateRandomPhoneNumber() {
        Random random = new Random();
        StringBuilder sb = new StringBuilder();

        // Choose a random country code (example: USA, India, UK)
        int countryCodeIndex = random.nextInt(3); // Assuming 3 sample country codes
        String[] countryCodes = {"+966", "+91", "+44"};
        sb.append(countryCodes[countryCodeIndex]);

        // Generate 10 random digits for the phone number
        for (int i = 0; i < 10; i++) {
            sb.append(random.nextInt(10));
        }

        return sb.toString();
    }
}


