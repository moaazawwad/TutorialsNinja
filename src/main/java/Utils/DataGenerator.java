package Utils;

import java.util.Random;
import java.util.UUID;

public class DataGenerator {

    public static String generateFirstName() {
        return "FirstName" + new Random().nextInt(400);
    }

    public static String generateLastName() {
        return "LastName" + new Random().nextInt(400);
    }

    public static String generateEmail() {
        return "user" + UUID.randomUUID() + "@example.com";
    }

    public static String generateTelephone() {
        return "+2010" + (10000000 + new Random().nextInt(90000000));
    }

    public static String generatePassword() {
        return "Pass" + UUID.randomUUID().toString().substring(0, 6);
    }
}
