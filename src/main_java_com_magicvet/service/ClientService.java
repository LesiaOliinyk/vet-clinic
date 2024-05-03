package main_java_com_magicvet.service;

import main_java_com_magicvet.Main;
import main_java_com_magicvet.model.Client;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ClientService {
    private static String EMAIL_PATTERN = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
    public Client registerNewClient() {
        Client client = null;

        System.out.println("Please, provide a client details: ");
        System.out.print("Email: ");
        String email = Main.SCANNER.nextLine();
        if (isEmailValid(email)) {
            client = buildClient(email);
            System.out.println("New client " + client.getFirstName() + " "
                    + client.getLastName() + " ("
                    + client.getEmail() + ")");
        } else {
            System.out.println("Provided email is invalid.");
        }

        return client;
    }
    private static Client buildClient(String email) {
        Client client = new Client();
        client.setEmail(email);
        System.out.print("First Name: ");
        client.setFirstName(Main.SCANNER.nextLine());
        System.out.print("Last Name: ");
        client.setLastName(Main.SCANNER.nextLine());
        return client;

    }


    private static boolean isEmailValid(String email) {
        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
}
