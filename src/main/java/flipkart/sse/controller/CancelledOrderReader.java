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
                CancelledOrderInfo emp = new CancelledOrderInfo(cancelledOderdetail[0],
                        cancelledOderdetail[1],
                        cancelledOderdetail[2],
                        cancelledOderdetail[3],
                        cancelledOderdetail[4],
                        Integer.parseInt(cancelledOderdetail[5]),
                        Integer.parseInt(cancelledOderdetail[6]),
                        cancelledOderdetail[8],
                        cancelledOderdetail[3]);
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
        System.out.println();
    }


}
