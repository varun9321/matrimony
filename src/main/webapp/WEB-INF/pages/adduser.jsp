<%@include file="includes/header.jsp"%>
<body>

	<div class="container">
		<form:form modelAttribute="userdetailsdao" role="form"
			enctype="multipart/form-data">

			<form:errors />

			<div class="form-group">
				<form:label path="name">Name</form:label>
				<form:input path="name" type="name2" class="form-control"
					placeholder="Enter Name" autocomplete="false" />
				<form:errors cssClass="error" path="name" />
			</div>


			<div class="form-group">
				<form:label path="email">email</form:label>
				<form:input path="email" type="email2" class="form-control"
					placeholder="enter email" autocomplete="false" />
				<form:errors cssClass="error" path="email" />
			</div>


			<div class="form-group">
				<form:label id="1" path="password">password</form:label>
				<form:input path="password" type="password2" class="form-control"
					placeholder="enter password" />
				<form:errors cssClass="error" path="password" />
			</div>

			<div class="form-group">
				<form:select path="roles">
					<form:option value="" label="--- Select role ---" />
					<form:options items="${roles}" />
				</form:select>
				<form:errors cssClass="error" path="roles" />
			</div>

			<div class="form-group">
				<form:label id="file" path="file">add profile pic</form:label>
				<form:input path="file" type="file" class="form-control"
					placeholder="file" />
				<form:errors cssClass="error" path="file" />

			</div>

			<div class="form-group">
				<form:label id="1" path="sex">sex</form:label>
				<form:input path="sex" type="text" class="form-control"
					placeholder="sex" />
				<form:errors cssClass="error" path="sex" />
			</div>

			<div class="form-group">
				<form:label id="1" path="country">country</form:label>
				<form:input path="country" type="text" class="form-control"
					placeholder="country" />
				<form:errors cssClass="error" path="country" />
			</div>

			<div class="form-group">
				<form:label id="ph" path="ph">ph</form:label>
				<form:input path="ph" type="text" class="form-control"
					placeholder="ph" />
				<form:errors cssClass="error" path="ph" />
			</div>

			<button type="submit" class="btn btn-default">Add</button>

		</form:form>
	</div>
	<%@include file="includes/footer.jsp"%>