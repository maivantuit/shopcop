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
        <title>Thêm sản phẩm</title>       
        <link href="css/mos-style.css" rel='stylesheet' type='text/css' />
    </head>
    <body>
    <%
    	ArrayList<DanhMuc> listDanhMuc = (ArrayList<DanhMuc>) request.getAttribute("listDanhMuc");
    %>		      
        <jsp:include page="header.jsp"></jsp:include>
            <div id="wrapper">
            <jsp:include page="menu.jsp"></jsp:include>
            <form action="ThemSanPhamServlet" method="POST"> 
                <div id="rightContent">
                    <h3>Thêm mới sản phẩm</h3>                  
                    <table style="text-align: left">  
                    	<tr>
                    		<td>Danh mục</td>
                    		<td>
                    			<select name="maDanhMuc">
                                        <option selected>-- Nhà sản xuất --</option>
                                    <%
                                        for (DanhMuc dm : listDanhMuc) {
                                    %>
                                    <option value="<%= dm.getMaDMSP()%>"><%= dm.getMaDMSP()%> - <%= dm.getTenDMSP()%></option>
                                    <%}%>
                                    </select>
                    		</td>
                    	</tr>                  	
                    	<tr>
                    		<td>Tên sản phẩm</td>
                    		<td><input type="text"  name="tenSanPham"/></td>
                    	</tr>
                    	<tr>
                    		<td>Thương hiệu</td>
                    		<td><input type="text"  name="thuongHieu"/></td>
                    	</tr>
                    	<tr>
                    		<td>Giá</td>
                    		<td><input type="text"  name="gia"/></td>
                    	</tr>                    	
                    	<tr>
                    		<td>Thời gian bảo hành</td>
                    		<td><input type="text"  name="thoiGianBaoHanh"/></td>
                    	</tr>
                    	<tr>
                    		<td>Ram</td>
                    		<td><input type="text"  name="ram"/></td>
                    	</tr>
                    	<tr>
                    		<td>Kích thước</td>
                    		<td><input type="text"  name="kichThuoc"/></td>
                    	</tr>
                    	<tr>
                    		<td>Màu sắc</td>
                    		<td><input type="text"  name="mauSac"/></td>
                    	</tr>                    	
                    	<tr>
                    		<td>Hệ điều hành</td>
                    		<td><input type="text"  name="heDieuHanh"/></td>
                    	</tr>
                    	<tr>
                    		<td>Chip set</td>
                    		<td><input type="text"  name="chipSet"/></td>
                    	</tr>
                    	<tr>
                    		<td>Camera</td>
                    		<td><input type="text" name="camera"/></td>
                    	</tr>
                    	<tr>
                    		<td>Bộ nhớ trong</td>
                    		<td><input type="text"  name="boNhoTrong"/></td>
                    	</tr>
                    	<tr>
                    		<td>Pin</td>
                    		<td><input type="text"  name="pin"/></td>
                    	</tr> 
                    	<tr>
                    		<td></td>
                    		<td>
                    			<button type="submit" value="submit" name="submit">Thêm</button>
                    		</td>
                    	</tr>                   	
                    </table>                    
            </div>
            </form>
            <div class="clear"></div> 			
            <jsp:include page="footer.jsp"></jsp:include> 
        </div>        
    </body>
</html>
