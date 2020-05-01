function searchKeyword() {
    var KeywordSearchDTO = {};
    KeywordSearchDTO.accLicense = $("#accLicense").val();
    KeywordSearchDTO.customerId = $("#customerId").val();
    KeywordSearchDTO.secretKey = $("#secretKey").val();
    KeywordSearchDTO.keyword = $("#keyword").val();

    if (KeywordSearchDTO.keyword == "") {
        alert("키워드를 입력해주세요.");
    }
    else {
        $.ajax({
            type: "GET",
            url: "/mvp/search",
            data: KeywordSearchDTO,
            success: function (data) {
                var template = makeDataTable(data);
                $("#resultTable").append(template);
            },
            error: function () {
                alert("fail!!!");
            }
        });
    }
}

function makeDataTable(data) {
    var template = "";
    template += "<tr>";
    template += "<td>";
    template += "<b>" + data.keyword + "</b>";
    template += "</td>";
    template += "<td>";
    template += data.searchCnt;
    template += "</td>";
    template += "<td>";
    template += data.shopCnt;
    template += "</td>";
    template += "<td>";
    if (data.rate < 1) {
        template += "<label class='goodKeyword'>" + data.rate + "%</label>";
    } else if (data.rate > 5) {
        template += "<label class='badKeyword'>" + data.rate + "%</label>";
    } else {
        template += data.rate + "%";
    }
    template += "</td>";
    template += "<td>";
    template += data.clickCnt;
    template += "</td>";
    template += "<td>";
    template += data.clickRate.toFixed(2);
    template += "</td>";
    template += "<td>";
    template += data.adCount;
    template += "</td>";
    template += "<td>";
    template += data.compIdx;
    template += "</td>";
    template += "</tr>";

    return template;
}