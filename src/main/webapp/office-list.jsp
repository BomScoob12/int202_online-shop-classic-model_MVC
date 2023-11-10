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
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <div class="row bg-primary">
        <h2>Classic Model Offices ::</h2>
    </div>
    <div class="row col-first">
        <form action="office-list" method="post">
            <label for="filter">Filter Office</label>
            <select name="filterValue" id="filter">
                <option value="all">All</option>
                <optgroup label="Countries">
                    <c:forEach items="${allCountry}" var="country" varStatus="count">
                        <option value="${country}" ${selectedFilterValue == country ? 'selected' : ''}>${country}</option>
                    </c:forEach>
                </optgroup>
                <optgroup label="City">
                    <c:forEach items="${allCity}" var="city" varStatus="count">
                        <option value="${city}" ${selectedFilterValue == city ? 'selected' : ''}>${city}</option>
                    </c:forEach>
                </optgroup>
            </select>
            <input type="submit" value="Filter">
        </form>
        <form action="adding-office" method="get" class="d-flex flex-row-reverse m-3">
            <input type="submit" class="btn btn-primary " value="Add new office">
        </form>
        <form action="remove-office" method="get" class="d-flex flex-row-reverse m-3">
            <input type="submit" class="btn btn-primary " value="remove office by ID">
        </form>
    </div>
    <div class="row">
        <c:forEach items="${offices}" var="office">
            <div class="col-2 border border-secondary p-2 m-2 ${office.officeCode == selectedOffice.officeCode ? 'bg-warning' : ''}">
                <div><%-- set parameter on url (GET METHOD)--%>
                    <a href="${pageContext.request.requestURI}?selectOffice=${office.officeCode}">${office.city}</a>
                        ${office.city}, ${office.country} <br> <p class="text-black bg-warning">Office code : ${office.officeCode}</p>
                </div>
                <div> ${office.phoneNumber}</div>
            </div>
        </c:forEach>
    </div>
</div>
</body>
</html>
