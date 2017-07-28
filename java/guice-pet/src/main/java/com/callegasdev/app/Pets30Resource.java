package com.callegasdev.app;

import com.callegasdev.consumer.PetGuiceManager;
import com.callegasdev.injector.AppInjector;
import com.callegasdev.pet.Pet;
import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;


@Path("/petsWith30Years")
public class Pets30Resource {

    private PetGuiceManager petGuiceManager;

    @Inject
    public Pets30Resource(PetGuiceManager petGuiceManager) {
        this.petGuiceManager = petGuiceManager;
    }

    @GET
    @Produces
    public String find(){

        
        petGuiceManager.registerPet(new Pet("Fish", "Babel", 30));
        petGuiceManager.registerPet(new Pet("DoCat", "Half dog half cat", 30));
        petGuiceManager.registerPet(new Pet("Bola", "Monster", 30));

        return petGuiceManager.searchByAge(30) + "";

    }


}