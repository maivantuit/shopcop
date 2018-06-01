
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>register</title>
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
		String emailCheck = (String) request.getAttribute("emailCheck");
		if (emailCheck != null) {
	%>
	<script type="text/javascript">
		alert('Email này đã tồn tại, vui lòng nhập email khác!.');
	</script>
	<%
		}
	%>
	<%
		String sdt = (String) request.getAttribute("sdt");
		String ngaysinh = (String) request.getAttribute("ngaysinh");
		String hovaten = (String) request.getAttribute("hovaten");
		String nhaplaimatkhau = (String) request
				.getAttribute("nhaplaimatkhau");
		String diachi = (String) request.getAttribute("diachi");
	%>
	<%
		String nhapLaiMatKhau = (String) request
				.getAttribute("nhapLaiMatKhau");
		if (nhapLaiMatKhau != null) {
	%>
	<script type="text/javascript">
		alert('Nhập lại mật khẩu không trùng khớp!.');
	</script>
	<%
		}
	%>
	<%-- Theo thứ tự --%>
	<jsp:include page="header.jsp"></jsp:include>
	<div class="container">
		<div class="account" id="dangkykhachhang">
			<h2 class="account-in">Register</h2>
			<form action="KhachHangServlet" method="POST">
				<table>
					<tr class="dangKyThanhVien">
						<th>Họ và tên</th>
						<td><input type="text"
							value="<%if (hovaten != null){%><%=hovaten%><%}else{%><%=""%><%}%>" name="hovaten"
							size="100" id="hovaten" /></td>
					</tr>
					<tr class="dangKyThanhVien">
						<th>Email</th>
						<td>
							<%
								if (emailCheck == null) {
							%> <input type="text" name="email"
							id="email" /><span id="user-result"></span> <%
 	} else {
 %> <input
							style="background: rgb(250, 255, 189)" type="text" name="email"
							id="email" /> <span id="user-result"></span> <%
 	}
 %>
						</td>
					</tr>
					<tr class="dangKyThanhVien">
						<th>Ngày sinh</th>
						<td><input type="text"
							value="<%if (ngaysinh != null){%><%=ngaysinh%><%}else{%><%="" %><%}%>"
							name="ngaysinh" id="ngaysinh" /></td>
					</tr>
					<tr class="dangKyThanhVien">
						<th>Địa chỉ</th>
						<td><input id="diachi" type="text"
							value="<%if (diachi != null) {%><%=diachi%><%}else{%><%=""%><%}%>" name="diachi" /></td>
					</tr>
					<tr class="dangKyThanhVien">
						<th>Số điện thoại</th>
						<td><input id="sodienthoai" type="text"
							value="<%if (sdt != null) {%><%=sdt%><%}else{%><%=""%><%}%>" name="sodienthoai" /></td>
					</tr>
					<tr class="dangKyThanhVien">
						<th>Mật khẩu</th>
						<td><input id="matkhau" type="password" name="matkhau" /></td>
					</tr>
					<tr class="dangKyThanhVien">
						<th>Nhập lại mật khẩu</th>
						<td><input id="nhaplaimatkhau" type="password" name="nhaplaimatkhau" /></td>
					</tr>
					<tr class="dangKyThanhVien">
						<td>
							<!-- <button id="quaylainhe">Quay Lại</button> -->
						</td>
						<td><input type="hidden" value="insert" name="command">
							<input type="submit" onclick = "validateForm()" value="Đăng ký"></td>
					</tr>
				</table>
			</form>
		</div>
	</div>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
