<%--
  Created by IntelliJ IDEA.
  User: WagnerMestrinho
  Date: 3/9/17
  Time: 4:18 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Weather</title>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</head>
<body>
<nav class="navbar navbar-inverse">
    <ul class="nav navbar-nav">
        <li><a href="/open/login.jsp"><h4>Login</h4></a></li>
        <li><a href="/secure/write.jsp"><h4>Start Writing</h4></a></li>
        <li><a href="/secure/messages"><h4>Wall</h4></a></li>
        <li><a href="/secure/picture.jsp"><h4>Picture</h4></a></li>
    </ul>

</nav>

<div class="container">
    <c:if test="${up_load != null}">
        <div class="alert alert-success">
            <c:out value="${up_load}"/>
        </div>
    </c:if>
    <div class="row">
        <form action="/secure/posting" enctype="multipart/form-data"  method="post">
            <div class="form-group">
                <label for="pictureFileName">Profile Image:</label>
                <input type="file" class="form-control" id="pictureFileName" name="pictureFile">
            </div>
            <input type="hidden" name="id"  value="<c:out default="0" value="${author.id}"/>" />
            <button type="submit" class="btn btn-default">Submit</button>
        </form>
    </div>
</div>
</body>
</html>
