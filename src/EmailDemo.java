import java.util.Scanner;

public class EmailDemo {

    public static Scanner scanner;
    public static User[] users;
    public static Email[] emails;
    public static Integer index = 0;
    public static Integer indexEmail = 0;
    public static User currentUser;

    public static void main(String[] args) {
        users = new User[100];
        emails = new Email[100];

        while (true){

            showMainMenu();
            System.out.print("Choose the operation: " + "\n");
            scanner = new Scanner(System.in);
            int choice = scanner.nextInt();

            switch (choice){
                case 1:
                    signIn();
                    break;
                case 2:
                    signUp();
                    break;
                case 0:
                    return;
            }
        }
    }

    private static void showMainMenu() {
        System.out.println("Main Menu");
        System.out.println("1. Sign In");
        System.out.println("2. Sign Up");
        System.out.println("0. Exit");
    }

    private static void signIn() {

        scanner = new Scanner(System.in);
        System.out.println("Enter Email Address: ");
        String email = scanner.next();

        for (User user : users){
            if (user != null){
                if (user.getEmail().equals(email))
                    currentUser = user;
            }
        }

        boolean success = false;
        if (currentUser != null){
            System.out.println("Enter Password: ");
            String password = scanner.next();

            for (User user : users){
                if (currentUser.getPassword().equals(password))
                    success = true;

            }
        }
        if (success){
            System.out.println(currentUser.getFirstName() + ", Welcome to Gmail");
            showEmailMenu();
        }
    }

    private static void showEmailMenu() {

        scanner = new Scanner(System.in);
        System.out.println("1. Send");
        System.out.println("2. Unread");
        System.out.println("3. Inbox");
        System.out.println("4. Outbox");
        System.out.println("0. Sign Out");

        System.out.print("Choose the Operation: ");
        int choice = scanner.nextInt();

        switch (choice){
            case 1:
                send();
                break;

            case 2:
                unread();
                break;

            case 3:
                inbox();
                break;

            case 4:
                outbox();
                break;
            case 0:
                return;

        }
    }

    private static void send() {

        System.out.println("Email Address");

        for (User user : users){
            if (user != null){
                if (user.equals(currentUser)) {
                    System.out.println(user.getEmail());
                }
            }
        }
        System.out.println("=========================");
        System.out.println("To: ");
        String receiverEmailAddress = scanner.next();
        User receiver = null;

        for (User user : users){
            if (user != null){
                if (user.getEmail().equals(receiverEmailAddress)){
                    receiver = user;
                }
            }
        }

        System.out.println("Subject: ");
        scanner = new Scanner(System.in);
        String subject = scanner.nextLine();

        System.out.println("Message: ");
        scanner = new Scanner(System.in);
        String message = scanner.nextLine();

        emails[indexEmail++] = new Email(subject,message,currentUser,receiver,true);
        System.out.println("Successfully Sent\n");

        System.out.println("1. Return Main Menu");
        System.out.println("1. Return Email Menu");

        scanner = new Scanner(System.in);
        System.out.println("Choose the Which one");
        int choice = scanner.nextInt();

        switch (choice){
            case 1:
                break;
            case 2:
                showEmailMenu();
                break;
        }


    }

    private static void unread() {

        for (Email email : emails){
            if (email != null){
                if (email.getReceiver().equals(currentUser)){
                    System.out.println(email.getSender().getEmail() + "sent new message to you");
                }
            }
        }

        System.out.println("=========================");

        System.out.println("1. Return Main Menu ");
        System.out.println("2. Return Email Menu ");

        System.out.println("=========================");
        scanner = new Scanner(System.in);

        System.out.print("Choose the Which one => ");
        int choice = scanner.nextInt();

        switch (choice){
            case 1:
                break;
            case 2:
                showEmailMenu();
                break;
        }

    }

    private static void inbox() {

        for (Email email : emails) {
            if (email!= null){
                if (email.getReceiver().equals(currentUser));

                System.out.println("==========================");
                System.out.println("Sender: " + email.getSender().getEmail());
                System.out.println("Title: " + email.getTitle());
                System.out.println("Message: " + email.getBody());

            }
        }

        System.out.println("=========================");

        System.out.println("1. Return Main Menu ");
        System.out.println("2. Return Email Menu ");

        System.out.println("=========================");
        scanner = new Scanner(System.in);

        System.out.print("Choose the Which one => ");
        int choice = scanner.nextInt();

        switch (choice){
            case 1:
                break;
            case 2:
                showEmailMenu();
                break;
        }

    }

    private static void outbox() {

        for (Email email : emails) {
            if (email != null){
                if (email.getSender().equals(currentUser)) {
                    System.out.println("==========================");
                    System.out.println("Receiver: " + email.getReceiver().getEmail());
                    System.out.println("Title: " + email.getTitle());
                    System.out.println("Message: " + email.getBody());
                }
            }
        }

        System.out.println("=========================");

        System.out.println("1. Return Main Menu ");
        System.out.println("2. Return Email Menu ");

        System.out.println("=========================");
        scanner = new Scanner(System.in);

        System.out.print("Choose the Which one => ");
        int choice = scanner.nextInt();

        switch (choice){
            case 1:
                break;
            case 2:
                showEmailMenu();
                break;
        }
    }

    private static void signUp() {
        scanner = new Scanner(System.in);
        User user = new User();

        System.out.print("Enter Firstname: ");
        String firstname = scanner.nextLine();

        System.out.print("Enter Lastname: ");
        String lastname = scanner.next();

        System.out.print("Enter Password: ");
        String password = scanner.next();

        while (true) {

            System.out.print("Retype Password: ");
            String reType = scanner.next();

            if (password.equals(reType))
                break;
        }

        while (true) {
            System.out.println("Enter Email Address (123@mail.com): ");
            String email = scanner.next();

            boolean validateEmail = user.validateEmail(email);
            if (validateEmail) {
                user.setEmail(email);
                break;
            } else {
                System.out.println("Your Email Invalid!!!");
            }
        }

        if (!firstname.isEmpty() && !lastname.isEmpty() && !password.isEmpty()) {
            user.setFirstName(firstname);
            user.setLastName(lastname);
            user.setPassword(password);
        }

        users[index++] = user;
        System.out.println("Successfully Registered\n");
        System.out.println("Will you continue the operation ? " + "Yes or No");

        while (true){
            boolean variable = scanner.hasNextBoolean();
            if (!variable){
                System.out.println("You stopped the Operation");
                break;
            }
            else return;
        }

    }



}
