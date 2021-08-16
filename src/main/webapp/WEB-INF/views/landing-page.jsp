<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Home</title>
</head>
<body>
  <h1>DEMO - Landing Page</h1>
    <form:form action="${pageContext.request.contextPath}/authenticate" method="post">
        <input type="submit" value="Logout">

    </form:form>
</body>
</html>
