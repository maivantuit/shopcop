<%-- 
    Document   : checkout
    Created on : Nov 27, 2017, 10:18:08 AM
    Author     : CỌP
--%>
<%@page import="java.text.NumberFormat"%>
<%@page import="java.util.Map"%>
<%@page import="modelclasses.Item"%>
<%@page import="modelclasses.GioHang"%>
<%@page import="modelclasses.ChiTietHoaDon"%>
<%@page import="dao.SanPhamDAO"%>
<%@page import="dao.ChiTietHoaDonDAO"%>
<%@page import="modelclasses.KhachHang"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>check out</title>
<link href="css/bootstrap.css" rel="stylesheet" type="text/css"
	media="all" />
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="js/jquery.min.js"></script>
<!-- Custom Theme files -->
<!--theme-style-->
<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
<!--//theme-style-->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords"
	content="Bonfire Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template, 
              Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
<script type="application/x-javascript">
	

	 addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } 

</script>
<!--fonts-->
<link
	href='http://fonts.googleapis.com/css?family=Exo:100,200,300,400,500,600,700,800,900'
	rel='stylesheet' type='text/css'>
<!--//fonts-->
<script type="text/javascript" src="js/move-top.js"></script>
<script type="text/javascript" src="js/easing.js"></script>
<script type="text/javascript">
	jQuery(document).ready(function($) {
		$(".scroll").click(function(event) {
			event.preventDefault();
			$('html,body').animate({
				scrollTop : $(this.hash).offset().top
			}, 1000);
		});
	});
</script>
<!--slider-script-->
<script src="js/responsiveslides.min.js"></script>
<script>
	$(function() {
		$("#slider1").responsiveSlides({
			auto : true,
			speed : 500,
			namespace : "callbacks",
			pager : true,
		});
	});
</script>
<!--//slider-script-->
<script>
	$(document).ready(function(c) {
		$('.alert-close').on('click', function(c) {
			$('.message').fadeOut('slow', function(c) {
				$('.message').remove();
			});
		});
	});
</script>
<script>
	$(document).ready(function(c) {
		$('.alert-close1').on('click', function(c) {
			$('.message1').fadeOut('slow', function(c) {
				$('.message1').remove();
			});
		});
	});
</script>
</head>
<body>
	<%
				String soLuongTang = (String)request.getAttribute("soLuongTang");
	String soLuongGiam = (String)request.getAttribute("soLuongGiam");
						request.setCharacterEncoding("utf-8");
			            response.setCharacterEncoding("utf-8");
			            KhachHang khachhang = (KhachHang) session.getAttribute("user");
			            if (khachhang == null) { // chưa login, thì chuyển đến trang login mới đặt hàng được
			                response.sendRedirect("/doancntt/login.jsp");
			            }			            
	%>
	<%
						ChiTietHoaDonDAO chitiethoadondao = new ChiTietHoaDonDAO();
			            String madonhang = "";
			            if (request.getParameter("madh") != null) { // từ link url
			                madonhang = request.getParameter("madh");
			            }

			            SanPhamDAO sanphamdao = new SanPhamDAO();
			            GioHang giohang = (GioHang) session.getAttribute("giohang"); // get tu cho no set
			            if (giohang == null) {
			                giohang = new GioHang();
			                session.setAttribute("giohang", giohang);
			            }
	%>

	<%-- Theo thứ tự --%>
	<jsp:include page="header.jsp"></jsp:include>
	<div class="account">
		<h2 class="account-in">Check out</h2>
		<form action="HoaDonDatHangServlet" method="POST">
			<div id="thongtinkhachhangkhidathang">
				<legend>Thông tin sản phẩm </legend>
				<table class="data">
					<tr class="data">
						<th class="data" width="30px">STT</th>
						<th class="data">Hình ảnh</th>
						<th class="data">Tên sản phẩm</th>
						<th class="data">Số lượng</th>
						<th class="data" width="90px">Chức năng</th>
					</tr>
					<%
						int dem = 0;				                           
									for (Map.Entry<Long, Item> list : giohang.getGiohangItems().entrySet()) {
										dem++;
					%>
					<tr class="data">
						<td class="data" width="30px"><%=dem%></td>
						<td class="data"><img
							src="images/iphone-6-plus-64gb128gb-nowatermark-190x190.jpg"
							width=" 50px" height="50px" /> <!-- có thể get thuộc tính hình ảnh tại đây.--></td>
						<td class="data"><h4><%=list.getValue().getSanPham().getTenSP()%></h4></td>
						<td class="data"><a
							href="GioHangServlet?command=bot&maSP=<%=list.getValue().getSanPham().getMaSP()%>">
								－ </a> <%=list.getValue().getSoLuong()%> <a
							href="GioHangServlet?command=plus&maSP=<%=list.getValue().getSanPham().getMaSP()%>">
								＋ </a></td>
						<td class="data" width="90px">
							<center>
								<a
									href="GioHangServlet?command=remove&maSP=<%=list.getValue().getSanPham().getMaSP()%>">Xóa</a>
							</center>
						</td>
					</tr>
					<%
						}
					%>
				</table>
			</div>
			<div class="total">
				<div class="total_left" style="color: black">TỔNG TIỀN :</div>
				<div class="" style="color: black"><%=NumberFormat.getInstance().format(giohang.TinhTongTienTrongGioHang())%>
					VNĐ
				</div>
				<div class="clearfix"></div>
			</div>
			<div id="thongtinkhachhangkhidathang">
				<div id="thongTinGiaoHangKhachHang">
					<legend>Thông tin khách hàng</legend>
					Gửi cho chính mình:<input type="radio" checked="checked" value="0"
						name="checkKhachHang">
					<table>
						<tr>
							<td><span>Họ và tên:</span></td>
							<td><input style="background: #333; color: white"
								readonly="readonly" size="80" type="text" name="hoten"
								value="<%if (session.getAttribute("user") != null) {%><%=khachhang.getTenKH()%><%}%>"></td>
						</tr>
						<tr>
							<td><span>Điện thoại di động:</span></td>
							<td><input style="background: #333; color: white"
								readonly="readonly" size="80" type="text" name="sodienthoai"
								value="<%if (session.getAttribute("user") != null) {%><%=khachhang.getSdt()%><%}%>"></td>
						</tr>
						<tr>
							<td><span>Địa chỉ</span></td>
							<td><input style="background: #333; color: white"
								readonly="readonly" size="80" type="text" name="diachi"
								value="<%if (session.getAttribute("user") != null) {%><%=khachhang.getDiaChi()%><%}%>"></td>
						</tr>
					</table>
				</div>
				<div id="thongTinGiaoHangNguoiNhanKhac">
					<legend>Thông tin người nhận khác</legend>
					Gửi cho người khác:<input size="10" type="radio" value="1"
						name="checkKhachHang">
					<table>
						<tr>
							<td><span>Họ và tên:</span></td>
							<td><input size="80" type="text" name="hoTenNguoiNhanKhac"></td>
						</tr>
						<tr>
							<td><span>Điện thoại di động:</span></td>
							<td><input size="80" type="text"
								name="sodienthoaiNguoiNhanKhac"></td>
						</tr>
						<tr>
							<td><span>Địa chỉ</span></td>
							<td><input size="80" type="text" name="diachiNguoiNhanKhac"></td>
						</tr>
					</table>
				</div>

			</div>
			<div id="thongtinkhachhangkhidathang">
				<input type="submit" value="Đặt hàng">
			</div>

		</form>
	</div>
	<%
		if(soLuongGiam!=null){
		%>
		<script type="text/javascript">
			alert('Vui lòng chọn nhiều hơn 1 sản phẩm!');
		</script>
			
		<%} %>
		<%
		if(soLuongTang!=null){
		%>
		<script type="text/javascript">
			alert('Vượt qua số sản phẩm hiện tại!');
		</script>
			
		<%} %>


	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
