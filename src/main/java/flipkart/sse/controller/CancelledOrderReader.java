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
                    .orderId(cancelledOderdetail[0])
                    .accId(cancelledOderdetail[1])
                    .listingId(cancelledOderdetail[2])
                    .productId(cancelledOderdetail[3])
                    .imgUrl(cancelledOderdetail[4])
                    .orderPrice(cancelledOderdetail[5])
                    .sellerId(cancelledOderdetail[6])

                    .listingLQS(cancelledOderdetail[7])
                    .sla(cancelledOderdetail[8])
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
