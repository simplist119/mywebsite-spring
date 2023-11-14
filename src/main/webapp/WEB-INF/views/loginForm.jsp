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
<%
    String idstr = "id를 입력해주세요.";
    String pwdstr = "pwd를 입력해주세요.";
    String ckid = "";
    String ckchecked = "";
    String id = "\"\"";
    String checked = "";
    String toURL = request.getParameter("toURL")!=null?request.getParameter("toURL"):"/";

    Cookie[] cookies = request.getCookies();
    for(Cookie cookie : cookies){
        if(cookie.getName().equals("checked")) ckchecked = cookie.getValue();
        if(cookie.getName().equals("id")) ckid = cookie.getValue();
    }
    if(ckchecked.equals("on")) {
        id = "\"" + ckid + "\"";
        checked = "checked";
    }
    else{
        checked = "";
    }
%>
<form action="/login" method="post">
    id  <input type="text" placeholder="id입력" name="id" value=<%=id%>><br>
    pwd <input type="password" placeholder="pwd입력" name="pwd"><br>
    <input type="checkbox" name="rememberbtn" id="checkbox1" <%=checked%>><label for="checkbox1">id 기억</label><br>
    <input type="submit" value="로그인"><br>
    <span>ID찾기 | 비밀번호찾기 | 회원가입</span>
    <input type="hidden" name="toURL" value="<%=toURL%>">
</form>
<%@ include file="/WEB-INF/views/commons/footer.jspf" %>
</body>
</html>