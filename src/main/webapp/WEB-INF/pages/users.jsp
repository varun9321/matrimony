<%@include file="includes/header.jsp"%>
<style>
table {
	font-family: arial, sans-serif;
	border-collapse: collapse;
	width: 100%;
	text-align: center;
}

td, th {
	border: 1px solid #dddddd;
	text-align: left;
	padding: 8px;
}

tr:nth-child(even) {
	background-color: #dddddd;
}
</style>
<body>
	<script>
			function deleteById(integer) {
				console.log('clicked on : '
						+ integer);
				window.location="/admin/usersupdated?id=" + integer;
 		}
		</script>
	<div class="container">
		<c:if test="${not empty users}">

			<table>
				<tr>
					<th>id</th>
					<th>name</th>
					<th>email</th>
					<th>password</th>
					<th>roles</th>
					<th>delete</th>
				</tr>
				<c:forEach var="listValue" items="${users}">

					<tr>
						<td>${listValue.id}</td>
						<td>${listValue.name}</td>
						<td>${listValue.email}</td>
						<td>${listValue.password}</td>
						<td><c:forEach var="listValue" items="${listValue.roles}">
								<p style="font-size: 70%; ">${listValue.roleName}</p>
								<td><button class="btn" type="submit" style="background: #FF0000;"
								onclick="deleteById(${listValue.id});">Delete</button></td>
							</c:forEach></td>
						
					</tr>

				</c:forEach>
			</table>

		</c:if>
	</div>
	<%@include file="includes/footer.jsp"%>