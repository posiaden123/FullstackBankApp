<%--
  Created by IntelliJ IDEA.
  User: bobwe
  Date: 8/17/2021
  Time: 8:35 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Sign-Up</title><meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Reference Bootstrap files -->
    <link rel="stylesheet"
          href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet"
    href="${pageContext.request.contextPath}/resources/css/error.css" type="text/css">

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>

    <script	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</head>
<body>
<div>
    <div id="loginbox" style="margin-top: 50px;"
         class="mainbox col-md-3 col-md-offset-2 col-sm-6 col-sm-offset-2">

        <div class="panel panel-info">

            <div class="panel-heading">
                <div class="panel-title">Sign Up</div>
            </div>

            <div style="padding-top: 30px" class="panel-body">

                <!-- Login Form -->

                <form:form action="${pageContext.request.contextPath}/signup/auth"
                           method="POST" class="form-horizontal" modelAttribute="account">

                    <!-- Place for messages -->
                    <div class="form-group">
                        <div class="col-xs-15">
                            <div>

                            </div>
                        </div>
                    </div>

                    <!-- User name -->
                    <div>
                        <form:errors cssClass="error" path="username"/>
                    </div>
                    <div style="margin-bottom: 25px" class="input-group">
                        <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>

                        <form:input type="text" name="username" placeholder="username" class="form-control" path="username"/>

                    </div>
                    <div>
                        <form:errors cssClass="error" path="password"/>
                    </div>
                    <!-- Password -->
                    <div style="margin-bottom: 25px" class="input-group">
                        <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>

                        <form:input type="password" name="password" placeholder="password" class="form-control" path="password"/>

                    </div>
                    <div>
                        <form:errors cssClass="error" path="firstName"/>
                    </div>
                    <%--                    First Name--%>
                    <div style="margin-bottom: 25px" class="input-group">
                        <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>

                        <form:input name="firstName" placeholder="first name" class="form-control" path="firstName"/>

                    </div>

                    <div>
                        <form:errors cssClass="error" path="lastName"/>
                    </div>
                    <%--                    Last Name--%>
                    <div style="margin-bottom: 25px" class="input-group">
                        <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>

                        <form:input  name="lastName" placeholder="last name" class="form-control" path="lastName" />

                    </div>

                    <%--                    Email--%>
                    <div class="flex no-wrap">
                        <form:errors class="error" path="email"/>
                    </div>
                    <div style="margin-bottom: 25px" class="input-group">
                        <span class="input-group-addon"><i class="glyphicon glyphicon-envelope"></i></span>

                        <form:input type="email" name="email" placeholder="email" class="form-control" path="email"/>

                    </div>



                    <!-- Login/Submit Button -->
                    <div style="margin-top: 10px" class="form-group">
                        <div class="col-sm-6 controls">
                            <button type="submit" class="btn btn-success">Sign-Up</button>
                        </div>
                    </div>

                </form:form>

            </div>

        </div>

    </div>

</div>

</body>
</html>
