package flipkart.sse.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class CustomerRequest {

    String accId;

    String orderId;

    String productId;

    String Status;

    public static enum Status{
        APPROVE,
        REJECT
    }
}
