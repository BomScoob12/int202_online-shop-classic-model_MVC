<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: soraw
  Date: 11/6/2023
  Time: 12:16 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
<div class="container ml-2 p-2">
    <div class="d-flex flex-row">Product List ::</div>
    <hr>
    <c:forEach items="${products}" var="p" varStatus="vs">
    <div class="row">
        <div class="col-1">${vs.count + (page-1)*pageSize})</div>
        <div class="col-4"> ${p.productCode}: ${p.productName}</div>
        <div class="col-1"> ${p.productScale}</div>
        <div class="col-1" style="text-align: right">${p.msrp}</div>
    </div>
    </c:forEach>
    <hr>
    <div class="d-flex flex-row">
        <div>page: </div>
        <c:forEach begin="1" end="${itemCount/pageSize + (itemCount%pageSize>0?1 :0)}" varStatus="vs">
            <c:choose>
                <c:when test="${vs.count==page}">
                    <div class="p-1 text-danger">[${vs.count}]</div>
                </c:when>
                <c:otherwise>
                    <div class="p-1">
                        <a href="product-list?pageSize=${pageSize}&page=${vs.count}">[${vs.count}]</a>
                    </div>
                </c:otherwise>
            </c:choose>
        </c:forEach>
    </div>
</div>
</div>

</body>
</html>
