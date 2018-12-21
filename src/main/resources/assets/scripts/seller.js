


var orderIterator = 0
var sellerId = "S1";

$.get("/malgudi/seller/fetch?sellerId=S1",{sellerId:sellerId}, function(cancelledOrders){

console.log(cancelledOrders);
$.each(cancelledOrders, function(){

    $('body').append("<div class='order-item' id="+cancelledOrders[orderIterator].orderId+" ></div>");

    $('#'+cancelledOrders[orderIterator].orderId).append('<img src="'+cancelledOrders[orderIterator].imgURL+'" height="200"/>');

    if(cancelledOrders[orderIterator].approvalState == null || cancelledOrders[orderIterator].approvalState == "NOT_OPTED_IN"){
        $('#'+cancelledOrders[orderIterator].orderId).append("<div class='order-text'><div class='rhs-container'><div class='optin-btn-container'><input data='"+cancelledOrders[orderIterator].orderId+"' class='bidding-price' type='text' placeholder='Bidding Price' value=''/><input data='"+cancelledOrders[orderIterator].orderId+"' class='bidding-sla' type='text' placeholder='Bidding SLA' value=''/><input data='"+cancelledOrders[orderIterator].orderId+"' productId='"+cancelledOrders[orderIterator].productId+"' listingLQS='"+cancelledOrders[orderIterator].listingLQS+"'  productId='"+cancelledOrders[orderIterator].orderId+"' class='optin-btn' type='submit' value='Order OptIn'/></div></div></div>");
    }

     if(cancelledOrders[orderIterator].approvalState == "OPTED_IN"){
            $('#'+cancelledOrders[orderIterator].orderId).append("<div class='order-text'><div class='rhs-container'><div class='optin-btn-container'>Bid Price: '"+cancelledOrders[orderIterator].bidOrderPrice+"'<input data='"+cancelledOrders[orderIterator].orderId+"' productId='"+cancelledOrders[orderIterator].productId+"' listingLQS='"+cancelledOrders[orderIterator].listingLQS+"' productId='"+cancelledOrders[orderIterator].orderId+"' class='optin-btn' type='submit' value='Opted In'/></div></div></div>");
     }

    if(cancelledOrders[orderIterator].approvalState == "ORDER_PLACED"){
            $('#'+cancelledOrders[orderIterator].orderId).append("<div class='order-text'><div class='rhs-container'><div class='optin-btn-container'>Bid SLA: '"+cancelledOrders[orderIterator].bidSla+"'<input data='"+cancelledOrders[orderIterator].orderId+"' productId='"+cancelledOrders[orderIterator].productId+"' listingLQS='"+cancelledOrders[orderIterator].listingLQS+"' productId='"+cancelledOrders[orderIterator].orderId+"' class='optin-btn' type='submit' value='Order Placed'/></div></div></div>");
     }

    $('#'+cancelledOrders[orderIterator].orderId).append("<span class='bold'>"+cancelledOrders[orderIterator].productName+"</span>");
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

$(".optin-btn").on("click",function(){
console.log("clicking optin btn");
    var orderId = $(this).attr("data");
    var productId = $(this).attr("productId");
    var listingLQS = $(this).attr("listingLQS");
    var me = $(this);
    var biddingPrice = me.parent().children().eq(0).val();
    var biddingSLA = me.parent().children().eq(1).val();

    if(biddingPrice > 0 && biddingSLA > 0 ){

        me.attr("value","OPTED_IN");


       var sellerRequest = {

            "orderId": orderId,
            "sellerId": sellerId,
            "productId": productId,
            "listingLQS": listingLQS,
            "bidOrderPrice" : biddingPrice,
            "bidSla": biddingSLA
       };


       var sellerRequest = JSON.stringify(sellerRequest);

        $.ajax({
            type: "POST",
            url: "/malgudi/seller/approvalInput",
            dataType: 'json',
            contentType:"application/json",
            data: sellerRequest,
            cache: false,
            success: function(data){
                me.attr("value","OPTED_IN");
            }
        });
    }
    else{
        alert("Please enter a value for bidding price and bidding SLA");
    }
});

});


function getTimeRemaining(endtime){
  var t = Date.parse(endtime) - Date.parse(new Date());
  var seconds = Math.floor( (t/1000) % 60 );
  var minutes = Math.floor( (t/1000/60) % 60 );
  var hours = Math.floor( (t/(1000*60*60)) % 24 );
  var days = Math.floor( t/(1000*60*60*24) );
  return {
    'total': t,
    'days': days,
    'hours': hours,
    'minutes': minutes,
    'seconds': seconds
  };
}

var deadline = 'December 31 2020 23:59:59 GMT+0200';


function initializeClock(id, endtime){
  var clock = document.getElementById(id);
  var timeinterval = setInterval(updateClock,1000);
};

initializeClock('bid-timer', deadline);

function updateClock(){
  var t = getTimeRemaining(endtime);
  clock.innerHTML = 'days: ' + t.days + '<br>' +
                    'hours: '+ t.hours + '<br>' +
                    'minutes: ' + t.minutes + '<br>' +
                    'seconds: ' + t.seconds;
  if(t.total<=0){
    clearInterval(timeinterval);
  }
}










