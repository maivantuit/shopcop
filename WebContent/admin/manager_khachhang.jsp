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
        <title>Quản lý khách hàng</title>
        
        <link href="../css/mos-style.css" rel='stylesheet' type='text/css' />
    </head>
    <body>
        <%
            KhachHangDao khachhangdao = new KhachHangDao();
            ArrayList<KhachHang> listkhachhang = khachhangdao.getListKhachHang();
            ArrayList<NguoiGiaoHang> listNguoiGiaoHang= (ArrayList<NguoiGiaoHang>)request.getAttribute("listNguoiGiaoHang");
            
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
                            <th class="data" >Mã khách hàng</th>
                            <th class="data" >Tên khách hàng</th>                                                      
                            <th class="data">Ngày sinh</th> 
                            <th class="data" width="200px">Địa chỉ</th>     
                            <th class="data" width="50px">Email</th>  
                            <th class="data">Điện thoại</th>    
                            <th class="data" width="90px">Chức năng</th>
                        </tr>
                    <%
                        int dem=0;
                        for (KhachHang elementskhachhang : listkhachhang) {
                            dem++;                        
                    %>                                                                            
                        <tr class="data">
                            <td class="data" width="30px"><%= dem%></td>
                            <td class="data"><%= elementskhachhang.getMaKH()%></td>
                            <td class="data"><%= elementskhachhang.getTenKH()%></td>                               
                            <td class="data"><%= elementskhachhang.getNgaySinh()%></td> 
                            <td class="data" width="100px" ><%= elementskhachhang.getDiaChi()%></td> 
                            <td class="data"><%= elementskhachhang.getEmail()%></td> 
                            <td class="data"><%= elementskhachhang.getSdt()%></td> 
                            <td class="data" width="90px">
                                <center>
                                    <a href="/doancntt/admin/update_danhmuc.jsp?command=updateurl&MaDMSPurl=<%= elementskhachhang.getMaKH()%>">Sửa</a>&nbsp;&nbsp; | &nbsp;&nbsp;
                                    <a href="/doancntt/QuanLyDanhMucServlet?command=deleteurl&MaDMSPurl=<%= elementskhachhang.getMaKH()%>">Xóa</a>
                                </center>
                            </td>
                        </tr>     
                     <%}%>   
                        
                    </table>
                </div>
                <div class="clear"></div> 

            <jsp:include page="footer.jsp"></jsp:include> 
        </div>
    </body>
</html>
