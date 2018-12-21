


var orderIterator = 0

$.get("/malgudi/admin/fetch", function(cancelledOrders){
    cancelledOrders = cancelledOrders;

$.each(cancelledOrders, function(){

    $('body').append("<div class='order-item' id="+cancelledOrders[orderIterator].orderId+" ></div>");

    $('#'+cancelledOrders[orderIterator].orderId).append('<img src="'+cancelledOrders[orderIterator].imgUrl+'" height="200"/><div class="order-text"><div class="rhs-container"><div class="optin-eligible-container"><div class="optin-span">Eligible Sellers</div><input class="optin-eligible" type="submit" value="'+cancelledOrders[orderIterator].resultMeta.eligibleSellerCount+'"/></div></div</><div class="optin-response-container"><div class="optin-span">Responses</div><input class="optin-response" type="submit" value="'+cancelledOrders[orderIterator].resultMeta.responseCount+'"/></div><div class="optin-replacement-container"><div class="optin-span">Replacement Found</div><input class="optin-replacement" type="submit" value="'+cancelledOrders[orderIterator].resultMeta.replacementFound+'"/></div><input class="optin-btn" type="submit" value="'+cancelledOrders[orderIterator].resultMeta.workFlowStatus+'"/></div>');


    $('#'+cancelledOrders[orderIterator].orderId).append("<span class='bold'>productName: "+cancelledOrders[orderIterator].productName+"</span>");
        $('#'+cancelledOrders[orderIterator].orderId).append("<br />");

    $('#'+cancelledOrders[orderIterator].orderId).append("<span class='minimize'>orderId: "+cancelledOrders[orderIterator].orderId+"</span>");

    $('#'+cancelledOrders[orderIterator].orderId).append("<br />");

    $('#'+cancelledOrders[orderIterator].orderId).append("<span class='minimize'>listingId: "+cancelledOrders[orderIterator].listingId+"</span>");

    $('#'+cancelledOrders[orderIterator].orderId).append("<br />");

    $('#'+cancelledOrders[orderIterator].orderId).append("<span class='minimize'>productId: "+cancelledOrders[orderIterator].productId+"</span>");

    $('#'+cancelledOrders[orderIterator].orderId).append("<br />");

    $('#'+cancelledOrders[orderIterator].orderId).append("<span class='minimize'>Promised Price: "+cancelledOrders[orderIterator].orderPrice+"</span>");

    $('#'+cancelledOrders[orderIterator].orderId).append("<br />");

    $('#'+cancelledOrders[orderIterator].orderId).append("<span class='minimize'>Promised SLA: "+cancelledOrders[orderIterator].sla+"</span>");

    $('#'+cancelledOrders[orderIterator].orderId).append("<br />");


    $('#'+cancelledOrders[orderIterator].orderId).append("<span class='minimize'>SellerId: "+cancelledOrders[orderIterator].sellerId+"</span>");

    $('#'+cancelledOrders[orderIterator].orderId).append("<br />");


    $('#'+cancelledOrders[orderIterator].orderId).append("<span class='minimize'>LQS: "+cancelledOrders[orderIterator].listingLQS+"</span>");

    $('#'+cancelledOrders[orderIterator].orderId).append("<br />");

    orderIterator++;

});
});



    //$('#'+cancelledOrders[orderIterator].orderId).append('<img src="'+cancelledOrders[orderIterator].imgUrl+'" height="200"/><div class="order-text"><span>"'+cancelledOrders[orderIterator].orderPrice+'"</span><span>"'+cancelledOrders[orderIterator].sla+'"</span><span>"'+cancelledOrders[orderIterator].qty+'"</span><div class="bid-timer">  Days: <span class="days"></span><br>Hours: <span class="hours"></span><br>Minutes: <span class="minutes"></span><br> Seconds: <span class="seconds"></span> </div><div class="optin-btn-container"><input class="optin-btn" type="submit" value="Order OptIn"/></div>');
