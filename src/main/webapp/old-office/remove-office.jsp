<%--
  Created by IntelliJ IDEA.
  User: soraw
  Date: 11/10/2023
  Time: 10:31 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Remove office</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <div class="row bg-primary">
        <h2>Remove by Id and Office Data</h2>
    </div>
    <div class="row justify-content-center">
        <div class="d-block border m-2 p-2">
            <form action="remove-office" method="post">
                <label for="removeId"></label>Remove By Id :
                <input type="text" name="removeId" id="removeId">
                <input type="submit" value="Remove">
                <p>${errorRemove}</p>
            </form>
            <div>
                <p>${removeStatus}</p>
            </div>
        </div>
    </div>
    <div class="row justify-content-center m-2 p-2 border">
        <form action="remove-office" method="post">
            <h3>Select and remove office</h3>
            <c:forEach items="${offices}" var="office">
                <div class="d-inline p-2 m-2">
                <input type="radio" id="selectedOffice${office.officeCode}" value="${office.officeCode}"
                       name="removeId">
                <label for="selectedOffice${office.officeCode}" class="row-2 border border-secondary p-2 m-1 div-link">
                    <div>${office.officeCode}</div>
                    <div>${office.city}, ${office.country}</div>
                    <div> ${office.phoneNumber} </div>
                </label>
                </div>
            </c:forEach>
            <div class="p-2 m-2">
                <input type="submit" value="Remove Office">
            </div>
        </form>
    </div>
</div>
</body>
</html>
