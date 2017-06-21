package com.callegasdev.services;

import com.callegasdev.pet.PetRegistration;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class CutHair implements CutHairService{

    private PetRegistration petRegistration;
    private ServiceRegistration serviceRegistration;


    @Inject
    public CutHair(PetRegistration petRegistration, ServiceRegistration serviceRegistration) {
        this.petRegistration = petRegistration;
        this.serviceRegistration = serviceRegistration;
    }

    @Override
    public boolean execute(Integer petId, String cutHairType) {
        try {

            if( petRegistration.searchPet(petId).getName() != "not registered") {
                String service;

                service = "CutHair sent to " + petRegistration.searchPet(petId).getName() + " with: " + cutHairType;

                serviceRegistration.registerService(new ServicesBag(petId, service));
                System.out.println(service);

                return true;
            }else
                return false;
        }
        catch (Exception e) {
            return false;
        }
    }


}
