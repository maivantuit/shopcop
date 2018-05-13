<%-- 
    Document   : login
    Created on : Oct 26, 2017, 9:21:30 AM
    Author     : CỌP
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>login</title>
    </head>
    <body>
    
        <%-- Theo thứ tự --%>
        <jsp:include page="header.jsp"></jsp:include>       
            <div class="account">
                <h2 class="account-in">Login</h2>
                <form action="KhachHangServlet" method="POST">
                    <% if(request.getParameter("error")!=null){%>
                    <div>
                        <p style="color:red"><%= request.getParameter("error") %></p>
                    </div> 
                    <%}%>
                    <div>
                        <span>Username</span>
                        <input type="text" name="email">
                    </div> 	                        
                    <div> 
                        <span class="word">Password*</span>
                        <input type="password" name="pass">
                    </div>
                    <input type="hidden" value="login" name="command">
                    <input type="submit" value="Login"> 
                </form>
            </div>
        <jsp:include page="footer.jsp"></jsp:include>
    </body>
</html>
