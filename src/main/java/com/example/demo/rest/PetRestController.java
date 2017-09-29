package com.example.demo.rest;

import com.example.demo.domain.Pet;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PetRestController {

    private static List<Pet> pets = new ArrayList<>();

    static {
        Pet pet1 = new Pet();
        pet1.setName("Peter");
        pet1.setHealthy(true);
        pet1.setColor("blau");

        Pet pet2 = new Pet();
        pet2.setName("Froschi");
        pet2.setHealthy(false);
        pet2.setColor("rot");

        pets.add(pet1);
        pets.add(pet2);
    }

    @RequestMapping("/pets")
    public List<Pet> allPets() {
        return pets;
    }

    @RequestMapping("/pets/{petname}")
    public Pet message(@PathVariable String petname) {
        return pets.stream()
                .filter(pet -> petname.toLowerCase().equals(pet.getName().toLowerCase()))
                .findFirst().orElse(null);
    }

}
