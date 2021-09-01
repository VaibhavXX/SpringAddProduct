<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
 <%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%> 
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div class="container">
	<h1 style="text-align:center;">ADD PRODUCT</h1>
		
</div>
<h1>======================================================================================</h1>


	<sf:form modelAttribute="product">
	
		<table align="center">
		
			<%-- <tr>
				<td>Pno:</td>
				<td> <sf:input class="form-control" id="txtpno" path="pno"/> </td>
			</tr> --%>
			<tr>
				<td>Price:</td>
				<td> <sf:input class="form-control" id="txtprice" path="price"/> </td>
			</tr>
			<tr>
				<td>Quantity:</td>
				<td> <sf:input class="form-control" id="txtstock" path="stock"/> </td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input class="btn btn-warning" type="submit" value="Add Product">
				</td>
				
			</tr>
			
		</table>
		
	</sf:form>
	
	<br/>
	<br/>
	
	<div class="container">
	<h1 style="text-align:center;">PRODUCT LIST</h1>
		
</div>
	
	<c:if test="${not empty allProducts}">
	<div class="container">
	
		<table class="table table-warning" align="center" border="1">
		
			<tr>
				<th>Pno</th>
				<th>Price</th>
				<th>Quantity</th>
			</tr>
			
			<c:forEach var="pro" items="${allProducts}">
			
				<tr>
					<td>${pro.pno }</td>
					<td>${pro.price }</td>
					<td>${pro.stock }</td>
				</tr>
			
			</c:forEach>
					
		</table>
	</c:if>
</div>
</body>
</html>