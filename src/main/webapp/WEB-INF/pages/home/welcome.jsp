<%@include file="/WEB-INF/pages/includedTags.jsp" %>

Welcome ${username},<br>

<br/>
<sec:authorize access="hasRole('ROLE_SUPER_ADMIN')">
<a href="admin">Admin Module</a><br/>
<a href="user">User Module</a><br/>
<a href="superadmin">Super Admin Module</a>
</sec:authorize>
<sec:authorize access="hasRole('ROLE_ADMIN')">
<a href="admin">Admin Module</a><br/>
<a href="user">User Module</a><br/>
<a href="superadmin">Super Admin Module</a>
</sec:authorize>
<sec:authorize access="hasRole('ROLE_USER')">
<a href="admin">Admin Module</a><br/>
<a href="user">User Module</a><br/>
<a href="superadmin">Super Admin Module</a>
</sec:authorize>



<br/><br/>
<c:url var="logoutUrl" value="/j_spring_security_logout" />
<form action="${logoutUrl}" id="logout" method="post">
    <input type="hidden" name="${_csrf.parameterName}"
           value="${_csrf.token}" />
</form>
<a href="#" onclick="document.getElementById('logout').submit();">Logout</a>


