package flipkart.sse.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CancelledOrderInfo {
    String orderId;

    String accId;

    String listingId;

    String productId;

    String imgUrl;

    String orderPrice;

    String sellerId;

    String listingLQS;

    String sla;



    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public class ResultMeta{

        Integer eligibleSellerCount;

        Integer responseCount;

        Boolean replacementFound;

        String sellerAssigned;

        String newOrderId;

        Status workFlowStatus;

    }

    public enum Status {
        ORDER_PLACED,
        ZERO_SELLER,
        SELLER_SELECTED,
        LQS_NOT_MET
    }

}
