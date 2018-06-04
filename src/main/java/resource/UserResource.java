package resource;

import io.dropwizard.hibernate.UnitOfWork;
import model.User;
import model.UserDAO;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;


@Path("/user")
@Produces(MediaType.APPLICATION_JSON)
public class UserResource {

    private final UserDAO userDAO;

    public UserResource(UserDAO userDAO) {
        this.userDAO = userDAO;
    }
//
//    @GET
//    public List<User> viewAll(){
//        return userDAO.findAll();
//    }

    @GET
    @UnitOfWork
    @Path("/{id}")
    public User viewUser(@PathParam("id") Long id){
        if(userDAO.findById(id)!= null){
            return userDAO.findById(id);
        }
        else throw new NullPointerException("Khong tim thay user");
    }

    @POST
    @UnitOfWork
    @Path("/create")
    public User createUser(User user){
        userDAO.createUser(user);
        return user;

    }
}
