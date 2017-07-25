package com.callegasdev.services;

public class ServicesBag {

    private Integer petId;
    private String service;

    @Override
    public String toString() {
        return "petId: " + petId + " service: " + service;
    }

    public ServicesBag(Integer id, String service) {
        this.petId = id;
        this.service = service;
    }

    public Integer getId() {
        return petId;
    }

    public void setId(Integer id) {
        this.petId = id;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }
}
