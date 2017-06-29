<html>
<body>
<h2>Hello World!</h2>


<%
    com.jk.pojo.SessionInfo sessionInfo=(com.jk.pojo.SessionInfo) session.getAttribute("sessionInfo");
    if(sessionInfo!=null){//session中有值  登陆成功
        response.sendRedirect(request.getContextPath()+"/main/main.do");
    }else{
        response.sendRedirect(request.getContextPath()+"/login.do");
    }
%>
</body>
</html>
