package flipkart.sse.controller;

import com.google.common.collect.Lists;
import com.opencsv.CSVReader;
import flipkart.sse.model.SellerInfo;

import java.io.FileReader;
import java.util.List;

public class SellerInfoReader {

    static public List<SellerInfo> sellerInfos;

    static {
        SellerInfoReader reader = new SellerInfoReader();
        sellerInfos = reader.read("seller.csv");
    }

    public List<SellerInfo> read(String fileName)
    {
        List<SellerInfo> infos = Lists.newArrayList();
        CSVReader csvReader = null;
        try
        {
            csvReader = new CSVReader(new FileReader(fileName),',');
            String[] sellerDetail = null;

            while((sellerDetail = csvReader.readNext())!=null)
            {
                SellerInfo emp = SellerInfo.builder()
                        .productId(sellerDetail[0])
                        .listingId(sellerDetail[1])
                        .orderId(sellerDetail[2])
                        .price(sellerDetail[3])
                        .sla(sellerDetail[4])
                        .imgURL(sellerDetail[5])
                        .validTill(Long.valueOf(sellerDetail[6]))
                        .sellerId(sellerDetail[8])
                        .build();
                infos.add(emp);
            }

            infos.forEach(s -> System.out.println(s.toString()));
        }
        catch(Exception ee)
        {
            ee.printStackTrace();
        }
        return infos;
    }

    public static void main(String[] args) {
        System.out.println("Seller Data boot strapped");
    }
}
