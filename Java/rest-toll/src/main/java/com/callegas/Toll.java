package com.callegas;

import com.callegas.resources.*;
import javax.inject.Inject;
import javax.ws.rs.core.Response;


public class Toll implements TollService {

    private BicycleResource bicycleResource;
    private BusResource busResource;
    private CarResource carResource;
    private MotorcycleResource motorcycleResource;
    private TruckResource truckResource;

   @Inject
    public Toll(BicycleResource bicycleResource, BusResource busResource,
                CarResource carResource, MotorcycleResource motorcycleResource,
                TruckResource truckResource) {
        this.bicycleResource = bicycleResource;
        this.busResource = busResource;
        this.carResource = carResource;
        this.motorcycleResource = motorcycleResource;
        this.truckResource = truckResource;
    }

    @Override
    public Response bicycle(Double money) {
       return bicycleResource.passTheToll(money);
    }

    @Override
    public Response bus(Double money) {
        return busResource.passTheToll(money);
    }

    @Override
    public Response car(Double money) {
        return carResource.passTheToll(money);
    }

    @Override
    public Response motorcycle(Double money) {
        return motorcycleResource.passTheToll(money);
    }

    @Override
    public Response truck(Double totalAxis, Double money) {
        return truckResource.passTheToll(totalAxis, money);
    }
}
