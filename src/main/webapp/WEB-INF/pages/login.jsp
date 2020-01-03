<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
    <head>
        <title>
            Login
        </title>
    </head>
    <body>
         
        <h3>Login Page</h3>
	<s:if test="%{#parameters.error != null}">
		Invalid username or password!
	</s:if>
	<s:if test="%{#parameters.logout != null}">
		Logout successfully
	</s:if>
        <c:url var="loginUrl" value="/login"/>
        <form action="${loginUrl}" method="post">
            <input type="text" name="username" placeholder="Username"/><br/>
            <input type="password" name="password"  placeholder="Password"/><br/>
            <input type="hidden" name="${_csrf.parameterName}"  value="${_csrf.token}" /><br>
            <button type="submit">Process</button>
        </form>
    </body>
</html>