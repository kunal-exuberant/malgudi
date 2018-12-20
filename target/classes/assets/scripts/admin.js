

//alert("whatsup");

console.log("check point 1");

var cancelledOrders =
[{

    orderId: "0000056234239",
    acctId: "ACC223489237489234234",
    listingId: "LST23984723894723894",
    productId: "MOB29834623894789324",
    orderPrice: 5000,
    sla: 5,
    sellerId: "SL234234234234234",
    listingLQS: 1999,
    qty: 10,
    imgUrl : "https://rukminim1.flixcart.com/image/880/1056/jggv53k0/backpack/m/k/z/amt-fizz-sch-bag-02-black-ff9-0-09-002-backpack-american-original-imaf4ghyfkaucydj.jpeg?q=50",
    newOrderStatus : "SELLER_SELECTED"
},
{
    orderId: "000002346234239",
    acctId: "ACC223423432423423423",
    listingId: "LST239847258756",
    productId: "MOB29834625345",
    orderPrice: 9406,
    sla: 6,
    sellerId: "SL234234768",
    listingLQS: 39993,
    qty: 12,
    imgUrl : "https://rukminim1.flixcart.com/image/880/1056/jggv53k0/backpack/m/k/z/amt-fizz-sch-bag-02-black-ff9-0-09-002-backpack-american-original-imaf4ghyfkaucydj.jpeg?q=50",
    newOrderStatus : "ORDER_PLACED"
},
{
    orderId: "000785646234239",
    acctId: "ACC2234567567993423",
    listingId: "LST2358568566",
    productId: "MOB258568568987654",
    orderPrice: 940634,
    sla: 9,
    sellerId: "SL234234768",
    listingLQS: 59992,
    qty: 23,
    imgUrl : "https://rukminim1.flixcart.com/image/880/1056/jggv53k0/backpack/m/k/z/amt-fizz-sch-bag-02-black-ff9-0-09-002-backpack-american-original-imaf4ghyfkaucydj.jpeg?q=50",
    newOrderStatus : "ZERO_PARTICIPATION"
}
];

console.log(cancelledOrders);


var orderIterator = 0

$.get("/malgudi/admin/fetch", function(cancelledOrders){
    cancelledOrders = cancelledOrders;

$.each(cancelledOrders, function(){

    console.log(cancelledOrders);

    $('body').append("<div class='order-item' id="+cancelledOrders[orderIterator].orderId+" ></div>");

    $('#'+cancelledOrders[orderIterator].orderId).append('<img src="'+cancelledOrders[orderIterator].imgUrl+'" height="200"/><div class="order-text"><div class="rhs-container"><div class="optin-eligible-container"><div class="optin-span">Eligible Sellers</div><input class="optin-eligible" type="submit" value="20"/></div></div</><div class="optin-response-container"><div class="optin-span">Responses</div><input class="optin-response" type="submit" value="20"/></div><div class="optin-replacement-container"><div class="optin-span">Replacement Found</div><input class="optin-replacement" type="submit" value="No"/></div><input class="optin-btn" type="submit" value="'+cancelledOrders[orderIterator].newOrderStatus+'"/></div>');



    //$('body').append(cancelledOrders[orderIterator].imgUrl);

    $('#'+cancelledOrders[orderIterator].orderId).append(cancelledOrders[orderIterator].orderId);

    $('#'+cancelledOrders[orderIterator].orderId).append("<br />");

    $('#'+cancelledOrders[orderIterator].orderId).append(cancelledOrders[orderIterator].listingId);

    $('#'+cancelledOrders[orderIterator].orderId).append("<br />");

    $('#'+cancelledOrders[orderIterator].orderId).append(cancelledOrders[orderIterator].productId);

    $('#'+cancelledOrders[orderIterator].orderId).append("<br />");

    $('#'+cancelledOrders[orderIterator].orderId).append("Promised Price: "+cancelledOrders[orderIterator].orderPrice);

    $('#'+cancelledOrders[orderIterator].orderId).append("<br />");

    $('#'+cancelledOrders[orderIterator].orderId).append("Promised SLA: "+cancelledOrders[orderIterator].sla);

    $('#'+cancelledOrders[orderIterator].orderId).append("<br />");


    $('#'+cancelledOrders[orderIterator].orderId).append(cancelledOrders[orderIterator].sellerId);

    $('#'+cancelledOrders[orderIterator].orderId).append("<br />");


    $('#'+cancelledOrders[orderIterator].orderId).append(cancelledOrders[orderIterator].listingLQS);

    $('#'+cancelledOrders[orderIterator].orderId).append("<br />");


    $('#'+cancelledOrders[orderIterator].orderId).append(cancelledOrders[orderIterator].qty);

    $('#'+cancelledOrders[orderIterator].orderId).append("<br />");

            //$('#'+cancelledOrders[orderIterator].orderId).append("<hr />");

    orderIterator++;

});

});
//alert(cancelledOrders);

console.log("check point 2");