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
        <h1 align=center>Collaborative Mapping - Login</h1>
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
            out.println("Sess�o idUser: "+session.getAttribute("idUser")+"<BR>");
            out.println("Request Login: "+request.getParameter("login")+"<BR>");
            out.println("Request Password: "+request.getParameter("password")+"<BR>");
            out.println("DB Autentica��o: "+fdb.getReadDB().authenticationUser(login, password)+"<BR><BR>");
            //request.getParameter("comment_"+pair.getIdPair())
            */
            
            if(idUser == -1){
        %>
                <form name="form1" action='index.jsp' method="POST">
                    <table border="0" align="center">
                        <tr>
                            <td><b>Login:</b></td>
                            <td><input type="text" name="login" size="20" /></td>
                        </tr>
                        <tr>
                            <td><b>Password:</b></td> 
                            <td><input type="password" name="password" size="20" /></td>
                        </tr>
                        <tr><td>&nbsp;</td><td>&nbsp;</td></tr>
                        <tr>
                            <td><input type="submit" value="Sign-In" /></td>
                        </tr>
                    </table>
                </form>
        <%
            } else {
                // New location to be redirected
                String site = new String("index2.jsp");
                response.setStatus(response.SC_MOVED_TEMPORARILY);
                response.setHeader("Location", site);
            }
            //session.setAttribute("idUser", -1);
        %>
        
    </body>
</html>
