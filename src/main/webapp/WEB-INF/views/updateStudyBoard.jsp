<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bulma@0.9.4/css/bulma.min.css">
    <title>Index</title>

    <style>
        table {
            border-collapse: collapse;
        }

        /*이중선 제거*/
        th,
        td {
            width: 100px;
            height: 50px;
            text-align: center;
            border: 1px solid #000;

            vertical-align: top;
            /* 위 */
            vertical-align: bottom;
            /* 아래 */
            vertical-align: middle;
            /* 가운데 */
        }
    </style>
</head>
<body>
<%@ include file="/WEB-INF/views/commons/header.jspf" %>
<br>This is studyBoard!
<form action="/studyboard/update" method="post">
    <input type="hidden" name="bno" value="${board.bno}">
    <table>
        <thead>
        <tr>
            <td colspan="4"><input type="text" placeholder="제목" name="title" value=${board.title}> </td>
        </tr>
        <tr>
            <td>번호 : ${board.bno}</td>
            <td>작성자 : ${board.writer}</td>
            <td>조회수 : ${board.view_cnt}</td>
            <td>작성일 : ${board.reg_date}</td>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td colspan="4"><input type="text" placeholder="내용" name="content" value=${board.content}></td>

        </tr>
        </tbody>
        <tfoot>
        <tr>
            <td colspan="4">${board.comment_cnt}</td>
        </tr>
        </tfoot>
    </table><br>
    <input type="submit" value="제출">
    <a href="/"><button>돌아가기</button>
    </a>
</form>
<%@ include file="/WEB-INF/views/commons/footer.jspf" %>
</body>
</html>