<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: soraw
  Date: 11/14/2023
  Time: 12:03 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Adding new Office</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <div id="update-office">
        <div class="row bg-primary">
            <h2>Update Office</h2>
        </div>
        <div class="container">
            <form action="update-office" method="post" class="border p-4 rounded">
                <div class="row mb-3">
                    <h2>Office code ${officeData.officeCode}</h2>
                </div>
                <input type="hidden" id="office-code" name="currentOfficeCode" value="${officeData.officeCode}" class="form-control">
                <div class="row mb-3">
                    <label for="office-city" class="col-sm-3 col-form-label">City</label>
                    <div class="col-sm-9">
                        <input type="text" id="office-city" name="newOfficeCity" value="${officeData.city}"
                               class="form-control">
                    </div>
                </div>

                <div class="row mb-3">
                    <label for="office-phone" class="col-sm-3 col-form-label">Phone</label>
                    <div class="col-sm-9">
                        <input type="tel" id="office-phone" name="newOfficePhone" value="${officeData.phoneNumber}"
                               class="form-control">
                    </div>
                </div>

                <div class="row mb-3">
                    <label for="office-addr1" class="col-sm-3 col-form-label">Address line 1</label>
                    <div class="col-sm-9">
                        <input type="text" id="office-addr1" name="newOfficeAddr1" value="${officeData.addressLine1}"
                               class="form-control">
                    </div>
                </div>

                <div class="row mb-3">
                    <label for="office-addr2" class="col-sm-3 col-form-label">Address line 2</label>
                    <div class="col-sm-9">
                        <input type="text" id="office-addr2" name="newOfficeAddr2" value="${officeData.addressLine2}"
                               class="form-control">
                    </div>
                </div>

                <div class="row mb-3">
                    <label for="office-state" class="col-sm-3 col-form-label">State</label>
                    <div class="col-sm-9">
                        <input type="text" id="office-state" name="newOfficeState" value="${officeData.state}"
                               class="form-control">
                    </div>
                </div>

                <div class="row mb-3">
                    <label for="office-country" class="col-sm-3 col-form-label">Country</label>
                    <div class="col-sm-9">
                        <input type="text" id="office-country" name="newOfficeCountry" value="${officeData.country}"
                               class="form-control">
                    </div>
                </div>

                <div class="row mb-3">
                    <label for="office-postalCode" class="col-sm-3 col-form-label">Postal Code</label>
                    <div class="col-sm-9">
                        <input type="text" id="office-postalCode" name="newOfficePostalCode"
                               value="${officeData.postalCode}" class="form-control">
                    </div>
                </div>

                <div class="row mb-3">
                    <label for="office-territory" class="col-sm-3 col-form-label">Territory</label>
                    <div class="col-sm-9">
                        <input type="text" id="office-territory" name="newOfficeTerritory"
                               value="${officeData.territory}" class="form-control">
                    </div>
                </div>

                <div class="row mb-3">
                    <div class="col-sm-3"></div>
                    <div class="col-sm-9">
                        <button type="submit" class="btn btn-primary">Submit</button>
                        <p>${requestScope.errorUpdatingOffice}</p>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>

