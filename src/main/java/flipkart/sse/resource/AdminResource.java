package flipkart.sse.resource;

import com.google.common.collect.Lists;
import flipkart.sse.controller.CancelledOrderReader;
import flipkart.sse.model.CancelledOrderInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/admin")
@Api(tags = "admin")

public class AdminResource {

    public AdminResource() {
    }

    @GET
    @Path("/fetch")
    @ApiOperation("Gets all cancelled order ")
    @Consumes("application/json")
    public Response getCancelledOrder(){
        List<CancelledOrderInfo> list = Lists.newArrayList();
        return Response.status(Response.Status.OK).entity(CancelledOrderReader.cancelledOrderInfos).build();
    }
}
