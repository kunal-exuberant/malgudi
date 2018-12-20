package flipkart.sse.module;

import com.google.inject.AbstractModule;
import flipkart.sse.resource.AdminResource;

public class MalgudiModule extends AbstractModule {

    protected void configure() {
        bind(AdminResource.class).asEagerSingleton();
    }
}
