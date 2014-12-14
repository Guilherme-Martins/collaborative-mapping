<%-- 
    Document   : statisticsIndex
    Created on : 13/12/2014, 17:43:04
    Author     : Guilherme Martins
--%>

<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Collaborative Mapping</title>
    </head>
    <body>
        <div align=center>
            <h1>Collaborative Mapping - Statistics</h1>
            <BR>
            <form action='statisticsValidity.jsp' method="POST">
                <table border="0" align="center">
                    <tr>
                        <td><b>Name Mapping File:</b></td>
                        <td><input type="text" name="fileMappingName" size="20" /></td>
                    </tr>
                    <tr><td>OR</td><td>&nbsp;</td></tr>
                    <tr>
                        <td><b>ID Mapping File:</b></td> 
                        <td><input type="text" name="fileMappingID" size="20" /></td>
                    </tr>
                    <tr><td>&nbsp;</td><td>&nbsp;</td></tr>
                    <tr>
                        <td><input type="submit" value="Generate Statistics" /></td>
                    </tr>
                </table>
            </form>
            
            <p><a href="index2.jsp">Collaborative Mapping - Homepage</a></p>
        </div>
    </body>
