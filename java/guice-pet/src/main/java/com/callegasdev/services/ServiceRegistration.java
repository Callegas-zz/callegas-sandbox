package com.callegasdev.services;

import javax.inject.Singleton;
import java.util.*;


@Singleton
public class ServiceRegistration {

    private List<ServicesBag> serviceList = new ArrayList<>();
    private final Map<Integer, Integer> counter = new HashMap<>();

    public ServicesBag registerService(ServicesBag servicesBag) {
        serviceList.add(servicesBag);
        return servicesBag;
    }

    public boolean top10PetsRevenue(){
        try {
            List<Integer> serviceListByPetId = new ArrayList<>();
            for (ServicesBag s : serviceList) {
                serviceListByPetId.add(s.getId());
            }

            System.out.println("## TOP 10 PETS REVENUE ##");
            int limit = 0;
            for (Integer pet : organizeByMostAppear(serviceListByPetId)) {
                if (limit < 10) {
                    int frequency = counter.get(pet);
                    System.out.println("Pet id:" + pet + " total services:" + frequency);
                }
                limit++;
            }
        } catch (Exception e){
            return false;
        }
        return true;
    }

    private List<Integer> organizeByMostAppear(List<Integer> list){

        for (Integer petId : list)
            counter.put(petId, 1 + (counter.containsKey(petId) ? counter.get(petId) : 0));

        List<Integer> sortedByQuantityServices = new ArrayList<>(counter.keySet());
        Collections.sort(sortedByQuantityServices, (x, y) -> counter.get(y) - counter.get(x));
        return sortedByQuantityServices;

    }

}
