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
        <title>Nhân viên giao hàng</title>        
        <link href="css/mos-style.css" rel='stylesheet' type='text/css' />
        
    </head>
    <body>
    <%    
    HttpSession sesstion = request.getSession();
    NhanVien nhanVienKhoGiaoHang = (NhanVien)sesstion.getAttribute("nhanVienKhoGiaoHang");
    %>
    <%
        String mes = (String)request.getAttribute("mes");
        %>
    <%
    	if(nhanVienKhoGiaoHang!=null){
    %>
        <jsp:include page="header.jsp"></jsp:include>
            <div id="wrapper">
            <jsp:include page="menu.jsp"></jsp:include> 
            <jsp:include page="content.jsp"></jsp:include> 
            <jsp:include page="footer.jsp"></jsp:include> 
        </div>
        <%}else{%>
       	<h1>Vui lòng <a href="/doancntt/DangNhapNhanVienGiaoHangServlet">đăng nhập</a>!</h1>
       <%} %>
   <%
        	if(mes!=null){
        %>
        	<script type="text/javascript">
        		alert('Đăng nhập thất bại!');
        	</script>
        <%} %> 
    </body>
</html>
