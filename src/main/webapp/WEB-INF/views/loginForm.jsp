<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
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
<form action="/LoginController" method=post>
    id  <input type="text" placeholder="id입력" name="id" value=<%=id%>><br>
    pwd <input type="password" placeholder="pw입력" name="pw"><br>
    <input type="checkbox" name="rememberbtn" id="checkbox1" <%=checked%>><label for="checkbox1">id 기억</label><br>
    <input type="submit" value="로그인"><br>
    <span>ID찾기 | 비밀번호찾기 | 회원가입</span>
    <input type="hidden" name="toURL" value="<%=toURL%>">
</form>
</body>
</html>