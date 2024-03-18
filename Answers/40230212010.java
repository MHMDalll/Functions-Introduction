import java.util.Scanner;

public class 40230212010 {
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

        String encoded = informationEncoder(scanner , information);

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



}