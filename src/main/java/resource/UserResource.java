package resource;

import model.User;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/user")
@Produces(MediaType.APPLICATION_JSON)
public class UserResource {
    @GET
    public Response userResponse(){
        User user = new User();
        user.setId((long) 1);
        user.setBirthYear((long) 1990);
        user.setName("John Smith");
        user.setJob("developer");
        user.setSex("male");
        return Response.ok(user).build();
    }
}
