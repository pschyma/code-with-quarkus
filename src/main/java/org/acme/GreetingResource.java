package org.acme;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/hello-resteasy")
public class GreetingResource {

  @GET
  @Path("{count: \\d+}")
  @Produces(MediaType.TEXT_PLAIN)
  public String hello(@PathParam("count") int count) {

    return "Hello RESTEasy\n".repeat(count);
  }
}
