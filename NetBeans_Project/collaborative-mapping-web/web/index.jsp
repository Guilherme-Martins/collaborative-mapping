<%-- 
    Document   : index
    Created on : 14/10/2014, 10:25:24
    Author     : Guilherme Martins
--%>


<%@page import="br.ufjf.mapping.memory.FileDB"%>
<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Collaborative Mapping</title>
    </head>
    <body>
        <h1>Collaborative Mapping - Login</h1>
        <BR>
        
        <%
            FileDB fdb = new FileDB();
        %>
        
        <%
            int idUser = -1;
            String login;
            String password;
            
            if(request.getParameter("login") != null){
                login = request.getParameter("login");
            } else {
                login = "";
            }
            
            if(request.getParameter("password") != null){
                password = request.getParameter("password");
            } else {
                password = "";
            }
            
            if((session.getAttribute("idUser") != null) && (idUser != -1)){
                idUser = (int) session.getAttribute("idUser");
            } else {
                idUser = fdb.getReadDB().authenticationUser(login, password);
                session.setAttribute("idUser", idUser);
            }
            
            /*
            out.println("Sessão idUser: "+session.getAttribute("idUser")+"<BR>");
            out.println("Request Login: "+request.getParameter("login")+"<BR>");
            out.println("Request Password: "+request.getParameter("password")+"<BR>");
            out.println("DB Autenticação: "+fdb.getReadDB().authenticationUser(login, password)+"<BR><BR>");
            //request.getParameter("comment_"+pair.getIdPair())
            */
            
            if(idUser == -1){
        %>
                <form name="form1" action='index.jsp' method="POST">
                    Login: <input type="text" name="login" size="30" /> <BR>
                    Password: <input type="text" name="password" size="30" /> <BR>
                    <input type="submit" value="Sign-In" />
                </form>
        <%
            } else {
        %> 
                <p>Hello <%out.println(login);%></p>
                <p>Click the link below to access the application</p>
                <p><a href="index2.jsp">Access Application</a></p>
        <%
            }
            //session.setAttribute("idUser", -1);
        %>
        
    </body>
</html>
