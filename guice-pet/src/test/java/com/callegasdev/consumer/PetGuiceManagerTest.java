package com.callegasdev.consumer;

import com.callegasdev.services.BathService;
import com.callegasdev.services.CutHairService;
import com.callegasdev.services.MockBathService;
import com.callegasdev.services.MockCutHairService;
import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PetGuiceManagerTest {

    private Injector injector;

    @Before
    public void setUp() throws Exception {
        injector = Guice.createInjector(new AbstractModule() {

            @Override
            protected void configure() {
                bind(BathService.class).to(MockBathService.class);
                bind(CutHairService.class).to(MockCutHairService.class);
            }
        });
    }

    @After
    public void tearDown() throws Exception {
        injector = null;
    }

    @Test
    public void createBathService() {
        PetGuiceManager appTest = injector.getInstance(PetGuiceManager.class);
        Assert.assertEquals(true, appTest.executeBath(1, "dry", true));;
    }

    @Test
    public void createCutHairService() {
        PetGuiceManager appTest = injector.getInstance(PetGuiceManager.class);
        Assert.assertEquals(true, appTest.executeCutHair(1, "long"));
    }


}
