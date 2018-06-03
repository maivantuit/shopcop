<%-- 
    Document   : insert_danhmuc
    Created on : Nov 28, 2017, 4:31:53 PM
    Author     : CỌP
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="modelclasses.DanhMuc"%>
<%@page import="modelclasses.DanhMuc"%>
<%@page import="dao.DanhMucDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cập nhật danh mục</title>

        
        <link href="css/mos-style.css" rel='stylesheet' type='text/css' />

    </head>
    <body>
        <%
           
            DanhMuc danhmuc = (DanhMuc)request.getAttribute("danhmuc");
        %>
        <jsp:include page="header.jsp"></jsp:include>
            <div id="wrapper">

            <jsp:include page="menu.jsp"></jsp:include>                             

                <div id="rightContent">
                    <h3>Cập nhật danh mục</h3>
                    <form action="/doancntt/CapNhatDanhMucServlet" method="POST">
                        <table width="95%">                        
                            <tr>
                                <td><b>Tên danh mục</b></td>
                                <td><input type="text" class="tenDanhMuc" value="<%=danhmuc.getTenDMSP() %>" name="tendanhmuc"></td>
                            </tr>                                                                           
                        <tr>
                            <td></td>
                            <td>
                                <button type="submit" value="submit" name="submit">Cập nhật</button>                                                               
                            </td>
                        </tr>
                    </table>
                </form>
            </div>   


            <div class="clear"></div> 

            <jsp:include page="footer.jsp"></jsp:include> 
        </div>
    </body>
</html>
