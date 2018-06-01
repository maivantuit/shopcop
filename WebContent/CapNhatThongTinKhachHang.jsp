<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="modelclasses.*"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Cập nhật thông tin khách hàng</title>
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"
	type="text/javascript"></script>
<script type="text/javascript">
	function validateForm() {
		var hovaten = document.getElementById("hovaten").value;
		if (hovaten == null || hovaten == "") {
			alert("Vui lòng nhập họ và tên!");
			return false;
		}

		if (email == null || email == "") {
			alert("Vui lòng nhập email!");
			return false;
		}
		var ngaysinh = document.getElementById("ngaysinh").value;
		if (ngaysinh == null || ngaysinh == "") {
			alert("Vui lòng nhập ngày sinh!");
			return false;
		}
		var maukhau = document.getElementById("maukhau").value;
		if (maukhau == null || maukhau == "") {
			alert("Vui lòng nhập email!");
			return false;
		}
		var diachi = document.getElementById("diachi").value;
		if (diachi == null || diachi == "") {
			alert("Vui lòng nhập địa chỉ!");
			return false;
		}
		var nhaplaimatkhau = document.getElementById("nhaplaimatkhau").value;
		if (nhaplaimatkhau == null || nhaplaimatkhau == "") {
			alert("Vui lòng nhập lại mật khẩu!");
			return false;
		}
		var sodienthoai = document.getElementById("sodienthoai").value;
		if (sodienthoai == null || sodienthoai == "") {
			alert("Vui lòng nhập số điện thoại!");
			return false;
		}
	}
</script>
<script type="text/javascript">
	$(document).ready(function() {
		var x_timer;
		$("#email").keyup(function(e) {
			clearTimeout(x_timer);
			var user_name = $(this).val();
			x_timer = setTimeout(function() {
				check_username_ajax(user_name);
			}, 1000);
		});

		function check_username_ajax(username) {
			$("#user-result").html('<img src="img/ajax-loader.gif" />');
			$.post('CheckEmailServlet', {
				'username' : username
			}, function(data) {
				$("#user-result").html(data);
			});
		}
	});
</script>
</head>
<body>
	<%
		KhachHang khachHang = (KhachHang) request.getAttribute("khachHang");
		String checkStr = (String) request.getAttribute("checkStr");
	%>
	<%-- Theo thứ tự --%>
	<jsp:include page="header.jsp"></jsp:include>
	<div class="container">
		<div class="account" id="dangkykhachhang">
			<h2 class="account-in">Register</h2>
			<form action="ChinhSuaThongTinKhachHangServlet" method="POST">
				<table>
					<tr class="dangKyThanhVien">
						<th>Họ và tên</th>
						<td><input type="text"
							value="<%if (khachHang != null) {%><%=khachHang.getTenKH()%><%}else{%><%=""%><%}%>"
							name="hovaten" size="100" id="hovaten" /></td>
					</tr>
					<tr class="dangKyThanhVien">
						<th>Email</th>
						<td>
							 <input style="background: rgb(250, 255, 189)" type="text"
							name="email" value="<%if (khachHang != null) {%><%=khachHang.getEmail()%><%}else{%><%=""%><%}%>" id="email" />
						</td>
					</tr>
					<tr class="dangKyThanhVien">
						<th>Ngày sinh</th>
						<td><input type="text"
							value="<%if (khachHang != null) {%><%=khachHang.getNgaySinh()%><%} else {%><%=""%><%}%>"
							name="ngaysinh" id="ngaysinh" /></td>
					</tr>
					<tr class="dangKyThanhVien">
						<th>Địa chỉ</th>
						<td><input id="diachi" type="text"
							value="<%if (khachHang != null) {%><%=khachHang.getDiaChi()%><%} else {%><%=""%><%}%>"
							name="diachi" /></td>
					</tr>
					<tr class="dangKyThanhVien">
						<th>Số điện thoại</th>
						<td><input id="sodienthoai" type="text"
							value="<%if (khachHang != null) {%><%=khachHang.getSdt()%><%} else {%><%=""%><%}%>"
							name="sodienthoai" /></td>
					</tr>
					<tr>
						<td></td>
						<td>
						<%
							if(checkStr!=null){
						%>
							<h3 style="color:blue;" ><%=checkStr%></h3>							
						<%} %>
						</td>
					</tr>					
					<tr class="dangKyThanhVien">
						<td>
							<!-- <button id="quaylainhe">Quay Lại</button> -->
						</td>
						<td><input type="hidden" value="insert" name="command">
							<input type="submit" onclick="validateForm()" value="Lưu">
						</td>
					</tr>
				</table>
			</form>
		</div>
	</div>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
