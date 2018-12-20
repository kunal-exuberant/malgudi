package flipkart.sse.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SellerInfo {

    String productID;

    String listingID;

    String price;

    String sla;

    long timeRemaining;

    Boolean approvalState;
}
