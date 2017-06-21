package com.callegas.resources;

import com.sun.jersey.spi.resource.Singleton;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

@Singleton
@Path("/bus/{money}")
public class BusResource{

    @GET
    public Response passTheToll(@PathParam("money") Double money){

        try {
            String output;
            Double price = 1.59;

            if(money < price) {
                output = "Insufficient money";
            }else {
                Double change = money - price;
                output = "Bus U$"+price+", Your change is U$"+change;
            }

            return Response.status(200).entity(output).build();

        }catch (Exception e) {
            return Response.status(400).build();
        }
    }

}