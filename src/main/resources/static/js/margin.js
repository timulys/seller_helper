function calculate() {
    commisionCalc();
}

function commisionCalc() {
    var originPrice = $("#originPrice").val() * 1;
    var orderFee = $("#orderFee").val() * 1;
    var platformFee = $("#platformFee").val() * 1;
    var sellerOrderFee = $("#sellerOrderFee").val() * 1;
    var sellerMarginPrice = $("#sellerMarginPrice").val() * 1;

    var sellerBuy = originPrice + orderFee;
    var platformFeePrice = sellerMarginPrice * (platformFee/100);  // 플랫폼 수수료
    var marginPrice = sellerMarginPrice + sellerOrderFee - platformFeePrice - sellerBuy;    // 마진금액
    var sellMarginRate = marginPrice / sellerMarginPrice * 100;

    $("#sellBuy").val(Math.round(sellerBuy));
    $("#calPlatformFee").val(Math.round(platformFeePrice));
    $("#sellPrice").val(Math.round(marginPrice));
    $("#sellMarginRate").val(Math.round(sellMarginRate));
}