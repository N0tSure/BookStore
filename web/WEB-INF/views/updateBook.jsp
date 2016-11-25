<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Update existed book</title>
    <link rel="stylesheet" href="./css/bootstrap.min.css">
    <link rel="stylesheet" href="./css/bootstrap-theme.min.css">
</head>
<body>
<div class="container">
    <div class="panel panel-primary">
        <div class="panel-heading">Input attributes of new book</div>
        <div class="panel-body">
            <form:form method="post" modelAttribute="book">
                <fieldset>
                    <spring:bind path="id">
                        <form:hidden path="id"></form:hidden>
                    </spring:bind>
                    <spring:bind path="title">
                        <div class="form-group">
                            <label for="title">Title:</label>
                            <form:input type="text" class="form-control" path="title" value=""></form:input>
                        </div>
                    </spring:bind>
                    <spring:bind path="description">
                        <div class="form-group">
                            <label for="description">Description:</label>
                            <form:textarea class="form-control" rows="5" path="description"></form:textarea>
                        </div>
                    </spring:bind>
                    <spring:bind path="pages">
                        <div class="form-group">
                            <label for="pages">Pages:</label>
                            <form:input type="number" class="form-control" path="pages"></form:input>
                        </div>
                    </spring:bind>
                    <spring:bind path="isbn">
                        <div class="form-group">
                            <label for="isbn">ISBN:</label>
                            <form:input type="text" class="form-control" path="isbn"></form:input>
                        </div>
                    </spring:bind>
                    <spring:bind path="price">
                        <div class="form-group">
                            <label for="price">Price:</label>
                            <form:input type="text" class="form-control" path="price"></form:input>
                        </div>
                    </spring:bind>
                    <button type="submit" class="btn-md btn-primary">Save</button>
                    <a href="${pageContext.request.contextPath}/">
                        <button type="button" class="btn-md btn-default">Back</button>
                    </a>
                </fieldset>
            </form:form>
        </div>
    </div>
    <div id="warningsArea"></div>
</div>
</body>
</html>
