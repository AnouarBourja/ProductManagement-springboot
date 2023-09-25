<%@ page language="java" contentType="text/html; charset=windows-1256"
         pageEncoding="windows-1256"%>
<!-- < %@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> -->
<!-- < %@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> -->
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<link rel="stylesheet" type="text/css" href="webjars/bootstrap/4.3.1/css/bootstrap.min.css" />
<c:url value="/css/main.css" var="jstlCss" />
<link href="${jstlCss}" rel="stylesheet" />
<script type="text/javascript" src="webjars/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=windows-1256">
    <title>Products List</title>
</head>
<body>
<div class="container">
    <div class="card">
        <div class="card-header">
            Products List
        </div>
        <div class="card-body">
            <table class="table table-striped">
                <tr>
                    <th>ID</th><th>Product Name</th><th>Price</th><th>Creation Date</th><th>Delete<th>Update</th>
                </tr>
                <c:forEach items="${products}" var="p">
                    <tr>
                        <td>${p.idProduct }</td>
                        <td>${p.nameProduct }</td>
                        <td>${p.priceProduct }</td>
                        <td><fmt:formatDate pattern="dd/MM/yyyy"
                                            value="${p.creationDate}" /></td>
                        <td><a onclick="return confirm('Please confirm ?')"
                               href="deleteProduct?id=${p.idProduct }">Delete</a></td>
                        <td><a href="editProduct?id=${p.idProduct }">Update</a></td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>
</div>
</body>
</html>