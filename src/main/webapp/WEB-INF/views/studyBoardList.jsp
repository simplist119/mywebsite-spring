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
<table>
    <%--TODO : for문 돌릴때 그냥 중간에 자바코드러 어트리뷰트 생성해도 되는지?--%>
    <h2>공부게시판♥</h2><br>
    <tbody>
    <thead>
    <tr>
        <th scope="col">번호</th>
        <th scope="col">제목</th>
        <th scope="col">작성자</th>
        <th scope="col">조회수</th>
        <th scope="col">댓글수</th>
        <th scope="col">작성일</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="board" items="${list}" varStatus="status">
        <tr>
            <td>${(currentPage-1)*10+status.count}</td>
            <td><a href="/studyboard?bno=${board.bno}">${board.title}</a></td>
            <td>${board.writer}</td>
            <td>${board.view_cnt}</td>
            <td>${board.comment_cnt}</td>
            <td>${board.reg_date}<br></td>
        </tr>
    </c:forEach>
    </tbody>
    <tfoot>
    </tfoot>
</table>
<span><a href="studyboardlist?page=1">처음</a>&nbsp&nbspㅣ&nbsp&nbsp</span>
<span><a href="studyboardlist?page=${currentPage-1}">이전</a>&nbsp&nbspㅣ&nbsp&nbsp</span>
<span id="s1" class="sp"><a href="studyboardlist?page=${currentPage-2}">${currentPage-2}</a>&nbsp&nbspㅣ&nbsp&nbsp</span>
<span id="s2" class="sp"><a href="studyboardlist?page=${currentPage-1}">${currentPage-1}</a>&nbsp&nbspㅣ&nbsp&nbsp</span>
<span style="background: lightslategray">&nbsp&nbsp${currentPage}&nbsp&nbsp&nbsp</span>ㅣ
<span id="s3" class="sp"><a href="studyboardlist?page=${currentPage+1}">${currentPage+1}</a>&nbsp&nbspㅣ&nbsp&nbsp</span>
<span id="s4" class="sp"><a href="studyboardlist?page=${currentPage+2}">${currentPage+2}</a>&nbsp&nbspㅣ&nbsp&nbsp</span>
<span><a href="studyboardlist?page=${currentPage+1}">다음</a>&nbsp&nbspㅣ&nbsp&nbsp</span>
<span><a href="studyboardlist?page=${lastPage}">&nbsp&nbsp마지막&nbsp&nbsp</a></span>

<button type="button" ><a href="/studyboard/insertForm">글쓰기</a></button>
<br>
<br>
<%@ include file="/WEB-INF/views/commons/footer.jspf" %>
<script>
    window.onload = function(){
        if(`${currentPage}`==1){
            // comp1 = document.getElementById("s1");
            // comp1.style.display = "none";
            document.getElementById("s1").style.display = "none";
            document.getElementById("s2").style.display = "none";
        }
        else if(`${currentPage}`==2){
            document.getElementById("s1").style.display = "none";
        }
        // todo 긴급처리좀
        else if(`${currentPage}`==`${lastPage-1}`){
            document.getElementById("s4").style.display = "none";
        }
        else if(`${currentPage}`==`${lastPage}`){
            document.getElementById("s3").style.display = "none";
            document.getElementById("s4").style.display = "none";
        }
    }

</script>
</body>
</html>