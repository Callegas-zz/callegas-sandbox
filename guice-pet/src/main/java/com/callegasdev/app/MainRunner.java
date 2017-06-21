package com.callegasdev.app;

import com.callegasdev.consumer.PetGuiceManager;
import com.callegasdev.injector.AppInjector;
import com.google.inject.Guice;
import com.google.inject.Injector;
import netflix.adminresources.resources.KaryonWebAdminModule;
import netflix.karyon.Karyon;
import netflix.karyon.ShutdownModule;
import netflix.karyon.archaius.ArchaiusBootstrapModule;
import netflix.karyon.servo.KaryonServoModule;

public class MainRunner {



    public static void main(String[] args) {

        Injector injector = Guice.createInjector(new AppInjector());
        PetGuiceManager petGuiceManager = injector.getInstance(PetGuiceManager.class);

        System.setProperty("java.awt.headless","true");
        System.setProperty("archaius.deployment.environment","dev");

        Karyon.forRequestHandler(8080,
                new RxNettyHandler(new Pets30Resource(petGuiceManager)),
                    new ArchaiusBootstrapModule("guice-pet"),
                    Karyon.toBootstrapModule(KaryonWebAdminModule.class),
                    ShutdownModule.asBootstrapModule(),
                    KaryonServoModule.asBootstrapModule()
        ).startAndWaitTillShutdown();

    }
}