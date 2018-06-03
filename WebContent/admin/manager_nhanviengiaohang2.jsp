<%-- 
    Document   : manager_sanpham
    Created on : Nov 28, 2017, 11:04:53 AM
    Author     : CỌP
--%>

<%@page import="modelclasses.*"%>
<%@page import="dao.KhachHangDao"%>
<%@page import="java.util.ArrayList"%>
<%@page import="modelclasses.SanPham"%>
<%@page import="dao.SanPhamDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Quản lý nhân viên giao hàng</title>        
        <link href="css/mos-style.css" rel='stylesheet' type='text/css' />
    </head>
    <body>
        <%
            
            ArrayList<NhanVien> listNhanVienKho =(ArrayList<NhanVien>) request.getAttribute("listNhanVienKho");
           
        %>
        
        
        <jsp:include page="header.jsp"></jsp:include>
            <div id="wrapper">
            <jsp:include page="menu.jsp"></jsp:include> 
                <div id="rightContent">
                    <h3>Quản lý khách hàng</h3>                           
                    <a href="insert_danhmuc.jsp">Thêm khách hàng mới</a>                    
                    <table class="data">
                        <tr class="data">
                            <th class="data" width="30px">STT</th>
                            <th class="data" >Mã nhân viên</th>
                            <th class="data" >Tên nhân viên</th>                                                      
                            <th class="data">Địa chỉ</th> 
                            <th class="data" width="200px">Số điện thoại</th>     
                            <th class="data" width="50px">Email</th>                          
                            
                        </tr>
                    <%
                        int dem=0;
                        for (NhanVien elementskhachhang : listNhanVienKho) {
                            dem++;                        
                    %>                                                                            
                        <tr class="data">
                            <td class="data" width="30px"><%= dem%></td>
                            <td class="data"><%= elementskhachhang.getMaNV()%></td>
                            <td class="data"><%= elementskhachhang.getTenNV()%></td>                               
                            <td class="data"><%= elementskhachhang.getDiaChi()%></td> 
                            <td class="data" width="100px" ><%= elementskhachhang.getSdt()%></td> 
                            <td class="data"><%= elementskhachhang.getEmail()%></td>                             
                            
                        </tr>     
                     <%}%>   
                        
                    </table>
                </div>
                <div class="clear"></div> 

            <jsp:include page="footer.jsp"></jsp:include> 
        </div>
    </body>
</html>
