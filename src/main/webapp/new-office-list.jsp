<%--
  Created by IntelliJ IDEA.
  User: soraw
  Date: 11/13/2023
  Time: 11:43 AM
  To change this template use File | Settings | File Templates.
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="row pt-4">
    <h2>Classic Model Offices ::</h2>
</div>
<div class="row">
    <c:forEach items="${offices}" var="office">
        <div class="col-2 border border-secondary p-2 m-2 div-link
                   ${office.id == selectedOffice.id ? 'bg-warning' : ''}"
             onclick="loadOffice(${office.officeCode})">
            <div>
                    ${office.city}, ${office.country}
            </div>
            <div> ${office.phone} </div>
        </div>
    </c:forEach>
</div>
