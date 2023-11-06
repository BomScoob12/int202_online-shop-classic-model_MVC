<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: soraw
  Date: 11/6/2023
  Time: 11:02 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Office Employee List</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <div class="row bg-primary">
        <h2>Classic Model Offices ::</h2>
    </div>
    <div class="row">
        <c:forEach items="${offices}" var="office">
            <div class="col-2 border border-secondary p-2 m-2 ${office.officeCode == selectedOffice.officeCode ? 'bg-warning' : ''}">
                <div>
<%--                    set parameter on url (GET METHOD)--%>
                    <a href="office-list?officeCode=${office.officeCode}">
                            ${office.city}</a>, ${office.country}
                </div>
                <div> ${office.phoneNumber}</div>
            </div>
        </c:forEach>
    </div>
</div>
</body>
</html>
