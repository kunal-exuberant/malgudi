package flipkart.sse.resource;

import com.google.common.collect.Lists;
import flipkart.sse.controller.SellerInfoReader;
import flipkart.sse.model.SellerInfo;
import flipkart.sse.model.SellerRequest;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.stream.Collectors;

@Path("/seller")
@Api(tags = "seller")
@Produces("application/json")
public class SellerResource {

    public SellerResource() {
    }

    @GET
    @Path("/fetch")
    @ApiOperation("Gets seller related approval")
    @Consumes("application/json")
    public Response getCancelledOrder(@QueryParam("sellerId")String sellerId){
        List<SellerInfo> list = SellerInfoReader.sellerInfos;
        List<SellerInfo> filteredSeller = list.stream().filter(sellerInfo -> sellerInfo.getSellerId().equals(sellerId)).collect(Collectors.toList());
        return Response.status(Response.Status.OK).entity(filteredSeller).build();
    }

    @GET
    @Path("/fetchAll")
    @ApiOperation("Fetch all seller related order")
    @Consumes("application/json")
    public Response getCancelledOrder(){
        List<SellerInfo> list = SellerInfoReader.sellerInfos;
        return Response.status(Response.Status.OK).entity(list).build();
    }


    @POST
    @Path("/approvalInput")
    @ApiOperation("Give seller approval input")
    @Consumes("application/json")
    public Response postSellerInput(@Valid SellerRequest sellerRequest){
        return Response.status(Response.Status.OK).build();
    }
}
