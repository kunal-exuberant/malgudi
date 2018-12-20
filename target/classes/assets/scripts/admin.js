

//alert("whatsup");

console.log("check point 1");

var orderIterator = 0

$.get("/malgudi/admin/fetch", function(cancelledOrders){
    cancelledOrders = cancelledOrders;

$.each(cancelledOrders, function(){

    console.log(cancelledOrders);

    $('body').append("<div class='order-item' id="+cancelledOrders[orderIterator].orderId+" ></div>");

    $('#'+cancelledOrders[orderIterator].orderId).append('<img src="'+cancelledOrders[orderIterator].imgUrl+'" height="200"/><div class="order-text"><div class="rhs-container"><div class="optin-eligible-container"><div class="optin-span">Eligible Sellers</div><input class="optin-eligible" type="submit" value="'+cancelledOrders[orderIterator].resultMeta.eligibleSellerCount+'"/></div></div</><div class="optin-response-container"><div class="optin-span">Responses</div><input class="optin-response" type="submit" value="'+cancelledOrders[orderIterator].resultMeta.responseCount+'"/></div><div class="optin-replacement-container"><div class="optin-span">Replacement Found</div><input class="optin-replacement" type="submit" value="'+cancelledOrders[orderIterator].resultMeta.replacementFound+'"/></div><input class="optin-btn" type="submit" value="'+cancelledOrders[orderIterator].resultMeta.workFlowStatus+'"/></div>');


    $('#'+cancelledOrders[orderIterator].orderId).append("<span class='bold'>"+cancelledOrders[orderIterator].productName+"</span>");
        $('#'+cancelledOrders[orderIterator].orderId).append("<br />");

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