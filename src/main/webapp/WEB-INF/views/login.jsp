<%@include file="/WEB-INF/views/template/header.jsp"%>


<div class="container-wrapper">
	<div class="container">
		<div id="login-box">

		<h2>Login with username and password</h2>

		<c:if test="${no_empty msg}">
			<div class="msg">{$msg}</div>

		</c:if>

		<form name="loginForm"
			action="<c:url value="/j_spring_security_check"/>" action=POST>

			<c:if test="${no_empty_error}">
				<div class="error" style="color: #ff000;">${error}</div>
			</c:if>
			<div class="form-group">
				<label for="username">Username</label>
				 <input type="text" id="username"
					name="username" class="form-control"/>
			</div>
            <div class="form-group">
			<label for="username">Password</label>
			 <input type="text"id="password" name="password" class="form-control"/>
			 </div>
			 <input type="submit" value="Submit" class="btn-btn-default"/>
			 <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
	  </form>
  
</div>

</div>
</div>






