package flipkart.sse.resource;

import flipkart.sse.controller.CancelledOrderReader;
import flipkart.sse.controller.SellerInfoReader;
import flipkart.sse.model.CancelledOrderInfo;
import flipkart.sse.model.SellerInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import java.util.Optional;
import java.util.stream.Collectors;

@Path("/admin")
@Api(tags = "admin")
@Produces("application/json")
public class AdminResource {

    public AdminResource() {
    }

    @GET
    @Path("/fetch")
    @ApiOperation("Gets all cancelled order ")
    @Consumes("application/json")
    public Response getCancelledOrder(){
        CancelledOrderReader.cancelledOrderInfos.forEach(cancelledOrderInfo -> {
            if (cancelledOrderInfo.getValidTill() < System.currentTimeMillis()){
                cancelledOrderInfo.getResultMeta().setWorkFlowStatus(CancelledOrderInfo.Status.NO_SELLER_PARTICIPATED);
            }

            if(cancelledOrderInfo.getValidTill() < System.currentTimeMillis() &&
                ! cancelledOrderInfo.getResultMeta().getReplacementFound()){
                Optional<SellerInfo> optionalSellerInfo = SellerInfoReader.sellerInfos.stream()
                        .filter(sellerInfo -> SellerInfo.SellerOrderStatus.OPTED_IN == sellerInfo.getApprovalState()
                        && sellerInfo.getProductId().equals(cancelledOrderInfo.getProductId())
                        && sellerInfo.getOrderId().equals(cancelledOrderInfo.getOrderId())).sorted((s1, s2) ->
                        (Integer.valueOf(s2.getListingLQS()).compareTo(Integer.valueOf(s1.getListingLQS())))).findFirst();

                optionalSellerInfo.ifPresent( i -> {
                    cancelledOrderInfo.getResultMeta().setReplacementFound(true);
                    cancelledOrderInfo.getResultMeta().setSellerAssigned(i.getSellerId());
                    cancelledOrderInfo.getResultMeta().setWorkFlowStatus(CancelledOrderInfo.Status.ORDER_PLACED);
                });
            }
        });


        return Response.status(Response.Status.OK).entity(CancelledOrderReader.cancelledOrderInfos).build();
    }
}
