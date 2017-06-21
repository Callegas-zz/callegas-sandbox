package com.callegasdev.consumer;
import com.callegasdev.pet.Pet;
import com.callegasdev.pet.PetRegistration;
import com.callegasdev.services.*;
import com.google.inject.Inject;
import com.google.inject.Singleton;

import java.util.List;

public class PetGuiceManager {

    private BathService bathService;
    private CutHairService cutHairService;
    private PetRegistration petRegistration;
    private ServiceRegistration serviceRegistration;

    @Inject
    public PetGuiceManager(BathService bathService, CutHairService cutHairService, PetRegistration petRegistration, ServiceRegistration serviceRegistration) {
        this.bathService = bathService;
        this.cutHairService = cutHairService;
        this.petRegistration = petRegistration;
        this.serviceRegistration = serviceRegistration;
    }

    public boolean executeBath(Integer petId, String bathType, boolean perfume) {
        return bathService.execute(petId, bathType, perfume);
    }

    public boolean executeCutHair(Integer petId, String cutHairType) {
        return cutHairService.execute(petId, cutHairType);
    }

    public Pet registerPet(Pet pet) {
        return petRegistration.registerPet(pet);
    }

    public List<Pet> searchByAge(Integer age) {
        return petRegistration.searchByAge(age);
    }

    public boolean top10PetsRevenue(){
        return serviceRegistration.top10PetsRevenue();
    }

    public ServicesBag registerService(ServicesBag servicesBag){
        return serviceRegistration.registerService(servicesBag);
    }

}
