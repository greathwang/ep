$(function(){
    var $win = $(window);
    var top = $(window).scrollTop(); // 현재 스크롤바의 위치값을 반환합니다.
 
    /*사용자 설정 값 시작*/
    var speed          = "normal";     // 따라다닐 속도 : "slow", "normal", or "fast" or numeric(단위:msec)
    var easing         = 'linear'; // 따라다니는 방법 기본 두가지 linear, swing
    var $layer         = $('.stv_list'); // 레이어 셀렉팅
    var layerTopOffset = 0;   // 레이어 높이 상한선, 단위:px
    $layer.css('position', 'relative');
    /*사용자 설정 값 끝*/
 
    // 스크롤 바를 내린 상태에서 리프레시 했을 경우를 위해
    if (top > 0 )
        $win.scrollTop(layerTopOffset+top);
    else
        $win.scrollTop(0);
 
    //스크롤이벤트가 발생하면
    $(window).scroll(function(){
        yPosition = $win.scrollTop() - 123;
        if (yPosition < 0)
        {
            yPosition = 0;
        }
        $layer.animate({"top":yPosition }, {duration:speed, easing:easing, queue:false});
    });
});

$( function() {
    $( "#startdt" ).datepicker({
    	dateFormat: "yy-mm-dd"
    });	
    $( "#datepicker2" ).datepicker({
    	dateFormat: "yy-mm-dd"
    });	
    $( "#enddt" ).datepicker({
    	dateFormat: "yy-mm-dd"
    });
});

$( function(){
	$("#regi-reply").button().on("click", function(){
		addReply();
	});
	
	function addReply(){
		$("#reply").html("");
		var url = "EmployeeServlet?command=reply_insert"
		var sendJson = new Object();
		
		sendJson.replyContent = $("#content").val();
		sendJson.noticenum = $("#noticenum").val();
		sendJson.empid = $("empid").val();
		$.ajax({
			url:url,
			data:sendJson,
			type:'post',
			datatype : "json",
			contentType:"application/x-www-form-urlencoded; charset=UTF-8",
			success:function(json){
			for(var i=0; i < json.length; i++){
				
					var jsonObject = JSON.stringify(json[i]);
					var reply = JSON.parse(jsonObject);

					$("#reply").append(
						"<tr class='" + reply.replyno + "'>"+ 
						"<td class='repmpid'>" + reply.empnum +"</td>" +
						"<td class='repcontent'>" + reply.content + "</td>" +
						"<td>" + reply.writedate + "</td>" +
						"</tr>");
			}
		}
	});
		$("#content").val("");
		$("#content").focus();
	};
});
