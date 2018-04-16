<%--
  Created by IntelliJ IDEA.
  User: jti
  Date: 3/12/18
  Time: 12:47 PM
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>



<%@include file="/WEB-INF/views/template/header.jsp" %>

<div class="container-wrapper">

    <div class="container">
        <div class="page-header">

            <h1>Add product</h1>
            <p class="lead">Fill the information below to add new product.</p>


        </div>


            <%--@elvariable id="product" type=""--%>
            <form:form action="${pageContext.request.contextPath}/admin/productInventory/editProduct/" method="post"
                       commandName="product" enctype="multipart/form-data">
                       
                <div class="form-group">
                    
                    <form:input path="productId" id="productId" cssClass="form-control"></form:input>
                </div>

                <div class="form-group">
                    <label for="name">Name</label>
                    <form:input path="productName" id="name" cssClass="form-control"></form:input>
                </div>

                <div class="form-group">
                    <label for="category">Category</label>
                    <label class="checkbox-inline"><form:radiobutton path="productCategory" value="Instrument" id="category"/>Instrument</label>
                    <label class="checkbox-inline"><form:radiobutton path="productCategory" value="Record" id="category"/>Record</label>
                    <label class="checkbox-inline"><form:radiobutton path="productCategory" value="Notes" id="category"/> Notes</label>
                </div>
                <div class="form-group">
                    <label for="description">Description</label>
                    <form:input path="productDescription" id="description" cssClass="form-control"/>
                </div>

                <div class="form-group">
                    <label for="condition">Condition</label>
                    <form:textarea path="productCondition" id="condition" cssClass="form-control"/>
                </div>

                <div class="form-group">
                    <label for="price">Price</label>
                    <form:input path="productPrice" id="price" cssClass="form-control"/>
                </div>

                <div class="form-group">
                    <label for="status">Status</label>
                    <label class="checkbox-inline"><form:radiobutton path="productStatus" id="status" value="active" cssClass="form-control"/> Active</label>
                    <label class="checkbox-inline"><form:radiobutton path="productStatus" id="status" value="inactive" cssClass="form-control"/>Inactive</label>
                </div>

                <div class="form-group">
                    <label class="unit">Unit in stock</label>
                    <form:input path="unitInStock" id="unit" cssClass="form-control"/>
                </div>
                
                
                <div class="form-group">
                    <label class="control-label" for="productImage">Upload image</label>
                    <form:input id="productImage" path="productImage" type="file" class="form:input-large"/>
                </div>
                
                <br><br>
                
				
               

                <input type="submit" name="Edit" class="btn-btn-submit">

                <a href="<c:url value="/admin/productInventory"/>">Cancel</a>

            </form:form>

    </div>
</div>


<%@include file="/WEB-INF/views/template/footer.jsp"%>