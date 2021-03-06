<%-- 
    Document   : manager_sanpham
    Created on : Nov 28, 2017, 11:04:53 AM
    Author     : CỌP
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="modelclasses.SanPham"%>
<%@page import="dao.SanPhamDAO"%>
<%@page import="java.text.NumberFormat"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Manager-sanpham</title>
        
        <link href="css/mos-style.css" rel='stylesheet' type='text/css' />
    </head>
    <body>
        <%
        ArrayList<SanPham> listsanpham = (ArrayList<SanPham>)request.getAttribute("listsanpham");
        String mesXoa = (String)request.getAttribute("mesXoa");
        String mesTC = (String)request.getAttribute("mesTC");
        String mesTB = (String)request.getAttribute("mesTB");
        %>                
        <jsp:include page="header.jsp"></jsp:include>
            <div id="wrapper">
            <jsp:include page="menu.jsp"></jsp:include> 
                <div id="rightContent">
                    <h3>Quản lý sản phẩm</h3>                           
                    <a href="/doancntt/ThemSanPhamServlet">Thêm sản phẩm mới</a>
                    
                    <table class="data">
                        <tr class="data">
                            <th class="data" width="30px">STT</th>                           
                            <th class="data" >Mã sản phẩm</th>
                            <th class="data">Tên sản phẩm</th>                            
                            <th class="data">Thương hiệu</th> 
                             <th class="data">Số lượng</th> 
                            <th class="data">Giá(VNĐ)</th>     
                            <th class="data" width="90px">Chức năng</th>
                        </tr>
                    <%
                        int dem=0;
                        for (SanPham elementssanpham : listsanpham) {
                            dem++;                        
                    %>                                                                            
                        <tr class="data">
                            <td class="data" width="30px"><%= dem%></td>
                         
                            <td class="data"><%= elementssanpham.getMaSP()%></td>   
                            <td class="data"><%= elementssanpham.getTenSP()%></td> 
                            <td class="data"><%= elementssanpham.getThuongHieu()%></td> 
                             <td class="data" style="background: #e4caca;text-align: center"><%= elementssanpham.getSoLuong()%></td> 
                            <td class="data"><%= NumberFormat.getInstance().format(elementssanpham.getGia())%></td> 
                            <td class="data" width="150px">
                                <center>
                                    <a href="SuaSanPhamServlet?MaSPurl=<%= elementssanpham.getMaSP()%>">Sửa</a>&nbsp;&nbsp; | &nbsp;&nbsp;                                    
                                    <a href="XoaSanPhamServlet?maSPurl=<%= elementssanpham.getMaSP()%>">Xóa</a>
                                </center>
                            </td>
                        </tr>     
                     <%}%>   
                        
                    </table>
                </div>
                <div class="clear"></div> 
			
            <jsp:include page="footer.jsp"></jsp:include> 
        </div>
        <%
			if(mesXoa!=null){
		%>
			<script type="text/javascript">
				alert('Xóa sản phẩm thành công!');
			</script>
		<%
			}
		%>
		 <%
			if(mesTC!=null){
		%>
			<script type="text/javascript">
				alert('Thêm sản phẩm thành công!');
			</script>
		<%
			}
		%>
		 <%
			if(mesTB!=null){
		%>
			<script type="text/javascript">
				alert('Thêm sản phẩm thất bại!');
			</script>
		<%
			}
		%>
    </body>
</html>
