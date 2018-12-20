package flipkart.sse.config;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;
import io.dropwizard.db.DataSourceFactory;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * Created by kunalsingh.k on 07/01/17.
 */
public class MalgudiConfiguration extends Configuration {

    @NotEmpty
    private String template ="OK";

    @NotEmpty
    private String defaultName ="OK";

    @JsonProperty
    public void setTemplate(String template){
        this.template = template;
    }

    @JsonProperty
    public void setDefaultName(String defaultName){
        this.defaultName = defaultName;
    }

    @JsonProperty
    public String getTemplate(){
        return template;
    }

    @JsonProperty
    public String getDefaultName(){
        return defaultName;
    }

//    @NotNull
//    private DataSourceFactory dataSourceFactory = new DataSourceFactory();
//
//    @Valid
//    @NotNull
//    @JsonProperty("database")
//    public DataSourceFactory getDataSourceFactory() {
//        return dataSourceFactory;
//    }
//
//    public void setDataSourceFactory(DataSourceFactory dataSourceFactory) {
//        this.dataSourceFactory = dataSourceFactory;
//    }
}
