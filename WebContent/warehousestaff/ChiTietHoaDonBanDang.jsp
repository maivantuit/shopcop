<%-- 
    Document   : manager_sanpham
    Created on : Nov 28, 2017, 11:04:53 AM
    Author     : CỌP
--%>

<%@page import="dao.SanPhamDAO"%>
<%@page import="modelclasses.*"%>
<%@page import="dao.ChiTietHoaDonDAO"%>
<%@page import="dao.KhachHangDao"%>
<%@page import="java.util.ArrayList"%>
<%@page import="modelclasses.HoaDon"%>
<%@page import="dao.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Cập nhật trạng thái đơn hàng</title>
<link href="../css/mos-style.css" rel='stylesheet' type='text/css' />
</head>
<body>
	<script type="text/javascript">
	function validateForm() {
		var trangThai = document.getElementById("chonTrangThai").value;
		if (trangThai == null || trangThai == "") {
			alert("Vui lòng chọn người trạng thái giao hàng!");
			return false;
		}
	}
	</script>

	<%
					ChiTietHoaDonDAO chitiethoadondao = new ChiTietHoaDonDAO();
		            String madonhang ="";
		            if(request.getParameter("madh")!=null){ // từ link url
		                madonhang = request.getParameter("madh");
		            }      
		            String mesStr = (String) request.getAttribute("mesStr");
		            SanPhamDAO sanphamdao = new SanPhamDAO();
		            
		            NguoiGiaoHangDAO nguoiGiaoHangDAO = new NguoiGiaoHangDAO();
		    		ArrayList<NguoiGiaoHang> listNguoiGiaoHang = nguoiGiaoHangDAO
		    				.getNhanVienGiaoHang();
	%>
	<jsp:include page="header.jsp"></jsp:include>
	<div id="wrapper">
		<jsp:include page="menu.jsp"></jsp:include>
		<div id="rightContent">
			<form action="/doancntt/CapNhatTrangThaiDonHangServlet" method="POST">
				<h3>Cập nhật trạng thái đơn hàng</h3>
				<table class="data">
					<tr class="data">
						<th class="data" width="30px">STT</th>
						<th class="data" width="30px">Mã hóa đơn</th>
						<th class="data" width="30px">Mã Sản Phẩm</th>
						<th class="data">Tên sản phẩm</th>
						<th class="data" width="30px">Số lượng</th>						
					</tr>
					<%
						int dem=0;
								for (ChiTietHoaDon c : ChiTietHoaDonDAO.getListChiTietHoaDon(madonhang)) {
									dem++;
					%>
					<tr class="data">
						<td class="data" width="30px"><%=dem%></td>
						<td class="data" width="30px"><input style="text-align: center; background: #CCC" name="maDonHangNhe"
							value="<%=c.getMaDH()%>" /></td>
						<td class="data" style="text-align: center"><input style="text-align: center; background: #CCC" name="maSanPham"
							value="<%=c.getMaSP()%>" /></td>
						<td class="data"><%=sanphamdao.getASanPham(c.getMaSP()).getTenSP()%></td>
						<td class="data"><%=c.getSoLuong()%></td>						
					</tr>
					<%
						}
					%>
				</table>
				<div style="text-align: center">
					Trạng thái:
					<select id="chonTrangThai" name="chonTrangThaiNhe">
						<option value="">--Chọn trạng thái--</option>						
						<option value="Hoàn tất">Hoàn tất</option>
						<option value="Trả lại">Trả lại</option>						
					</select> 
					Ngày giao/Ngày kết thúc: <input  name="ngayGiao" type="text" />
					<input type="hidden" name="command" value="themdanhmucmoi">
					<input type="submit" class="button" onclick = "validateForm()" value="Duyệt">
				</div>
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
