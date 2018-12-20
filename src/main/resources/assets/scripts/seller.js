

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
    imgUrl : "https://rukminim1.flixcart.com/image/880/1056/jggv53k0/backpack/m/k/z/amt-fizz-sch-bag-02-black-ff9-0-09-002-backpack-american-original-imaf4ghyfkaucydj.jpeg?q=50"
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
    imgUrl : "https://rukminim1.flixcart.com/image/880/1056/jggv53k0/backpack/m/k/z/amt-fizz-sch-bag-02-black-ff9-0-09-002-backpack-american-original-imaf4ghyfkaucydj.jpeg?q=50"

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
    imgUrl : "https://rukminim1.flixcart.com/image/880/1056/jggv53k0/backpack/m/k/z/amt-fizz-sch-bag-02-black-ff9-0-09-002-backpack-american-original-imaf4ghyfkaucydj.jpeg?q=50"
}
];

console.log(cancelledOrders);

var orderIterator = 0
$.each(cancelledOrders, function(){

    console.log(cancelledOrders[orderIterator]);

    $('body').append("<div class='order-item' id="+cancelledOrders[orderIterator].orderId+" ></div>");

    $('#'+cancelledOrders[orderIterator].orderId).append('<img src="'+cancelledOrders[orderIterator].imgUrl+'" height="200"/><div class="order-text"><span>"'+cancelledOrders[orderIterator].orderPrice+'"</span><span>"'+cancelledOrders[orderIterator].sla+'"</span><span>"'+cancelledOrders[orderIterator].qty+'"</span><div class="bid-timer">  Days: <span class="days"></span><br>Hours: <span class="hours"></span><br>Minutes: <span class="minutes"></span><br> Seconds: <span class="seconds"></span> </div><div class="optin-btn-container"><input class="optin-btn" type="submit" value="Order OptIn"/></div>');

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

//alert(cancelledOrders);

console.log("check point 2");




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










