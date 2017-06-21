package com.callegasdev.pet;

import javax.inject.Singleton;
import java.util.ArrayList;
import java.util.List;

@Singleton
public class PetRegistration {
    List<Pet> petList = new ArrayList<>();

    public Pet registerPet(Pet pet) {
        if( pet.getId() == null ) {
            pet.setId( petList.size() + 1 );
        }
        petList.add( pet );
        return pet;
    }

    public Pet searchPet(Integer petId){
        for(Pet p : petList) {
            if (p.getId() == petId)
                return p;
        }
        return new Pet();
    }

    public List<Pet> searchByAge(Integer age) {
        List<Pet> agePetList = new ArrayList<>();

        for(Pet p : petList) {
           if (p.getAge() == 30) {
               agePetList.add(p);
           }
        }

        return agePetList;
    }
}
