<%@page import="modelclasses.*"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dao.DanhMucDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Nhập hàng</title>
<link href="css/mos-style.css" rel='stylesheet' type='text/css' />
</head>
<body>
<%
	ArrayList<SanPham> listMaSP = (ArrayList<SanPham>)request.getAttribute("listMaSP");
	ArrayList<ChiTietPhieuNhap> listChiTietPhieuNhap = (ArrayList<ChiTietPhieuNhap>)request.getAttribute("listChiTietPhieuNhap");
	String maPhieuNhap = (String)request.getAttribute("maPhieuNhap");
	PhieuNhap phieuNhap = (PhieuNhap)request.getAttribute("phieuNhap");
	String themPhieuNhapMess = (String)request.getAttribute("themPhieuNhapMess");
	String themPhieuNhapMess1 = (String)request.getAttribute("themPhieuNhapMess1");
	int tongTien=0;
%>

	<jsp:include page="header.jsp"></jsp:include>
	<div id="wrapper">
		<jsp:include page="menu.jsp"></jsp:include>
		<div id="rightContent">
			<h3>Phiếu nhập</h3>
			<div id="phieuNhapTong">
				<div id="thongTinPhieuNhap">
					<form action="TaoPhieuNhapServlet" method="POST">
						<h4 style="text-align: center">Thông tin phiếu nhập</h4>
						<table>
							<tr>
								<td>Mã phiếu nhập</td>
								<td><input type="text" name="maphieunhap" id="maphieunhap" /></td>
							</tr>
							<tr>
								<td></td>
								<td>
									<button type="submit" value="submit" name="submit">Tạo
										phiếu nhập</button>
								</td>
							</tr>
						</table>
					</form>
				</div>
				<div id="thongTinChiTietPhieuNhap">
					<form action="TaoChiTietPhieuNhapSevlet" method="POST">
						<h4 style="text-align: center">Thông tin chi tiết phiếu nhập</h4>
					<table>
						<tr>
							<td>Mã phiếu nhập</td>
							<td><input style="color: black;background: #ccc" readonly="readonly" type="text" value="<%if(maPhieuNhap!=null){ %><%=maPhieuNhap %><%}else{ %><%=""%><%} %>" name="maphieunhap2" id="maphieunhap2" /></td>
						</tr>
						<tr>
							<td>Mã sản phẩm</td>
							<td>
								<select name="masanpham">
									<option value="">--Chọn sản phẩm--</option>
									<%
										for(SanPham item: listMaSP){
									%>									
									<option value="<%=item.getMaSP()%>"><%=item.getMaSP()%> <%=item.getTenSP()%></option>
									<%} %>									
								</select>
							</td>
						</tr>						
						<tr>
							<td>Số lượng</td>
							<td><input type="text" name="soluong" id="soluong" /></td>
						</tr>
						<tr>
							<td>Giá nhập</td>
							<td><input type="text" name="gianhap" id="gianhap" /></td>
						</tr>
						<tr>
							<td></td>
							<td>
								<button type="submit" value="submit" name="submit">Nhập hàng</button>
							</td>
						</tr>
					</table>
					</form>
				</div>
			</div>
			<div id="phieuNhapDaTao">
				<h4 style="text-align: center">Phiếu nhập</h4>
					<table>
						<tr>
							<th>Mã phiếu nhập</th>
							<th>Thời gian nhập</th>
						</tr>
						<tr>
						
							<td><%if(phieuNhap!=null){ %><%=phieuNhap.getMaPhieuNhap()%><%}else{%><%=""%><%} %></td>
							<td><%if(phieuNhap!=null){ %><%=phieuNhap.getNgayNhap()%><%}else{%><%=""%><%} %></td>
						</tr>
					</table>
			</div>
			<div id="chiTietPphieuNhapDaTao">
				<h4 style="text-align: center">Chi tiết phiếu nhập</h4>
					<table>
						<tr>
							<th>STT</th>
							<th>Mã phiếu nhập</th>
							<th>Mã sản phẩm</th>
							<th>Số lượng nhập</th>
							<th>Giá nhập</th>
							<th>Thành tiền</th>
						</tr>
						<% if(listChiTietPhieuNhap!=null){%>
							<%
							int dem=0;
							
							for(ChiTietPhieuNhap item: listChiTietPhieuNhap){
								dem++;
						%>				
						<tr>
							
							<td><%=dem %></td>
							<td><%=item.getMaPhieuNhap() %></td>
							<td><%=item.getMaSanPham() %></td>
							<td><%=item.getSoLuong() %></td>
							<td><%=item.getDonGia() %></td>
							<td><%=Integer.parseInt(item.getDonGia())*Integer.parseInt(item.getSoLuong()) %></td>
							<%tongTien=tongTien+(Integer.parseInt(item.getDonGia())*Integer.parseInt(item.getSoLuong())); %>
						</tr>
						<%} %>
						<%} %>
						
					</table>
			</div>
			<div>
				<h3>Tổng tiền: <%=tongTien %> VNĐ</h3>
			</div>
		</div>
		<div class="clear"></div>

		<jsp:include page="footer.jsp"></jsp:include>
	</div>
	<%if(themPhieuNhapMess!=null){ %>
		<script type="text/javascript">
			alert('Thêm phiếu nhập không thành công!');
		</script>
	<%}%>
	<%if(themPhieuNhapMess1!=null){ %>
		<script type="text/javascript">
			alert('Thêm phiếu nhập thành công!');
		</script>
	<%}%>
</body>
</html>
