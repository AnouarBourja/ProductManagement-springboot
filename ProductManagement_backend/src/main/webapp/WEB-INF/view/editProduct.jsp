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
<script type="text/javascript"
        src="webjars/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=windows-1256">
    <title>Update Product</title>
</head>
<body>
<div class="container">
    <div class="card-body">
        <form action="editProduct" method="post">
            <div class="form-group">
                <label class="control-label">ID Product :</label>
                <input type="text" name="idProduct" value="${product.idProduct}"
                       readonly class="form-control"/>
            </div>
            <div class="form-group">
                <label class="control-label">Name Product :</label>
                <input type="text" name="nameProduct" value="${product.nameProduct}"
                       class="form-control"/>
            </div>
            <div class="form-group">
                <label class="control-label">Price Product :</label>
                <input type="text" name="priceProduct" value="${product.priceProduct}"
                       class="form-control"/>
            </div>
            <div class="form-group">
                <label class="control-label"> Creation Date :</label>
                <fmt:formatDate pattern="yyyy-MM-dd" value="${product.dateCreation}" var="formatDate" />
                <input type="date" name="date" value="${formatDate}" class="formcontrol"/>
            </div>
            <div>
                <button type="submit" class="btn btn-primary">Update</button>
            </div>
        </form>
    </div>
    <br/>
    <br/>
    <a href="ListProducts">Products List</a>
</div>
</body>
</html>