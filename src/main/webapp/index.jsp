<!DOCTYPE html>
<html>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
    <head>
        <meta charset="utf-8" />
        <title>Home</title>
    </head>
    <body>
        <p>Ceci est une page générée depuis une JSP.</p>
        <c:forEach items="${products}" var="item">
    		<p>${item.title}</p>
    		<p>${item.description}</p>
    		<p>${item.price }</p>
		</c:forEach>
    
    </body>
</html>