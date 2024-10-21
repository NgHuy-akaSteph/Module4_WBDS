<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
  <title>Upload Song</title>
</head>
<body>
<h2>Upload Song</h2>
<%--@elvariable id="song" type="com.dev.demoapp.entities.Song"--%>
<form:form modelAttribute="song" action="/uploadSong" method="post" enctype="multipart/form-data">
  <label for="title">Song Name:</label>
  <form:input path="title" /><br><br>
  <label for="artist">Artist:</label>
  <form:input path="artist" /><br><br>
  <label for="album">Genre:</label>
  <form:input path="album" /><br><br>
  <label for="file">File:</label>
  <form:input path="file" type="file" /><br><br>
  <form:errors path="file" /><br><br>
  <button type="submit">Upload</button>
</form:form>
</body>
</html>
