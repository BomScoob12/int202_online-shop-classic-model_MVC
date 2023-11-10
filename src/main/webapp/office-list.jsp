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
    </div>
    <div class="row">
        <c:forEach items="${offices}" var="office">
            <div class="col-2 border border-secondary p-2 m-2 ${office.officeCode == selectedOffice.officeCode ? 'bg-warning' : ''}">
                <div><%-- set parameter on url (GET METHOD)--%>
                    <a href="${pageContext.request.requestURI}?selectOffice=${office.officeCode}">${office.city}</a>
                        ${office.city}, ${office.country}
                </div>
                <div> ${office.phoneNumber}</div>
            </div>
        </c:forEach>
    </div>
    <div id="adding-office">
        <div class="row bg-primary">
            <h2>Adding new Office</h2>
        </div>
        <div class="container">
            <form action="adding-office" method = "post" class="border p-4 rounded">
                <div class="row mb-3">
                    <label for="office-code" class="col-sm-3 col-form-label">Office Code</label>
                    <div class="col-sm-9">
                        <input type="text" id="office-code" name="newOfficeCode" class="form-control">
                    </div>
                </div>

                <div class="row mb-3">
                    <label for="office-city" class="col-sm-3 col-form-label">City</label>
                    <div class="col-sm-9">
                        <input type="text" id="office-city" name="newOfficeCity" class="form-control">
                    </div>
                </div>

                <div class="row mb-3">
                    <label for="office-phone" class="col-sm-3 col-form-label">Phone</label>
                    <div class="col-sm-9">
                        <input type="tel" id="office-phone" name="newOfficePhone" class="form-control">
                    </div>
                </div>

                <div class="row mb-3">
                    <label for="office-addr1" class="col-sm-3 col-form-label">Address line 1</label>
                    <div class="col-sm-9">
                        <input type="text" id="office-addr1" name="newOfficeAddr1" class="form-control">
                    </div>
                </div>

                <div class="row mb-3">
                    <label for="office-addr2" class="col-sm-3 col-form-label">Address line 2</label>
                    <div class="col-sm-9">
                        <input type="text" id="office-addr2" name="newOfficeAddr2" class="form-control">
                    </div>
                </div>

                <div class="row mb-3">
                    <label for="office-state" class="col-sm-3 col-form-label">State</label>
                    <div class="col-sm-9">
                        <input type="text" id="office-state" name="newOfficeState" class="form-control">
                    </div>
                </div>

                <div class="row mb-3">
                    <label for="office-country" class="col-sm-3 col-form-label">Country</label>
                    <div class="col-sm-9">
                        <input type="text" id="office-country" name="newOfficeCountry" class="form-control">
                    </div>
                </div>

                <div class="row mb-3">
                    <label for="office-postalCode" class="col-sm-3 col-form-label">Postal Code</label>
                    <div class="col-sm-9">
                        <input type="text" id="office-postalCode" name="newOfficePostalCode" class="form-control">
                    </div>
                </div>

                <div class="row mb-3">
                    <label for="office-territory" class="col-sm-3 col-form-label">Territory</label>
                    <div class="col-sm-9">
                        <input type="text" id="office-territory" name="newOfficeTerritory" class="form-control">
                    </div>
                </div>

                <div class="row mb-3">
                    <div class="col-sm-3"></div>
                    <div class="col-sm-9">
                        <button type="submit" class="btn btn-primary">Submit</button>
                        <p>${requestScope.errorAddingOffice}</p>
                    </div>
                </div>
            </form>
        </div>
    </div>
    <div id="remove-office"></div>
</div>
</body>
</html>
