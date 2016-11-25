<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title>Book Store</title>
    <link rel="stylesheet" href="./css/bootstrap.min.css">
    <link rel="stylesheet" href="./css/bootstrap-theme.min.css">
    <script src="./js/store-script.js">
        setWorkingDir(${pageContext.request.contextPath});
    </script>
</head>
<body onload="loadAll(&apos;${pageContext.request.contextPath}&apos;)">
    <div class="container">
        <div class="jumbotron">
            <h2>Available books</h2>
            <p>
                There you can view all available books, remove and update some one.
            </p>
            <p>
                <a href="${pageContext.request.contextPath}/new"><button type="button" class="btn-md btn-primary">Add book</button></a>
                <button onclick="refresh(&apos;${pageContext.request.contextPath}&apos;)" type="button" class="btn-md btn-primary">Refresh</button>
            </p>
        </div>
        <div id="warningsArea"></div>
        <div id="bookWell" class="well">
            <!-- Books will load there -->
        </div>
    </div>
</body>
</html>
