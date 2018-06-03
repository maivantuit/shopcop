<%-- 
    Document   : header
    Created on : Nov 28, 2017, 9:50:14 AM
    Author     : CỌP
--%>
<%@page import="modelclasses.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>header-admin</title>
    </head>
    <body>
    <%
    HttpSession sesstion = request.getSession();
	NhanVien nhanVien =(NhanVien)sesstion.getAttribute("nhanVienKhoGiaoHang");
    %>
        <div id="header">
            <div class="inHeader">
                <div class="mosAdmin">
                    Xin chào, <%if(nhanVien!=null){%><%=nhanVien.getTenNV()%><%}else{%><%=""%><%}%><br>
                    <a href="">Trang nhân viên giao hàng</a> | <a href="">Giúp đỡ</a> | <a href="/doancntt/DangXuatNhanVienGiaoHangServlet">Đăng xuất</a>
                </div>
                <div class="clear"></div>
            </div>
        </div>
        
    </body>
</html>
