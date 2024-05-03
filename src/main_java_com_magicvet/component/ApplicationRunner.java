package main_java_com_magicvet.component;

import main_java_com_magicvet.model.Client;
import main_java_com_magicvet.model.Pet;
import main_java_com_magicvet.service.ClientService;
import main_java_com_magicvet.service.PetService;

public class ApplicationRunner {
    private ClientService clientService = new ClientService();
    private PetService petService = new PetService();
    public void run() {
        if (Authenticator.auth()) {
            Client client = clientService.registerNewClient();
            if (client != null) {
                System.out.println("Adding a new pet.");
                Pet pet = petService.registerNewPet();
                client.setPet (pet);
                pet.setOwnerName(client.getFirstName() + " " + client.getLastName());
                System.out.println("Pet has been added.");
            }
        }
    }
}
