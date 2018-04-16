<%--
  Created by IntelliJ IDEA.
  User: jti
  Date: 3/12/18
  Time: 11:37 AM
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://java.sun.com/jsp/jstl/core" %>

<%@include file="/WEB-INF/views/template/header.jsp"%>

<div class="container-wrapper">

    <div class="container">
        <div class="page-header">

            <h1>Admin page</h1>

            <p class="lead"> This is a admin page</p>
            
            <c:if test="${pageContext.request.userPrincipal.name != null}">
            <h2>
                Welcome: ${pageContext.request.userPrincipal.name} | <a href="<c:url
                value="/j_spring_security_logout" />">Logout</a>
            </h2>
        </c:if>

        </div>
        <h3>

       <a href="<c:url value="/admin/productInventory/"/>" >Product inventory </a>

        </h3>







<%@include file="/WEB-INF/views/template/footer.jsp"%>



    </div>
</div>
