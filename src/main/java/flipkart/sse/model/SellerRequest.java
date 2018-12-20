package flipkart.sse.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SellerRequest {

    String sellerId;

    String orderId;

    String listingId;

    String listingLqs;

}
