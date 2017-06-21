package com.callegasdev.pet;

import com.callegasdev.consumer.PetGuiceManager;
import com.callegasdev.injector.AppInjector;
import com.google.inject.Guice;
import com.google.inject.Injector;
import org.junit.Assert;
import org.junit.Test;

public class PetRegistrationTest {

    Injector injector = Guice.createInjector(new AppInjector());
    PetGuiceManager appTest = injector.getInstance(PetGuiceManager.class);


    @Test
    public void registerValidPet(){
        Assert.assertNotNull(appTest.registerPet(new Pet("Fish", "Babel", 30)));
    }

    @Test
    public void searchPetByAge(){
        Assert.assertNotNull(appTest.searchByAge(30));
    }


}
