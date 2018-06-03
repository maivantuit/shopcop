<%-- 
    Document   : manager_sanpham
    Created on : Nov 28, 2017, 11:04:53 AM
    Author     : CỌP
--%>
<%@page import="java.text.NumberFormat"%>
<%@page import="modelclasses.ChiTietHoaDon"%>
<%@page import="dao.ChiTietHoaDonDAO"%>
<%@page import="dao.KhachHangDao"%>
<%@page import="java.util.ArrayList"%>
<%@page import="modelclasses.*"%>
<%@page import="dao.HoaDonDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Hóa đơn cần giao</title>
<link href="css/mos-style.css" rel='stylesheet' type='text/css' />
<script type="text/javascript">
/* 	function validateForm() {
		var nguoiDH = document.getElementById("nguoiDH").value;
		if (nguoiDH == null || nguoiDH == "") {
			alert("Vui lòng chọn người giao hàng!");
			return false;
		}
	} */
</script>
</head>
<body>

	<%
		ArrayList<HoaDon> listhoadon =(ArrayList<HoaDon>) request.getAttribute("listhoadon");
		String mesStr = (String) request.getAttribute("mesStr");
		ChiTietHoaDonDAO chitiethoadondao = new ChiTietHoaDonDAO();
		KhachHangDao khachhangdao = new KhachHangDao();
		
		
	%>
	<jsp:include page="header.jsp"></jsp:include>
	<div id="wrapper">
		<jsp:include page="menu.jsp"></jsp:include>
		<div id="rightContent">
			<form action="DuyetDonHangServlet" method="POST">
				<h3>Quản lý hóa đơn bán hàng</h3>
				<table class="data">
					<tr class="data">
						<th class="data" width="20px">STT</th>
						<th class="data" width="30px">Mã hóa đơn</th>
						<th class="data" width="30px">Mã khách Hàng</th>
						<th class="data" width="30px">Tên khách hàng</th>
						<th class="data" width="30px">Số điện thoại</th>
						<th class="data" width="30px">Ngày đặt</th>
						<th class="data" width="30px">Nhân viên giao hàng</th>
						<th class="data" width="30px">Tổng tiền(VNĐ)</th>
						<th class="data" width="75px">Địa chỉ giao hàng</th>						
					</tr>
					<%
						int dem = 0;
						for (HoaDon elemhd : listhoadon) {
							dem++;
					%>
					<tr class="data">
						<td class="data" width="30px"><%=dem%></td>
						<td class="data" width="30px"><a
							href="/doancntt/deliveryman/manager_chitiethoadonbanhang.jsp?madh=<%=String.valueOf(elemhd.getMaDH())%>"><%=elemhd.getMaDH()%></a>
						</td>
						<td class="data"><%=elemhd.getMaKH()%></td>
						<td class="data"><%=elemhd.getNguoiNhan()%></td>
						<td class="data"><%=elemhd.getSoDienThoai()%></td>
						<td class="data"><%=elemhd.getNgayDat()%></td>
						<td class="data"><%=elemhd.getNguoiGiao()%></td>
						<td class="data"><%=NumberFormat.getInstance().format(elemhd.getTongTien())%></td>
						<td class="data"><%=elemhd.getDiaChi()%></td>						
					</tr>
					<%
						}
					%>
				</table>
			</form>
		</div>
		<div class="clear"></div>

		<jsp:include page="footer.jsp"></jsp:include>
	</div>
	<%
		if(mesStr!=null){
	%>
	<script type="text/javascript">
		alert('Duyệt đơn hàng thành công');
	</script>
	<%
		}
	%>
</body>
</html>
