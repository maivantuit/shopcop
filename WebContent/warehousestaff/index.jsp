<%-- 
    Document   : index
    Created on : Nov 28, 2017, 9:50:46 AM
    Author     : CỌP
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="modelclasses.*"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Warehousestaff</title>        
        <link href="css/mos-style.css" rel='stylesheet' type='text/css' />
        
    </head>
    <body>
    <%
    HttpSession sesstion = request.getSession();
    NhanVien nhanVienKhoInstace = (NhanVien)sesstion.getAttribute("nhanVienKhoInstace");
    %>
    <%
    	if(nhanVienKhoInstace!=null){
    %>
        <jsp:include page="header.jsp"></jsp:include>
            <div id="wrapper">
            <jsp:include page="menu.jsp"></jsp:include> 
            <jsp:include page="content.jsp"></jsp:include> 
            <jsp:include page="footer.jsp"></jsp:include> 
        </div>
        <%}else{%>
       	<h1>Vui lòng <a href="/doancntt/DangNhapNhanVienKhoServlet">đăng nhập</a>!</h1>
       <%} %>
    </body>
</html>
