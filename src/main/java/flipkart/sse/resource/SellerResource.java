package flipkart.sse.resource;

import com.google.common.collect.Lists;
import flipkart.sse.model.SellerInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/seller")
@Api(tags = "seller")

public class SellerResource {

    public SellerResource() {
    }

    @GET
    @Path("/fetch")
    @ApiOperation("Gets all cancelled order ")
    @Consumes("application/json")
    public Response getCancelledOrder(String sellerId){
        List<SellerInfo> list = Lists.newArrayList();
        return Response.status(Response.Status.OK).entity(list).build();
    }
}
