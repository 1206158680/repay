<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<meta http-equiv="Cache-Control" content="no-siteapp" />
<!--[if lt IE 9]>
<script type="text/javascript" src="lib/html5shiv.js"></script>
<script type="text/javascript" src="lib/respond.min.js"></script>
<![endif]-->
<link rel="stylesheet" type="text/css" href="static/h-ui/css/H-ui.min.css" />
<link rel="stylesheet" type="text/css" href="static/h-ui.admin/css/H-ui.admin.css" />
<link rel="stylesheet" type="text/css" href="lib/Hui-iconfont/1.0.8/iconfont.css" />
<link rel="stylesheet" type="text/css" href="static/h-ui.admin/skin/default/skin.css" id="skin" />
<link rel="stylesheet" type="text/css" href="static/h-ui.admin/css/style.css" />
<!--[if IE 6]>
<script type="text/javascript" src="lib/DD_belatedPNG_0.0.8a-min.js" ></script>
<script>DD_belatedPNG.fix('*');</script>
<![endif]-->
<title>浙江大学城市学院出差报销单</title>
<meta name="keywords" content="H-ui.admin 3.0,H-ui网站后台模版,后台模版下载,后台管理系统模版,HTML后台模版下载">
<meta name="description" content="H-ui.admin 3.0，是一款由国人开发的轻量级扁平化网站后台模板，完全免费开源的网站后台管理系统模版，适合中小型CMS后台系统。">
</head>
<body>
<article class="page-container">
	<form class="form form-horizontal" id="form-admin-add">
	<table class="table table-border table-bordered">
		<tbody>
			<tr>
				<th width = '15%'>单位</th>
				<td width = '15%'><input type="text" id = 'company' class="input-text radius size-S"></td>
				<td width = '70%'>
					<table class="table table-border table-bordered" id = "name">
						<tbody>
							<tr>
								<th width = '2%'><input class="btn btn-primary size-S radius" type="button" value="添加" onclick="AddColumn()"></th>
								<th width = '10%'>姓名</th>
								<td width = '8%'><input type="text" placeholder="姓名" class="input-text radius size-S"></td>
								<td width = '8%'><input type="text" placeholder="姓名" class="input-text radius size-S"></td>
								<td width = '8%'><input type="text" placeholder="姓名" class="input-text radius size-S"></td>
							</tr>
							<tr>
								<th></th>
								<th width = '10%'>职称</th>
								<td width = '8%'><input type="text" placeholder="姓名" class="input-text radius size-S"></td>
								<td width = '8%'><input type="text" placeholder="姓名" class="input-text radius size-S"></td><td width = '8%'>
								<input type="text" placeholder="姓名" class="input-text radius size-S"></td>
							</tr>
							
						</tbody>
					</table>
				</td>
			</tr>
			<tr>
				<th width = '15%'>经费项目代码</th>
				<td width = '15%'><input type="text" id='projectId' class="input-text radius size-S"></td>
				<td width = '70%'>
					<table class="table table-border table-bordered">
						<tbody>
							<tr>
								<th width = '10%'>出差事由</th>
								<td width = '8%'><input type="text" id = 'reason'  class="input-text radius size-S"></td>
								<th width = '10%'>附单据</th>
								<td width = '8%'><input type="text" id = 'annex' class="input-text radius size-S"></td>
							</tr>						
						</tbody>
					</table>
				</td>
			</tr>	
		</tbody>
	</table>
	
	
	<table class="table table-border table-bordered" Id = 'travel'>
		<thead>
			<tr>
				<th width = '2%'><input class="btn btn-primary size-S radius" type="button" value="添加" onclick="AddRow()"></th>
				<th width = '5%'>出差地点
					<div class="row cl">
					<div class="formControls col-xs-8 col-sm-9 skin-minimal">
						<div class="radio-box">
							<input name="sex" type="radio" id="sex-1" checked>
							<label for="sex-1">省内</label>
						</div>
						<div class="radio-box">
							<input type="radio" id="sex-2" name="sex">
							<label for="sex-2">省外</label>
						</div>
						</div>
					</div>
				</th>
				<th width = '5%'>起止日期</th>
				<th width = '5%'>天数</th>
				<th width = '15%' colspan="3">
				<table class="table table-border table-bordered">
					<tbody>
						<tr>
							<th width = '15%' colspan="3">城市间交通费</th>
						</tr>
						<tr>
							<th width = '5%'>飞机</th>
							<th width = '5%'>火车</th>
							<th width = '5%'>其他</th>
						
					</tbody>
				</table>
				</th>
				
				<th width = '5%'>住宿费</th>
				<th width = '10%' colspan="2">
				<table class="table table-border table-bordered">
					<tbody>
						<tr>
							<th width = '10%' colspan="2">补贴报销</th>
						</tr>
						<tr>
							<th width = '5%'>伙食补助费</th>
				<th width = '5%'>公杂费</th>
						
					</tbody>
				</table>
				</th>
				<th width = '5%'>其他</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<th></th>
				<td width = '5%'><input type="text" id = 'travelLocation0' class="input-text radius size-S"></td>	
				<td width = '5%'>
					<input type="text" onfocus="WdatePicker()" id="startData0" class="input-text Wdate" style="width:120px;">
					——
					<input type="text" onfocus="WdatePicker()" id="endData0" class="input-text Wdate" style="width:120px;">
				</td>	
				<td width = '5%'><input type="text" id = 'days0' class="input-text radius size-S"></td>	
				<td width = '5%'><input type="text" id = 'plane0' class="input-text radius size-S"></td>	
				<td width = '5%'><input type="text" id = 'train0' class="input-text radius size-S"></td>	
				<td width = '5%'><input type="text" id = 'tasfficOther0' class="input-text radius size-S"></td>	
				<td width = '5%'><input type="text" id = 'stayFees0' class="input-text radius size-S"></td>	
				<td width = '5%'><input type="text" id = 'foodFees0' class="input-text radius size-S"></td>	
				<td width = '5%'><input type="text" id = 'miFess0' class="input-text radius size-S"></td>	
				<td width = '5%'><input type="text" id = 'other0' class="input-text radius size-S"></td>	
			</tr>

		</tbody>
	</table>
		<table class="table table-border table-bordered" >
		<tbody>
			<tr>	
				<th width = '12%' colspan="4">转卡信息</th>
				<th width = '88' colspan="8">
					<table class="table table-border table-bordered">
						<tbody>
							<tr>
								<th width = '15%' >工号</th>
								<th width = '15%' >姓名</th>
								<th width = '45%' >建行卡号</th>
								<th width = '15%' >转卡金额</th>
							</tr>
							<tr>
								<td width = '15%'><input type="text" id = 'workerId' class="input-text radius size-S"></td>	
								<td width = '15%'><input type="text" id = 'userName' class="input-text radius size-S"></td>	
								<td width = '45%'><input type="text" id = 'cardNumber' class="input-text radius size-S"></td>	
								<td width = '15%'><input type="text" id = 'money' class="input-text radius size-S"></td>		
							</tr>
						</tbody>
					</table>
				</th>
			</tr>
		</tbody>
	</table>
	<div class="row cl">
		<div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-3">
			<input class="btn btn-primary radius" type="button" onclick = 'addRepay()' value="&nbsp;&nbsp;提交&nbsp;&nbsp;">
		</div>
	</div>
	</form>
</article>

<!--_footer 作为公共模版分离出去--> 
<script type="text/javascript" src="lib/jquery/1.9.1/jquery.min.js"></script> 
<script type="text/javascript" src="lib/layer/2.4/layer.js"></script>
<script type="text/javascript" src="static/h-ui/js/H-ui.min.js"></script> 
<script type="text/javascript" src="static/h-ui.admin/js/H-ui.admin.js"></script>
<!--/_footer 作为公共模版分离出去-->

<!--请在下方写此页面业务相关的脚本-->
<script type="text/javascript" src="lib/My97DatePicker/4.8/WdatePicker.js"></script> 
<script type="text/javascript" src="lib/jquery.validation/1.14.0/jquery.validate.js"></script> 
<script type="text/javascript" src="lib/jquery.validation/1.14.0/validate-methods.js"></script> 
<script type="text/javascript" src="lib/jquery.validation/1.14.0/messages_zh.js"></script> 
<script type="text/javascript">
function GetRequest() {   
	   var url = location.search; 
	   var theRequest = new Object();   
	   if (url.indexOf("?") != -1) {   
	      var str = url.substr(1);   
	      strs = str.split("&");   
	      for(var i = 0; i < strs.length; i ++) {   
	         theRequest[strs[i].split("=")[0]]=decodeURI(strs[i].split("=")[1]);   
	      }   
	   }   
	   return theRequest;   
}   
var Request = new Object(); 
Request = GetRequest(); 
var repayId;
repayId = Request['repayId'];

$(document).ready(function (){
	var params = {
			"repayId":repayId,
	}
	 $.ajax({    
	        type: "post",    
	        async: true,    
	        url: "/repay/searchRepay.do",    
	        data: JSON.stringify(params),
	        dataType: "json",   
	        contentType: "application/json; charset=utf-8",   
	        success: function(data){
	        	 alert(data);
	        	 $("#company").val(data.company);
	        	 $("#projectId").val(data.projectId);
	        	 $("#reason").val(data.reason);
	        	 $("#annex").val(data.annex);
	        	 $("#workerId").val(data.workerId);
	        	 $("#userName").val(data.userName);
	        	 $("#cardNumber").val(data.cardNumber);
	        	 $("#money").val(data.money);
	        	 var travel = data.travel;
	        	 alert(travel[0].train);
	        	 
			},
	        error: function(XmlHttpRequest, textStatus, errorThrown){
				layer.msg('error!',{icon:1,time:1000});
			}
		});

     $("#projectId").val(projectId);
     
})
var obj = document.getElementById( "name" );	//获取表格的ID
var obj2 = document.getElementById( "travel" );	//获取表格的ID
//增加行
var index = 0;
function AddRow(  ){
	index++;
	var rowCount = obj2.rows.length;
	var cellCount = obj2.rows[0].cells.length;
	var tRow = obj2.insertRow( rowCount );
	tRow.insertCell(0).innerHTML = "<td width = '5%'></td>";
	tRow.insertCell(1).innerHTML = "<td width = '5%'><input type='text' id='travelLocation"+index+"' class='input-text radius size-S'></td>";
	tRow.insertCell(2).innerHTML = "<td width = '5%'><input type='text' onfocus='WdatePicker()' id='startData"+index+"' class='input-text Wdate' style='width:120px;'>"+
	"——<input type='text' onfocus='WdatePicker()' id='endData"+index+"' class='input-text Wdate' style='width:120px;'>"+
	"</td>";
	tRow.insertCell(3).innerHTML = "<td width = '5%'><input type='text' id = 'days"+index+"' class='input-text radius size-S'></td>";
	tRow.insertCell(4).innerHTML = "<td width = '5%'><input type='text' id = 'plane"+index+"' class='input-text radius size-S'></td>";
	tRow.insertCell(5).innerHTML = "<td width = '5%'><input type='text' id = 'train"+index+"' class='input-text radius size-S'></td>";
	tRow.insertCell(6).innerHTML = "<td width = '5%'><input type='text' id = 'tasfficOther"+index+"' class='input-text radius size-S'></td>";
	tRow.insertCell(7).innerHTML = "<td width = '5%'><input type='text' id = 'stayFees"+index+"' class='input-text radius size-S'></td>";
	tRow.insertCell(8).innerHTML = "<td width = '5%'><input type='text' id = 'foodFees"+index+"' class='input-text radius size-S'></td>";
	tRow.insertCell(9).innerHTML = "<td width = '5%'><input type='text' id = 'miFess"+index+"' class='input-text radius size-S'></td>";
	tRow.insertCell(10).innerHTML = "<td width = '5%'><input type='text' id = 'other"+index+"' class='input-text radius size-S'></td>";
}

//增加列
function AddColumn(  )
{
	var rowCount = obj.rows.length;
	var cellCount = obj.rows[0].cells.length;
	var tRow = obj.rows[0];
	var tCell = tRow.insertCell( cellCount );
	tCell.innerHTML = "<td width = '5%'><input type='text' placeholder='单位（公章）' class='input-text radius size-S'></td>";
	var tRow = obj.rows[1];
	var tCell = tRow.insertCell( cellCount );
	tCell.innerHTML = "<td width = '5%'><input type='text' placeholder='单位（公章）' class='input-text radius size-S'></td>";
}

function addRepay(){
	var itemTravel = [];
	var travelUser = [];
	for(var i = 0; i <= index; i++){
		var travel = {
				"travelProvince":'省内',
				"travelLocation":document.getElementById("travelLocation"+i).value,
				"startData":document.getElementById("startData"+i).value,
				"endData":document.getElementById("endData"+i).value,
				"days":document.getElementById("days"+i).value,
				"train":document.getElementById("train"+i).value,
				"plane":document.getElementById("plane"+i).value,
				"tasfficOther":document.getElementById("tasfficOther"+i).value,
				"stayFees":document.getElementById("stayFees"+i).value,
				"foodFees":document.getElementById("foodFees"+i).value,
				"miFess":document.getElementById("miFess"+i).value,
				"other":document.getElementById("other"+i).value,	
				
		}
		itemTravel.push(travel);
	}
	alert(itemTravel);
	var user = {
			"userName":"userna",
			"userJob":"job1",
	}
	travelUser.push(user);
 	 var params={
 			"projectId":document.getElementById("projectId").value,
	    	"company":document.getElementById("company").value,
	    	"reason":document.getElementById("reason").value,
	    	"annex":document.getElementById("annex").value,
	    	"annexPath":"",
	    	"workerId":document.getElementById("workerId").value,
	    	"userName":document.getElementById("userName").value,
	    	"cardNumber":document.getElementById("cardNumber").value,
	    	"money":document.getElementById("money").value,
	    	"approvalId":"",
	    	"applicationId":"",
	    	"auditor":"",
	    	
	} 
	params["travel"]=itemTravel;
 	params["traveluser"]=travelUser;
 	 
	alert(JSON.stringify(params)); 
       $.ajax({    
        type: "post",    
        async: true,    
        url: "/repay/addRepay.do",    
        data: JSON.stringify(params),
        dataType: "json",   
        contentType: "application/json; charset=utf-8",   
        success: function(data){
			layer.msg('添加成功!',{icon:1,time:1000});
		},
        error: function(XmlHttpRequest, textStatus, errorThrown){
			layer.msg('error!',{icon:1,time:1000});
		}
	});
    /*if(isBudget == 3){
    	isBudget = 4;
    }
    else{
    	isBudget = 2
    }	
    var params={
	 			"projectId":document.getElementById("projectId").value,
		    	"isBudget":isBudget,
	} 
    $.ajax({    
	        type: "post",    
	        async: true,    
	        url: "/repay/applySuccProject.do",    
	        data: JSON.stringify(params),
	        dataType: "json",   
	        contentType: "application/json; charset=utf-8",   
	        success: function(data){

			},
	        error: function(XmlHttpRequest, textStatus, errorThrown){
				layer.msg('error!',{icon:1,time:1000});
			}
	});
	var index = parent.layer.getFrameIndex(window.name);
	parent.$('.btn-refresh').click();
	parent.layer.close(index);   */
}
</script> 
<!--/请在上方写此页面业务相关的脚本-->
</body>
</html>