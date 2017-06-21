package com.callegasdev.services;

import com.callegasdev.pet.PetRegistration;
import javax.inject.Inject;
import javax.inject.Singleton;


@Singleton
public class Bath implements BathService {

    private PetRegistration petRegistration;
    private ServiceRegistration serviceRegistration;

    @Inject
    public Bath(PetRegistration petRegistration, ServiceRegistration serviceRegistration) {
        this.petRegistration = petRegistration;
        this.serviceRegistration = serviceRegistration;
    }

    public boolean execute(Integer petId, String bathType, boolean perfume) {
        try {
            if( petRegistration.searchPet(petId).getName() != "not registered") {

                String service;
                if (perfume)
                    bathType += " with perfume";
                service = "Bath sent to " + petRegistration.searchPet(petId).getName() + " with: " + bathType;

                serviceRegistration.registerService(new ServicesBag(petId, service));
                System.out.println(service);

                return true;
            }else
                return false;

        }catch (Exception e) {
            return false;
        }
    }


}
