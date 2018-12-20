package flipkart.sse.controller;

import com.google.common.collect.Lists;
import com.opencsv.CSVReader;
import flipkart.sse.model.CancelledOrderInfo;
import lombok.Getter;

import java.io.FileReader;
import java.util.List;

@Getter
public class CancelledOrderReader {

    static public List<CancelledOrderInfo> cancelledOrderInfos;

    static {
        CancelledOrderReader reader = new CancelledOrderReader();
        cancelledOrderInfos = reader.read("order.csv");
    }

    public List<CancelledOrderInfo> read(String fileName)
    {
        List<CancelledOrderInfo> orderInfos = Lists.newArrayList();
        CSVReader csvReader = null;
        try
        {
            csvReader = new CSVReader(new FileReader(fileName),',');
            String[] cancelledOderdetail = null;

            while((cancelledOderdetail = csvReader.readNext())!=null)
            {
                CancelledOrderInfo emp = CancelledOrderInfo.builder()
                        .productName(cancelledOderdetail[0])
                    .orderId(cancelledOderdetail[1])
                    .accId(cancelledOderdetail[2])
                    .listingId(cancelledOderdetail[3])
                    .productId(cancelledOderdetail[4])
                    .imgUrl(cancelledOderdetail[5])
                    .orderPrice(cancelledOderdetail[6])
                    .sellerId(cancelledOderdetail[7])

                    .listingLQS(cancelledOderdetail[8])
                    .sla(cancelledOderdetail[9])
                        .resultMeta(new CancelledOrderInfo.ResultMeta(cancelledOderdetail[10], cancelledOderdetail[11], Boolean.valueOf(cancelledOderdetail[12]),
                                cancelledOderdetail[13], cancelledOderdetail[14], CancelledOrderInfo.Status.valueOf(cancelledOderdetail[15])))
                    .validTill(System.currentTimeMillis() + (SellerInfoReader.ONE_HOUR * Integer.valueOf(cancelledOderdetail[16])))
                        .build();
                orderInfos.add(emp);
            }

            orderInfos.forEach(s -> System.out.println(s.toString()));
        }
        catch(Exception ee)
        {
            ee.printStackTrace();
        }
        return orderInfos;
    }

    public static void main(String[] args) {
        System.out.println("Seller Data boot strapped");
    }


}
