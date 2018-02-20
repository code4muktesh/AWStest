<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
<head>
	<title>File Upload</title>
	<style type="text/css">
		.tg  {border-collapse:collapse;border-spacing:0;border-color:#ccc;}
		.tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#fff;}
		.tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#f0f0f0;}
		.tg .tg-4eph{background-color:#f9f9f9}
	</style>
</head>
<body>
<h1>
	Upload File
</h1>

<form action="file/add" method="post" enctype="multipart/form-data" >
<input type="file" name="file"/>
<input type="submit" value="Upload"/>
<br>
<h3>${msg}</h3>
<br/>
<h3>File List</h3>
<c:if test="${!empty listFiles}">
	<table class="tg">
	<tr>
		<th width="80">File ID</th>
		<th width="120"> Name</th>
		<th width="120">File Url</th>
		<th width="120">Created At</th>
		
	</tr>
	<c:forEach items="${listFiless}" var="file">
		<tr>
			<td>${file.id}</td>
			<td>${file.name}</td>
			<td>${file.file_uri}</td>
			<td>${file.create_at}</td>
			
		</tr>
	</c:forEach>
	</table>
</c:if>
</body>
</html>
