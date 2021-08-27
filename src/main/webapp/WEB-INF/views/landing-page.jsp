<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Home</title><meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Reference Bootstrap files -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>

    <script	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<nav class="navbar navbar-dark bg-dark">
    <a class="navbar-brand px-2" href="#">United Bank</a>
    <ul class="nav navbar-nav me-auto">
        <li class="nav-item">
            <a class="nav-link" href="${pageContext.request.contextPath}/deposit">Deposit</a>
        </li>
    </ul>
    <ul class="nav navbar-nav ms-auto">
        <li class="nav-item px-2">
            <form:form action="${pageContext.request.contextPath}/authenticate" method="post" cssClass="form-inline my-2 my-lg-0">
                <input type="submit" value="Logout" class="btn btn-outline-light">
            </form:form>
        </li>
    </ul>
</nav>
<div class="card w-50 px-2" >
    <div class="card-body">
        <h5 class="card-title">Current Balance: $${balance}</h5>
    </div>
</div>

</body>
</html>
