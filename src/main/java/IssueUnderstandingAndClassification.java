
import com.codahale.metrics.annotation.Timed;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.awt.*;



@Path("/malgudi/intent")
@Produces(MediaType.APPLICATION_JSON)

public class IssueUnderstandingAndClassification {
    private String template;
    private String defaultName;

    public IssueUnderstandingAndClassification() {
    }

//    @Inject
    public IssueUnderstandingAndClassification(String template, String defaultName){
        this.defaultName = defaultName;
        this.template = template;
    }

    @GET
    @Timed
    public String sayHello(){
        return "hello "+defaultName;
    }

    @GET
    @Path("/hi")
    public String SayHi(){
        return "hi"+defaultName;
    }
}
