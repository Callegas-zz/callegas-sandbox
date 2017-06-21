package com.callegasdev.services;

import com.callegasdev.consumer.PetGuiceManager;
import com.callegasdev.injector.AppInjector;
import com.google.inject.Guice;
import com.google.inject.Injector;
import org.junit.Assert;
import org.junit.Test;

public class ServiceRegistrationTest {

    Injector injector = Guice.createInjector(new AppInjector());
    PetGuiceManager appTest = injector.getInstance(PetGuiceManager.class);

    @Test
    public void whenRegisterService(){
        ServicesBag service = new ServicesBag(1, "service");
        Assert.assertEquals(appTest.registerService(service), service);
    }

    @Test
    public void callTop10PetsRevenue(){
        Assert.assertTrue(appTest.top10PetsRevenue());
    }

}
