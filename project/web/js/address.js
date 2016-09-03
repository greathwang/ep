$(function(){
	var dialog;
	dialog = $("#dialog-form").dialog({
		autoOpen : false,
		height: 700,
		width: 500,
		modal: true,
		buttons:{
			"취소": function(){
				dialog.dialog("close");
			}
		}
	});
	$("#find_address").button().on("click", function(){
		dialog.dialog("open");
	});
	
	$("#address_find").button().on("click", function(){
		replyAddress();
	});
	
	function replyAddress(){
		var url = "EmployeeServlet?command=addr_search"
		var sendJson = new Object();
		
		sendJson.addrtext = $("#addrtext").val();
		$.ajax({
			url:url,
			data:sendJson,
			type:'post',
			dataType:"json",
			contentType:"application/x-www-form-urlencoded; charset=UTF-8",
			success:function(json){
				$("#addrTable").html("");
				$("#addrTable").append(
						"<tr>" +
						"<td>우편번호</td>" +
						"<td>주소</td>" +
						"</tr>"
				);
				
				for(var i=0; i < json.length; i++){
					var jsonObject = JSON.stringify(json[i]);
					var addr = JSON.parse(jsonObject);
					
					
					
					$("#addrTable").append(
							"<tr class=zip>"+
							"<td>" 
								+addr.sido + addr.sigugun + addr.dong + 
								addr.ri  + addr.bldg + addr.bungi + 
							"</td>" +
							"</tr>"
					);
					$(document).on("click",".zip",function(){
						$("#address").val($(this).text());
						$("#zipcode").val(addr.zipcode);

						$("#addrTable").html("");
						dialog.dialog("close");
					});
				}
			},
				error : function(){
					alert("실패");
			}
		});
	
	};
});
