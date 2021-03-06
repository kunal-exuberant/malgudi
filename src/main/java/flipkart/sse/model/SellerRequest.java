package flipkart.sse.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SellerRequest {

    String sellerId;

    String orderId;

    String productId;

    String listingLQS;

    String bidOrderPrice;

    String bidSla;

}
