<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">
<head>
<style>
th, td, p, input, h3 {
	font: 15px 'Segoe UI';
}

table, th, td {
	border: solid 1px #ddd;
	border-collapse: collapse;
	padding: 2px 3px;
	text-align: center;
}

th {
	font-weight: bold;
}
</style>
<script type="text/javascript"
	src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script
	src="<c:url value="/resources/JSON-to-Table/JSON-to-Table-1.0.0.js"/>"></script>

</head>
<body>
	<div class="container">
		<div class="starter-template">
			<h1>Spring Boot Example</h1>
			<h2>Title: RESTful API Test</h2>
		</div>
		<form id="condition_form">
			AttrNo:<input type="text" id="attrNo" name="attrNo">
			AttrName:<input type="text" id="attrName" name="attrName">
		</form>
		<br>
		<div>
			<span style="color: blue" id="msg"></span>
		</div>
		<br>
		<button id="btnQuery" type="button" class="btn">
			<span>查詢</span>
		</button>
		<button id="btnInsert" type="button" class="btn">
			<span>新增</span>
		</button>
		<button id="btnUpdate" type="button" class="btn">
			<span>修改</span>
		</button>
		<button id="btnDelete" type="button" class="btn">
			<span>刪除</span>
		</button>
		<br>
		<div>
			<div id=queryData></div>
		</div>
	</div>
</body>
<script type="text/javascript">
	$("#btnQuery").on(
			"click",
			function() {
				var queryUrl;

				if ($('#attrNo').val().length > 0) {
					queryUrl = "/api/tabAttr/" + $('#attrNo').val();
				} else {
					queryUrl = "/api/tabAttr";
				}

				$.ajax({
					type : "GET",
					url : queryUrl,
					dataType : "json",
					beforeSend : function() {
						$("#queryData > table").remove();
					},
					success : function(json) {
						if ($('#attrNo').val().length > 0) {
							$('#queryData').createTable([ json.data ]);
						} else {
							$('#queryData').createTable(json.data);
						}
					},
					error : function(xhr, status, error) {
						$('#msg').css("color", "red").text(
								'Code:' + xhr.responseJSON.body.code
										+ '   Message:'
										+ xhr.responseJSON.body.message);
					}
				});
			});

	$("#btnInsert").on(
			"click",
			function() {
				$.ajax({
					type : "POST",
					url : "/api/tabAttr",
					contentType : "application/json",
					data : JSON.stringify($("#condition_form")
							.serializeObject()),
					dataType : "json",
					beforeSend : function() {
						if ($("#attrNo").val().length == 0
								|| $("#attrName").val().length == 0) {
							$('#msg').css("color", "red").text(
									"AttrNo and AttrName are required");
							return false;
						}
					},
					success : function(json) {
						$('#msg').css("color", "blue").text(json.message);
						$("#btnQuery").trigger("click");
					},
					error : function(xhr, status, error) {
						$('#msg').css("color", "red").text(
								'Code:' + xhr.responseJSON.body.code
										+ '   Message:'
										+ xhr.responseJSON.body.message);
					}
				});
			});

	$("#btnUpdate").on(
			"click",
			function() {
				$.ajax({
					type : "PUT",
					url : "/api/tabAttr",
					contentType : "application/json",
					data : JSON.stringify($("#condition_form")
							.serializeObject()),
					dataType : "json",
					beforeSend : function() {
						if ($("#attrNo").val().length == 0
								|| $("#attrName").val().length == 0) {
							$('#msg').css("color", "red").text(
									"AttrNo and AttrName are required");
							return false;
						}
					},
					success : function(json) {
						$('#msg').css("color", "blue").text(json.message);
						$("#btnQuery").trigger("click");
					},
					error : function(xhr, status, error) {
						$('#msg').css("color", "red").text(
								'Code:' + xhr.responseJSON.body.code
										+ '   Message:'
										+ xhr.responseJSON.body.message);
					}
				});
			});

	$("#btnDelete").on(
			"click",
			function() {
				$.ajax({
					type : "DELETE",
					url : "/api/tabAttr/" + $('#attrNo').val(),
					dataType : "json",
					beforeSend : function() {
						if ($("#attrNo").val().length == 0) {
							$('#msg').css("color", "red").text(
									"AttrNo is required");
							return false;
						}
					},
					success : function(json) {
						$('#msg').css("color", "blue").text(json.message);
						$("#queryData > table").remove()
					},
					error : function(xhr, status, error) {
						$('#msg').css("color", "red").text(
								'Code:' + xhr.responseJSON.body.code
										+ '   Message:'
										+ xhr.responseJSON.body.message);
					}
				});
			});

	$.fn.serializeObject = function() {
		var o = {};
		var a = this.serializeArray();
		$.each(a, function() {
			if (o[this.name]) {
				if (!o[this.name].push) {
					o[this.name] = [ o[this.name] ];
				}
				o[this.name].push(this.value || '');
			} else {
				o[this.name] = this.value || '';
			}
		});
		return o;
	};
</script>
</html>