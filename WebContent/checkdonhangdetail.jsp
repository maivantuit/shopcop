<%-- 
    Document   : manager_sanpham
    Created on : Nov 28, 2017, 11:04:53 AM
    Author     : CỌP
--%>

<%@page import="modelclasses.KhachHang"%>
<%@page import="dao.SanPhamDAO"%>
<%@page import="modelclasses.ChiTietHoaDon"%>
<%@page import="dao.ChiTietHoaDonDAO"%>
<%@page import="dao.KhachHangDao"%>
<%@page import="java.util.ArrayList"%>
<%@page import="modelclasses.HoaDon"%>
<%@page import="dao.HoaDonDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Quản lý chi tiết hóa đơn bán hàng</title>
<link href="../css/mos-style.css" rel='stylesheet' type='text/css' />
</head>
<body>

	<%
		ChiTietHoaDonDAO chitiethoadondao = new ChiTietHoaDonDAO();
	            String madh3 = "";
	            if (request.getParameter("madh3") != null) { // từ link url
	                madh3 = request.getParameter("madh3");
	            }
	            SanPhamDAO sanphamdao = new SanPhamDAO();
	            ArrayList<HoaDon> listhoadon2 = HoaDonDAO.getListHoaDonHaveCodeTheoMaHoaDon(madh3);
	            
	            // khách hàng info:
	           KhachHang kh = null;
	            if (session.getAttribute("user") != null) {
	                kh = (KhachHang) session.getAttribute("user");
	            }
	%>
	<jsp:include page="header.jsp"></jsp:include>
	<%
		for (HoaDon elem2 : listhoadon2) {
	%>
	<div id="wrapper">
		<div id="rightContent">
			<div>
				<span>Đơn hàng #<%=madh3%></span> <span style="float: right">Ngày
					giờ đặt hàng: <%=elem2.getNgayDat()%></span>
			</div>

			<div id="chitietdonhangcuaban">
				<div id="diachinguoinhan">
					<h5 style="background: violet; text-align: center">ĐỊA CHỈ
						NGƯỜI NHẬN</h5>
					<div class="phuongthucthanhtoannho1">
						<h6><%=kh.getTenKH()%></h6>
						<h6>
							Địa chỉ:
							<%=kh.getDiaChi()%></h6>
						<h6>
							Số điện thoại:
							<%=kh.getSdt()%></h6>
					</div>
				</div>
				<div id="phuongthucthanhtoan"></div>
			</div>
			<div id="checkDonHangDetailList">
				<table>
					<tr>
						<th width="30px">STT</th>
						<th>Mã hóa đơn</th>
						<th>Mã Sản Phẩm</th>
						<th>Tên sản phẩm</th>
						<th width="30px">Số lượng</th>
					</tr>
					<%
						int dem = 0;
						for (ChiTietHoaDon c : ChiTietHoaDonDAO.getListChiTietHoaDon(madh3)) {
					   		dem++;
					%>
					<tr>
						<td width="30px"><%=dem%></td>
						<td><%=c.getMaDH()%></td>
						<td><%=c.getMaSP()%></td>
						<td><%=sanphamdao.getASanPham(c.getMaSP()).getTenSP()%></td>
						<td><%=c.getSoLuong()%></td>
					</tr>
					<%
						}
					%>
				</table>
			</div>
			<h4>
				Tổng tiền tạm tính:
				<%=elem2.getTongTien()%>
				VNĐ
			</h4>
			<input style="background: violet; color: black" type="submit"
				value="Hủy đơn hàng">
		</div>
		<div class="clear"></div>
		<%
			}
		%>
		<jsp:include page="footer.jsp"></jsp:include>
	</div>
</body>
</html>
