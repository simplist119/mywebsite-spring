<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bulma@0.9.4/css/bulma.min.css">
  <title>Document</title>
</head>
<body>
<%@ include file="/WEB-INF/views/commons/header.jspf" %>

<form action="/studyboard/insert" method="post">
  제목  <input type="text" placeholder="제목을 입력해주세요." name="title"><br>
  내용 <input type="text" placeholder="내용을 입력해주세요." name="content" style="height: 200px;"><br>
  <input type="submit" value="등록">

  <br>

</form>

<%@ include file="/WEB-INF/views/commons/footer.jspf" %>
</body>
</html>