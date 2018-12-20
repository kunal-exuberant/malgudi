import io.dropwizard.Application;
import io.dropwizard.assets.AssetsBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.eclipse.jetty.servlets.CrossOriginFilter;

import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration;
import java.util.EnumSet;

/**
 * Created by kunalsingh.k on 07/01/17.
 */
public class MalgudiService extends Application<MalgudiConfiguration> {


    public static void main(String [] args) throws Exception{
        System.out.println("Hello World "+args.toString());
        new MalgudiService().run(args);
    }

    @Override
    public void initialize(Bootstrap<MalgudiConfiguration> bootstrap) {
        bootstrap.addBundle(new AssetsBundle("/assets/","/","/index.html"));
    }

    @Override
    public void run(MalgudiConfiguration malgudiConfiguration, Environment environment) throws Exception {

        final FilterRegistration.Dynamic cors =
                environment.servlets().addFilter("CORS", CrossOriginFilter.class);

        cors.setInitParameter("allowedOrigins", "*");
        cors.setInitParameter("allowedHeaders", "*");
        cors.setInitParameter("allowedMethods", "OPTIONS,GET,PUT,POST,DELETE,HEAD");
        cors.addMappingForUrlPatterns(EnumSet.allOf(DispatcherType.class), true, "/*");

        environment.jersey().setUrlPattern("/api/*");
        environment.jersey().register(MalgudiService.class);
        //final FulfillmentResource fulfillmentResource = new FulfillmentResource(malgudiConfiguration.getTemplate(), malgudiConfiguration.getDefaultName());
        //final IssueUnderstandingAndClassification issueUnderstandingAndClassification = new IssueUnderstandingAndClassification(malgudiConfiguration.getTemplate(), malgudiConfiguration.getDefaultName());
        environment.jersey().register(IssueUnderstandingAndClassification.class);
    }
}
