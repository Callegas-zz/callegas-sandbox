package com.callegas;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

public interface TollService {

    @GET
    @Path("/bicycle/{money}")
    Response bicycle(@PathParam("money") Double money);

    @GET
    @Path("/bus/{money}")
    Response bus(@PathParam("money") Double money);

    @GET
    @Path("/car/{money}")
    Response car(@PathParam("money") Double money);

    @GET
    @Path("/motorcycle/{money}")
    Response motorcycle(@PathParam("money") Double money);

    @GET
    @Path("/{totalAxis}/{money}")
    Response truck(@PathParam("totalAxis") Double totalAxis,
                                @PathParam("money") Double money);

}
