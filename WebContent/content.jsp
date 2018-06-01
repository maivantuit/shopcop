<%@page import="java.text.NumberFormat"%>
<%@page import="modelclasses.HoaDon"%>
<%@page import="dao.KhachHangDao"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dao.HoaDonDAO"%>
<%@page import="dao.SanPhamDAO"%>
<%@page import="dao.ChiTietHoaDonDAO"%>
<%@page import="java.util.Map"%>
<%@page import="modelclasses.Item"%>
<%@page import="modelclasses.KhachHang"%>
<%@page import="modelclasses.SanPham"%>
<%-- 
    Document   : content
    Created on : Oct 25, 2017, 9:56:19 PM
    Author     : CỌP
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>content</title>
</head>
<body>
	<%
		ArrayList<SanPham> listSanPham =  (ArrayList<SanPham>)request.getAttribute("listSanPham");
	%>
	<!---->
	<div class="container">
		<div class="content">
			<div id="quangcao1">
				<div id="quangcao1a">
					<img src="images/quangcao1a.png" />
				</div>
				<div id="quangcao1b">
					<img src="images/quangcao1b.png" />
				</div>
			</div>
			<div class="content-top">
				<h3 class="future">SẢN PHẨM MỚI NHẤT</h3>
				<div id="site-wrapper">
					<ul class="products homepage">
						<%
							for(SanPham item : listSanPham){
						%>
						<li class="preorder"><span class="tagimg "></span> 
							<a href="single.jsp?maSP=<%= item.getMaSP()%>"> 
								<img src="<%=item.getHinhAnh() %>" width=" 250px" height="250px" />
								<div class="thongtinchitiet">
									<h3></h3>
									<h4 href="single.jsp?maSP=<%= item.getMaSP()%>">                                             
                                            <%= item.getTenSP()%>
                                            Giá:<%= NumberFormat.getInstance().format(item.getGia())%>                                           
                                    </h4> 
									<span class="textkm">Khuyến mãi trị giá đến <strong>500.000₫</strong>
									</span>
								</div>
								<p class="info">
									<span>Màn hình: QuadHD, 5.1'</span> 
									<span>HĐH: Android 4.4 (KitKat)</span> 
									<span>CPU: 4 nhân 2.7GHz</span> 
									<span>Camera: 16M</span> 
									<span>Dung lượng pin: 3000mAh</span>
								</p>
							</a>
							<div class="muangay" style="color: blue">
                                    <a href="GioHangServlet?command=plus&maSP=<%= item.getMaSP()%>">                                        
                                    Đặt hàng                                
                                    </a>
           					</div> 
							
						</li>
						<%} %>
					</ul>
				</div>				
					<script type="text/javascript">
						$(window).load(function() {
							$("#flexiselDemo2").flexisel({
								visibleItems : 4,
								animationSpeed : 1000,
								autoPlay : true,
								autoPlaySpeed : 3000,
								pauseOnHover : true,
								enableResponsiveBreakpoints : true,
								responsiveBreakpoints : {
									portrait : {
										changePoint : 480,
										visibleItems : 1
									},
									landscape : {
										changePoint : 640,
										visibleItems : 2
									},
									tablet : {
										changePoint : 768,
										visibleItems : 3
									}
								}
							});

						});
					</script>
				</div>
			</div>
			<ul class="start">
				<li><a href="#"><i></i></a></li>
				<li><span>1</span></li>
				<li class="arrow"><a href="#">2</a></li>
				<li class="arrow"><a href="#">3</a></li>
				<li class="arrow"><a href="#">4</a></li>
				<li class="arrow"><a href="#">5</a></li>
				<li><a href="#"><i class="next"> </i></a></li>
			</ul>
		</div>
	</div>
</body>
</html>
