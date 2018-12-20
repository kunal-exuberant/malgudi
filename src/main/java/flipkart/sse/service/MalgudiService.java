package flipkart.sse.service;

import flipkart.sse.config.MalgudiConfiguration;
import flipkart.sse.module.MalgudiModule;
import flipkart.sse.resource.AdminResource;
import io.dropwizard.Application;
import io.dropwizard.Configuration;
import io.dropwizard.assets.AssetsBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import io.federecio.dropwizard.swagger.SwaggerBundle;
import io.federecio.dropwizard.swagger.SwaggerBundleConfiguration;
import org.eclipse.jetty.servlets.CrossOriginFilter;
import ru.vyarus.dropwizard.guice.GuiceBundle;

import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration;
import java.util.EnumSet;

/**
 * Created by kunalsingh.k on 07/01/17.
 */
public class MalgudiService extends Application<MalgudiConfiguration> {

    private static String APP_NAME = "malgudi";

    private static String RESOURCE_PATH = "flipkart.sse.resource";

    @Override
    public String getName() {
        return APP_NAME;
    }


    public static void main(String [] args) throws Exception{
        new MalgudiService().run(args);
    }

    @Override
    public void initialize(Bootstrap<MalgudiConfiguration> bootstrap) {

        bootstrap.addBundle(new AssetsBundle("/assets/","/","/index.html"));

        bootstrap.addBundle(GuiceBundle.builder()
                .enableAutoConfig(RESOURCE_PATH)
                .modules(new MalgudiModule())
                .build());

//        bootstrap.addBundle(new SwaggerBundle() {
//            @Override
//            protected SwaggerBundleConfiguration getSwaggerBundleConfiguration(
//                    Configuration configuration) {
//                SwaggerBundleConfiguration bundleConfiguration = new SwaggerBundleConfiguration();
//                bundleConfiguration.setResourcePackage(RESOURCE_PATH);
//                return bundleConfiguration;
//            }
//        });
    }

    @Override
    public void run(MalgudiConfiguration malgudiConfiguration, Environment environment) throws Exception {

        final FilterRegistration.Dynamic cors =
                environment.servlets().addFilter("CORS", CrossOriginFilter.class);

        cors.setInitParameter("allowedOrigins", "*");
        cors.setInitParameter("allowedHeaders", "*");
        cors.setInitParameter("allowedMethods", "OPTIONS,GET,PUT,POST,DELETE,HEAD");
        cors.addMappingForUrlPatterns(EnumSet.allOf(DispatcherType.class), true, "/*");

        environment.jersey().setUrlPattern("/malgudi/*");
        environment.jersey().register(MalgudiService.class);


        environment.jersey().register(AdminResource.class);

    }
}
