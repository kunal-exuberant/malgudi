package flipkart.sse.resource;

import flipkart.sse.controller.CancelledOrderReader;
import flipkart.sse.controller.SellerInfoReader;
import flipkart.sse.model.CancelledOrderInfo;
import flipkart.sse.model.SellerInfo;
import flipkart.sse.model.SellerRequest;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
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
        AtomicReference<Boolean> matchfound = new AtomicReference<>(false);

        CancelledOrderReader.cancelledOrderInfos.forEach( cancelledOrderInfo -> {
            if(cancelledOrderInfo.getSellerId().equals(sellerRequest.getSellerId()) &&
                    cancelledOrderInfo.getProductId().equals(sellerRequest.getProductId()) &&
                    cancelledOrderInfo.getOrderId().equals(sellerRequest.getOrderId())){
                cancelledOrderInfo.getResultMeta().setResponseCount(cancelledOrderInfo.getResultMeta().getResponseCount() + 1);

                if(Integer.valueOf(cancelledOrderInfo.getListingLQS()) <= Integer.valueOf(sellerRequest.getListingLqs())){
                    cancelledOrderInfo.getResultMeta().setReplacementFound(true);
                    cancelledOrderInfo.getResultMeta().setSellerAssigned(sellerRequest.getSellerId());
                    cancelledOrderInfo.getResultMeta().setWorkFlowStatus(CancelledOrderInfo.Status.ORDER_PLACED);
                    matchfound.set(true);
                }
            }
        });

        SellerInfoReader.sellerInfos.forEach( sellerInfo -> {
            if(sellerInfo.getSellerId().equals(sellerRequest.getSellerId()) &&
                    sellerInfo.getProductId().equals(sellerRequest.getProductId()) &&
                    sellerInfo.getOrderId().equals(sellerRequest.getOrderId())){

                if (matchfound.get())
                    sellerInfo.setApprovalState(SellerInfo.SellerOrderStatus.ORDER_PLACED);
                else
                    sellerInfo.setApprovalState(SellerInfo.SellerOrderStatus.OPTED_IN);
            }
        });



        return Response.status(Response.Status.OK).build();
    }
}
