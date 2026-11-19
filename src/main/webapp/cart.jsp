<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="/includes/header.html"></c:import>
	<h1>Your cart</h1>
	<table border=1>
		<th><b>Quantity</b></th>
		<th><b>Description</b></th>
		<th><b>Price</b></th>
		<th><b>Amount</b></th>
		<th></th>
		<tbody>
			<c:forEach var="cartItem" items="${cart.cartItems}" varStatus="loop">
				<tr>
					<td>
						<form action="CartServlet">
							<input type="hidden" name="action" value="update">
							<input type="hidden" name="cdCode" value="${cartItem.cd.code}">
							<input type="text" name="quantity" value="${cartItem.quantity}"> 
							<button type="submit">Update</button>
						</form>
					</td>
					<td>${cartItem.cd.description}</td>
					<td>${cartItem.cd.price}</td>
					<td>${cartItem.amount}</td>
					<td>
						<form action="CartServlet">
							<input type="hidden" name="action" value="delete">
							<input type="hidden" name="cdCode" value="${cartItem.cd.code}">
							<button type="submit">Remove item</button>
						</form>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table><br>
	<p><b>To change the quantity,</b> enter the new quantity and click on the Update button.</p>
	<form action="CDServlet" method="post">
		<button type="submit">Continue Shopping</button>
	</form>
	<br>
	<button>Check out</button><br>
</body>
</html>