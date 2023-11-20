<%--
  Created by IntelliJ IDEA.
  User: INT202&204
  Date: 11/3/2023
  Time: 11:42 AM
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="row bg-primary">
    <h4>Classic Model Offices ::</h4>
</div>
<div class="row">
    <c:forEach items="${offices}" var="office">
        <div class="col-2 border border-secondary p-2 m-2
            ${office.officeCode == selectedOffice.officeCode ? 'bg-warning' : ''}">
            <div>
                <a href="javascript:loadOffice('${office.officeCode}')"> ${office.city}</a>, ${office.country}</div>
            <div> ${office.phone}</div>
        </div>
    </c:forEach>
    <br>
    <div class="row bg-light"><b>Employees ::</b></div>
    <div class="row">
        <c:forEach items="${selectedOffice.employeeList}" var="employee">
            <div class="col-2 pl-2 m-2 border border-secondary rounded-pill">
                <div>
                        ${employee.firstName} ${employee.lastName} - ${employee.jobTitle}
                </div>
            </div>
        </c:forEach>
    </div>