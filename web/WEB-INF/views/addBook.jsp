<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add new book</title>
    <link rel="stylesheet" href="./css/bootstrap.min.css">
    <link rel="stylesheet" href="./css/bootstrap-theme.min.css">
    <script src="./js/store-script.js">
        setWorkingDir('${pageContext.request.contextPath}');
    </script>
</head>
<body>
    <div class="container">
        <div class="panel panel-primary">
            <div class="panel-heading">Input attributes of new book</div>
            <div class="panel-body">
                <div class="form-group">
                    <label for="title">Title:</label>
                    <input type="text" class="form-control" id="title">
                </div>
                <div class="form-group">
                    <label for="desc">Description:</label>
                    <textarea class="form-control" rows="5" id="desc"></textarea>
                </div>
                <div class="form-group">
                    <label for="pages">Pages:</label>
                    <input type="number" class="form-control" id="pages">
                </div>
                <div class="form-group">
                    <label for="isbn">ISBN:</label>
                    <input type="text" class="form-control" id="isbn">
                </div>
                <div class="form-group">
                    <label for="price">Price:</label>
                    <input type="text" class="form-control" id="price">
                </div>
                <button onclick="saveNewBook()" type="button" class="btn-md btn-primary">Save</button>
                <a href="${pageContext.request.contextPath}/">
                    <button type="button" class="btn-md btn-default">Back</button>
                </a>
            </div>
        </div>
        <div id="warningsArea"></div>
    </div>
</body>
</html>
