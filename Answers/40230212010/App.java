import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String first, last;

        System.out.println("Please Enter your firstname : ");
        first = scanner.nextLine();

        System.out.println("Please Enter your lastname : ");
        last = scanner.nextLine();

        String full = fullName(first, last);

        String phone = phoneNumber(scanner);

        String id = userId(scanner);

        String[] inteterests = getInterests(scanner);

        String information = userFullInformation(full, phone, id, inteterests);
        System.out.println(information);

        String encoded = informationEncoder(scanner, information);

        informationDecoder(scanner, encoded);

        scanner.close();
    }

    public static String fullName(String firstName, String lastName) {

        firstName = firstName.substring(0, 1).toUpperCase() + firstName.substring(1).toLowerCase();
        lastName = lastName.substring(0, 1).toUpperCase() + lastName.substring(1).toLowerCase();
        return firstName + " " + lastName;
    }

    public static String phoneNumber(Scanner scanner) {

        String phone;
        while (true) {
            System.out.println("Enter your phone : ");

            phone = scanner.nextLine();

            if (phone.length() == 10 && phone.startsWith("9")) {

                return "0" + phone;
            } else {
                System.out.println("Wrong entry. Try again.");
            }
        }

    }

    public static String userId(Scanner scanner) {
        while (true) {
            System.out.println("Enter your ID :");
            String id = scanner.nextLine();
            if (id.length() >= 4 && id.length() <= 13) {
                return id;
            } else {
                System.out.println("Wrong entry. Try again.");
            }

        }
    }

    public static String[] getInterests(Scanner scanner) {
        String[] interests = new String[10];
        System.out.println("enter your interest: (type exit to finish)");
        for (int i = 0; i < 10; i++) {
            String s = scanner.nextLine();
            if (s.equals("exit")) {
                break;
            }
            interests[i] = s;
        }
        return interests;

    }

    public static String userFullInformation(String fullName, String phoneNumber, String userID, String[] interests) {
        StringBuilder sb = new StringBuilder();
        sb.append(
                "Hello! My name is " + fullName + ". My ID is " + userID + ". Here are some of my interests: " + "\n");
        for (int i = 0; i < interests.length; i++) {
            if (interests[i] != null) {
                sb.append((i + 1) + "." + interests[i] + "\n");
            }
        }
        sb.append("You can reach me via my phone number " + phoneNumber + ".");
        return sb.toString();
    }

    public static String informationEncoder(Scanner scanner, String info) {
        System.out.println("Please enter your shift key to encode:");
        int n = scanner.nextInt();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < info.length(); i++) {
            char ch = info.charAt(i);
            if (ch >= 97 && ch <= 122) {
                sb.append((char) ('a' + ((ch - 'a' + n) % 26)));
            } else if (ch >= 65 && ch <= 90) {
                sb.append((char) ('A' + ((ch - 'A' + n) % 26)));
            } else {
                sb.append(ch);
            }

        }
        System.out.println("your encoded informations is :");
        System.out.println(sb.toString());
        return sb.toString();
    }

    public static void informationDecoder(Scanner scanner, String info) {
        System.out.println("Please enter your shift key to decode:");
        int n = scanner.nextInt();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < info.length(); i++) {
            char ch = info.charAt(i);
            if (ch >= 'a' && ch <= 'z') {
                sb.append((char) ('a' + ((ch - 'a' - n + 26) % 26)));
            } else if (ch >= 'A' && ch <= 'Z') {
                sb.append((char) ('A' + ((ch - 'A' - n + 26) % 26)));
            } else {
                sb.append(ch);
            }

        }
        System.out.println("your decoded informations is :");
        System.out.println(sb.toString());
    }
}
