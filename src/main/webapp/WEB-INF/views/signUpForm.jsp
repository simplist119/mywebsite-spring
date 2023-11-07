<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bulma@0.9.4/css/bulma.min.css">
    <title>Sign Up</title>
    <title>Document</title>
</head>
<body>
<%@ include file="/commons/header.jspf" %>
<form action="/signup" method="post">
    ID <input type="text" placeholder="id를입력해주세요." name="id"><br>
    PWD <input type="text" placeholder="pw를입력해주세요." name="pwd"><br>
    이름 <input type="text" placeholder="이름을입력해주세요." name="name"><br>
	이메일 <input type="text" placeholder="이메일을입력해주세요." name="email"><br>
	생일 <input type="text" placeholder="생일입력해주세요." name="birth"><br>
    <input type="submit" value="제출">
    <a href="/">
        <button>돌아가기</button>
    </a>
</form>
<%@ include file="/commons/footer.jspf" %>
</body>
</html>