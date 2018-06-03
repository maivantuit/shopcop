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
    %>		      
        <jsp:include page="header.jsp"></jsp:include>
            <div id="wrapper">
            <jsp:include page="menu.jsp"></jsp:include>
            <form action="ThemDanhMucMoiServlet" method="POST"> 
                <div id="rightContent">
                    <h3>Thêm mới danh mục sản phẩm</h3>                  
                    <table style="text-align: left">                      	                	                    	
                    	<tr>
                    		<td>Tên danh mục</td>
                    		<td><input type="text"  name="tenDanhMuc"/></td>
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
