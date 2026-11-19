<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="/includes/header.html"></c:import>
	<h1>CD List</h1>
	<table border=1>
		<th><b>Description</b></th>
		<th><b>Price</b></th>
		<th></th>
		<tbody>
			<c:forEach var="item" items="${cds}" varStatus="loop">
				<tr>
					<td>${item.description}</td>
					<td>${item.price}</td>
					<td>
						<form action="CartServlet" method="post">
							<input type="hidden" name="action" value="add">
							<input type="hidden" name="cdCode" value="${item.code}">
							<button type="submit">Add to cart</button>
						</form>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>