<%-- 
    Document   : manager_sanpham
    Created on : Nov 28, 2017, 11:04:53 AM
    Author     : CỌP
--%>
<%@page import="java.text.NumberFormat"%>
<%@page import="modelclasses.*"%>
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
        <title>Cập nhật sản phẩm</title>       
        <link href="css/mos-style.css" rel='stylesheet' type='text/css' />
    </head>
    <body>
		<%
			SanPham sanPham = (SanPham) request.getAttribute("sanPham");
		%>       
        <jsp:include page="header.jsp"></jsp:include>
            <div id="wrapper">
            <jsp:include page="menu.jsp"></jsp:include> 
                <div id="rightContent">
                    <h3>Cập nhật sản phẩm</h3>                  
                    <table style="text-align: left">
                    	<tr>
                    		<td>Mã sản phẩm</td>
                    		<td ><input style="size: 250px; background: #CCC; text-align: center" readonly="readonly" type="text" value="<%=sanPham.getMaSP()%>" name="maSanPham"/></td>
                    	</tr>
                    	<tr>
                    		<td>Tên sản phẩm</td>
                    		<td><input type="text" value="<%=sanPham.getTenSP()%>" name="tenSanPham"/></td>
                    	</tr>
                    	<tr>
                    		<td>Thương hiệu</td>
                    		<td><input type="text" value="<%=sanPham.getThuongHieu()%>" name="thuongHieu"/></td>
                    	</tr>
                    	<tr>
                    		<td>Giá</td>
                    		<td><input type="text" value="<%=sanPham.getGia()%>" name="gia"/></td>
                    	</tr>
                    	<tr>
                    		<td>Thời gian bảo hành</td>
                    		<td><input type="text" value="<%=sanPham.getThoiGianBaoHanh()%>" name="thoiGianBaoHanh"/></td>
                    	</tr>
                    	<tr>
                    		<td>Ram</td>
                    		<td><input type="text" value="<%=sanPham.getRam()%>" name="ram"/></td>
                    	</tr>
                    	<tr>
                    		<td>Kích thước</td>
                    		<td><input type="text" value="<%=sanPham.getKichThuoc()%>" name="kichThuoc"/></td>
                    	</tr>
                    	<tr>
                    		<td>Màu sắc</td>
                    		<td><input type="text" value="<%=sanPham.getMauSac()%>" name="mauSac"/></td>
                    	</tr>                    	
                    	<tr>
                    		<td>Hệ điều hành</td>
                    		<td><input type="text" value="<%=sanPham.getHeDieuHanh()%>" name="heDieuHanh"/></td>
                    	</tr>
                    	<tr>
                    		<td>Chip set</td>
                    		<td><input type="text" value="<%=sanPham.getChipSet()%>" name="chipSet"/></td>
                    	</tr>
                    	<tr>
                    		<td>Camera</td>
                    		<td><input type="text" value="<%=sanPham.getCammera()%>" name="camera"/></td>
                    	</tr>
                    	<tr>
                    		<td>Bộ nhớ trong</td>
                    		<td><input type="text" value="<%=sanPham.getBoNhoTrong()%>" name="boNhoTrong"/></td>
                    	</tr>
                    	<tr>
                    		<td>Pin</td>
                    		<td><input type="text" value="<%=sanPham.getPin()%>" name="pin"/></td>
                    	</tr> 
                    	<tr>
                    		<td></td>
                    		<td>
                    			<button type="submit" value="submit" name="submit">Cập nhật</button>
                    		</td>
                    	</tr>                   	
                    </table>                    
            </div>
            <div class="clear"></div> 			
            <jsp:include page="footer.jsp"></jsp:include> 
        </div>
    </body>
</html>
