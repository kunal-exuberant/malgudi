package flipkart.sse.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CancelledOderInfo {
    String orderId;

    String accId;

    String listingId;

    String orderPrice;

    String sellerId;

    Integer listingLQS;

    Integer sla;

    Integer quantity;

    String newSellerAssigned;

    String newOrderId;

}
