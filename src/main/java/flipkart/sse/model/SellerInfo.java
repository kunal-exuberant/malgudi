package flipkart.sse.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SellerInfo {

    String productName;

    String productId;

    String listingId;

    String orderId;

    String orderPrice;

    String sla;

    String imgURL;

    long validTill;

    String listingLQS;

    SellerOrderStatus approvalState;

    String sellerId;


    public enum SellerOrderStatus{
        NOT_OPTED_IN,
        OPTED_IN,
        ORDER_PLACED
    }
}
