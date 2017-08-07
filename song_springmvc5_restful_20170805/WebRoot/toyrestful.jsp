<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>单页应用 + restful</title>
<link
	href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body>
	<div style="margin-left: 10px;margin-right: 10px;">
		<h2>Springmvc + Spring + Mybatis + MySQL</h2>

		<form name="f" role="formRole">
			<div class="form-group">
				<input type="text" class="form-control" id="name" placeholder="玩具名">
			</div>
			<div class="form-group">
				<input type="date" class="form-control" id="beginDate">
			</div>
			<div class="form-group">
				<input type="date" class="form-control" id="endDate">
			</div>
			<button type="button" id="btnQuery" class="btn btn-primary btn-block">查询</button>
		</form>
		<br> <br>

		<table class="table table-striped table-hover">
			<caption>Toy CRUD</caption>
			<thead>
				<tr>
					<th>玩具名</th>
					<th>价格</th>
					<th>生产日期</th>
					<th>操作</th>
				</tr>
			</thead>
			<tbody id="tbody">
			</tbody>
		</table>

		<!-- ===================修    改======================== -->
		<form name="f" role="formRole">
			<div class="form-group">
				<input type="hidden" id="id"> <input type="text"
					class="form-control" id="toyname" placeholder="玩具名">
			</div>
			<div class="form-group">
				<input type="number" step="0.01" class="form-control" id="price"
					placeholder="价格">
			</div>
			<div class="form-group">
				<input type="date" class="form-control" id="createDate">
			</div>
			<button type="button" id="btnAdd" class="btn btn-success btn-block">新增</button>
			<button type="button" id="btnModify"
				class="btn btn-default btn-block">修改 保存</button>
		</form>

	</div>
	<script
		src="${pageContext.request.contextPath}/resources/js/jquery-3.2.1.min.js"></script>

	<script type="text/javascript">
		$(function() {
			//加载所有数据 *********************************************************
			/* $.ajax({
				type: "GET",
				url: "toy",
				data: {},
				dataType: "json",
				success: function (data) {
					alert(data);
					$.each(data, function(i) {
						var btnModify = "<button type=\"button\" onclick=\"findByIdToy(" + 
							data[i].id + ")\" class=\"btn btn-warning\">修改</button>"
						var btnRemove = "<button type=\"button\" onclick=\"removeToy( " + 
							data[i].id + ", '" + "')\" class=\"btn btn-danger\">删除</button>";
						
						var text = "<tr id=\"" + data[i].id + "\">"
						text += " <td>" + data[i].name + "</td>"
						text += " <td>" + data[i].price + "</td>"
						text += " <td>" + data[i].createDate + "</td>"
						text += " <td>" + btnModify + "&nbsp;&nbsp;" + btnRemove + "</td>"
						text += "</tr>"
						 
						 $("#tbody").append(text);
					})
				},
				error: function(msg) {
					console.log("与服务器断开连接", msg)
				}
			}) */
	
			// 查询按钮事件 ***********************************************************
			$("#btnQuery").click(function() {
				$.ajax({
					type : "GET",
					url : "toy",
					data : {
						name : $.trim($("#name").val()),
						beginDate : $("#beginDate").val(),
						endDate : $("#endDate").val()
					},
					dataType : "json",
					success : function(data) {
						/* alert(data); */
						$("#tbody").empty();
						$.each(data, function(i) {
							var btnModify = "<button type=\"button\" onclick=\"findByIdToy(" +
								data[i].id + ")\" class=\"btn btn-warning\">修改</button>"
							/* var btnModify = "<button type=\"button\" onclick=\"findByIdToy(" + data[i].id + ")\" class=\"btn btn-warning\">修改 </button>" */
							var btnRemove = "<button type=\"button\" onclick=\"removeToy( " +
								data[i].id + ", '" + data[i].name + "')\" class=\"btn btn-danger\">删除</button>";
	
							var text = "<tr id=\"" + data[i].id + "\">"
							text += " <td>" + data[i].name + "</td>"
							text += " <td>" + data[i].price + "</td>"
							text += " <td>" + data[i].createDate + "</td>"
							text += " <td>" + btnModify + "&nbsp;&nbsp;" + btnRemove + "</td>"
							text += "</tr>"
	
							$("#tbody").append(text);
						})
					},
					error : function(msg) {
						console.log("与服务器断开连接", msg)
					}
				})
			})
	
			//默认点击查询，加载所有数据；**********************************************
			$("#btnQuery").click();
		})
	
		//修改按钮，加载一条数据，**************************************************
		function findByIdToy(id) {
			alert(id)
			$.ajax({
				type : "GET",
				url : "toy/" + id,
				dataType : "json",
				success : function(data) {
					$("#id").val(data.id)
					$("#toyname").val(data.name)
					$("#price").val(data.price)
					$("#createDate").val(data.createDate)
				},
				error : function(msg) {
					console.log("服务器断开连接....", msg)
				}
			})
		}
		//删除按钮，*******************************************************************		
		function removeToy(id) {
			alert(id)
	
		}
	</script>

</body>
</html>