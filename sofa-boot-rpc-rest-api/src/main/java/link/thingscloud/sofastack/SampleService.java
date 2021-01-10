package link.thingscloud.sofastack;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 * @author zhouhailin
 * @version 1.0.0
 */
@Path("sample")
public interface SampleService {

    @GET
    @Path("hello")
    String hello();

    String hello2();

}
