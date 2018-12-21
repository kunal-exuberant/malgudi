package flipkart.sse.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomerInfo {

    String orderId;

    String productName;

    String accId;

    String productId;

    String sellerId;

    String proposedSla;

    String proposedPrice;
}
