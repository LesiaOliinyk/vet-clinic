package main_java_com_magicvet.service;

import main_java_com_magicvet.Main;
import main_java_com_magicvet.model.Dog;
import main_java_com_magicvet.model.Pet;

public class PetService {
    private static String DOG_TYPE = "dog";
    public Pet registerNewPet () {
        Pet pet = new Pet();
        System.out.print("Type (dog / cat / other): ");

        String type = Main.SCANNER.nextLine();
        pet.setType(type);

        if (DOG_TYPE.equals(type)) {
            pet=buildDog();
        } else {
            pet = buildPet(type);
        }

        return pet;
    }

    private Dog buildDog (){
        Pet pet = buildPet(DOG_TYPE);
        Dog dog = petToDog(pet);
        System.out.print("Size (xS / S / M / L /xxL): ");
        dog.setSize(Main.SCANNER.nextLine());

        return dog;
    }

    private Dog petToDog (Pet pet) {
        Dog dog = new Dog ();
        dog.setAge(pet.getAge());
        dog.setName(pet.getName());
        dog.setSex(pet.getSex());

        return dog;
    }
    private Pet buildPet (String type) {
         Pet pet = new Pet();
         pet.setType(type);

        System.out.print("Age: ");
        pet.setAge(Main.SCANNER.nextLine());
        System.out.print("Name: ");
        pet.setName(Main.SCANNER.nextLine());
        System.out.print("Sex (male / famale): ");
        pet.setSex(Main.SCANNER.nextLine());

        return pet;
    }
}
