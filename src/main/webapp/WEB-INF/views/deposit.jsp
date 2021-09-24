<%--
  Created by IntelliJ IDEA.
  User: bobwe
  Date: 8/26/2021
  Time: 9:27 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Deposit</title>
    <meta charset="utf-8">
    <!-- Reference Bootstrap files -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>

    <script	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<nav class="navbar navbar-dark bg-dark">
    <a class="navbar-brand px-2" href="${pageContext.request.contextPath}/home">United Bank</a>
    <ul class="nav navbar-nav ms-auto">
        <li class="nav-item px-2">
            <form:form action="${pageContext.request.contextPath}/authenticate" method="post" cssClass="form-inline my-2 my-lg-0">
                <input type="submit" value="Logout" class="btn btn-outline-light">
            </form:form>
        </li>
    </ul>
</nav>
<h5 class="card-title px-2" style="margin-top: 10px">Current Balance: $${account.balance}</h5>
<br>
<b class="px-2">Input your deposit:</b>
<div class="mainbox col-md-3 col-md-offset-2 col-sm-6 col-sm-offset-2">
    <form:form method="post" action="${pageContext.request.contextPath}/deposit/auth" modelAttribute="account">
    <div style="margin-bottom: 25px" class="input-group px-2">
        <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
        <form:input name="amount" placeholder="0.00" class="form-control" path="balance"/>
    </div><input type="submit" value="Deposit" class="btn btn-outline-dark px-2 ms-2">
    </form:form>
</div>

</body>
</html>
