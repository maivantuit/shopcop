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
        <title>Quản lý danh mục</title>       
        

    </head>
    <body>
        <%
            DanhMucDAO danhmucdao = new DanhMucDAO();
            ArrayList<DanhMuc> listdanhmuc = danhmucdao.getListDanhMuc();
        %>
        <jsp:include page="header.jsp"></jsp:include>
            <div id="wrapper">

            <jsp:include page="menu.jsp"></jsp:include>                             

                <div id="rightContent">
                    <h3>Quản lý danh mục</h3>
                    <form action="/doancntt/QuanLyDanhMucServlet" method="POST">
                        <table width="95%">                        
                            <tr>
                                <td><b>Tên danh mục</b></td>
                                <td><input type="text" class="panjang" name="tendanhmuc"></td>
                            </tr>                        
                            <tr>
                                <td><b>Nhà Sản Xuất</b></td>
                                <td>
                                    <select name="manhasanxuat">
                                        <option selected>-- Nhà sản xuất --</option>
                                    <%
                                        for (DanhMuc dm : listdanhmuc) {
                                    %>
                                    <option value="<%= dm.getMaNSX()%>"><%= dm.getMaNSX()%> - <%= dm.getTenDMSP()%></option>
                                    <%}%>
                                    </select>
                                </td>
                            </tr>                        
                        <tr>
                            <td></td>
                            <td>
                                <input type="hidden" name="command" value="themdanhmucmoi">
                                <input type="submit" class="button" value="Lưu">                                                                
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
