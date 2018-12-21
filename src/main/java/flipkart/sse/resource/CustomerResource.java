package flipkart.sse.resource;

import flipkart.sse.controller.CancelledOrderReader;
import flipkart.sse.controller.SellerInfoReader;
import flipkart.sse.model.CancelledOrderInfo;
import flipkart.sse.model.CustomerInfo;
import flipkart.sse.model.CustomerRequest;
import flipkart.sse.model.SellerInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Path("/customer")
@Api(tags = "customer")
@Produces("application/json")
public class CustomerResource {

    public CustomerResource() {
    }

    @GET
    @Path("/fetch")
    @ApiOperation("Get complete customer data for new order")
    @Consumes("application/json")
    public Response getOrder(@QueryParam("customerId")String customerId){

        List<CancelledOrderInfo> orderInfoList = CancelledOrderReader.cancelledOrderInfos.stream()
                .filter(coi -> coi.getAccId().equals(customerId))
                .filter(co -> co.getValidTill() > System.currentTimeMillis())
                .filter(c -> !c.getResultMeta().getWorkFlowStatus().equals(CancelledOrderInfo.Status.ORDER_PLACED))
                .collect(Collectors.toList());

        List<CustomerInfo> customerInfos = orderInfoList.stream()
                .map(this::createCustomerInfo)
                .collect(Collectors.toList());

        return Response.status(Response.Status.OK).entity(customerInfos).build();
    }


    private CustomerInfo createCustomerInfo (CancelledOrderInfo orderInfo){
        List<SellerInfo> sellerInfos = SellerInfoReader.sellerInfos.stream()
                .filter(s -> s.getApprovalState().equals(SellerInfo.SellerOrderStatus.OPTED_IN))
                .filter(si -> si.getOrderId().equals(orderInfo.getOrderId()))
                .filter(sio -> sio.getProductId().equals(orderInfo.getProductId()))
                .collect(Collectors.toList());

        Optional<SellerInfo> optionalSellerInfo = sellerInfos.stream().sorted((s1, s2) -> Integer.valueOf(s2.getBidOrderPrice()).compareTo(Integer.valueOf(s1.getBidOrderPrice()))).findFirst();

        return optionalSellerInfo.map(info -> CustomerInfo.builder()
                .accId(orderInfo.getAccId())
                .orderId(orderInfo.getOrderId())
                .productId(orderInfo.getProductId())
                .productName(orderInfo.getProductName())
                .sellerId(info.getSellerId())
                .proposedPrice(info.getBidOrderPrice())
                .proposedSla(info.getBidSla()).build()).orElse(null);
    }

    @POST
    @Path("/approvalInput")
    @ApiOperation("Post customer input for new order")
    @Consumes("application/json")
    public Response postOrder(@Valid CustomerRequest customerRequest){

        Optional<SellerInfo> first = SellerInfoReader.sellerInfos.stream()
                .filter(s -> s.getApprovalState().equals(SellerInfo.SellerOrderStatus.OPTED_IN))
                .filter(si -> si.getOrderId().equals(customerRequest.getOrderId()))
                .filter(sio -> sio.getProductId().equals(customerRequest.getProductId()))
                .findFirst();

        return Response.status(Response.Status.OK).entity(first).build();
    }
}
