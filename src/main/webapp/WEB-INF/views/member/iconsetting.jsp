<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>아이콘 설정</title>
<!-- plugins:css -->
<link rel="stylesheet" href="/css/style.css">
<link rel="stylesheet" href="/assets/vendors/mdi/css/materialdesignicons.min.css">
<link rel="stylesheet" href="/assets/vendors/css/vendor.bundle.base.css">
<!-- endinject -->
<!-- Plugin css for this page -->
<link rel="stylesheet" href="/assets/vendors/jvectormap/jquery-jvectormap.css">
<link rel="stylesheet" href="/assets/vendors/flag-icon-css/css/flag-icon.min.css">
<link rel="stylesheet" href="/assets/vendors/owl-carousel-2/owl.carousel.min.css">
<link rel="stylesheet" href="/assets/vendors/owl-carousel-2/owl.theme.default.min.css">
<!-- End plugin css for this page -->
<!-- inject:css -->
<!-- endinject -->
<!-- Layout styles -->
<link rel="stylesheet" href="/assets/css/style.css">
<!-- End layout styles -->
<link rel="shortcut icon" href="/assets/images/favicon.png"/>

<style>
    /* 기본적인 버튼 스타일 제거 */
    button.badge {
        background: none;
        border: none;
        padding: 0;
        cursor: pointer;
    }

    /* 에러 메시지 스타일 추가 */
    .error-message {
        color: red;
        font-weight: bold;
        margin: 20px 0;
    }
</style>

<div class="container-scroller">
    <%@ include file="../common/header.jsp" %>
    <%@ include file="../common/side.jsp" %>

    <!-- partial   중간 메인화면-->
    <div class="main-panel">
        <div class="content-wrapper">
            <div class="card-body">
                <h4 class="card-title">내 아이콘</h4>

                <!-- 에러 메시지 출력 -->
                <c:if test="${not empty param.errorMessage}">
                    <script>
                        alert('${param.errorMessage}');
                    </script>
                </c:if>

                <div class="table-responsive">
                    <table class="table">
                        <thead>
                        <tr>
                            <th></th>
                            <th>Order No</th>
                            <th>아이콘</th>
                            <th>이름</th>
                            <th>가격</th>
                            <th>구매일</th>
                            <th>변경하기</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="list" items="${list}">
                            <tr>
                                <td></td>
                                <td>${list.payment_id}</td>
                                <td><img src="/icon/${list.pic}" alt="image"></td>
                                <td>${list.name}</td>
                                <td>${list.price}</td>
                                <td>${list.payment_date}</td>
                                <td>
                                    <button type="button" class="badge badge-outline-success" onclick="confirmChangeIcon('${list.pic}')">
                                        변경하기
                                    </button>
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>

            <form id="iconChangeForm" action="/member/changeIcon" method="post">
                <input type="hidden" name="pic" id="boardSeq" value="">
                <input type="hidden" name="icon_id" id="iconId" value="">
            </form>

        </div>
    </div>
</div>


<script>
    function confirmChangeIcon(boardSeq, iconId) {
        if (confirm("정말로 아이콘을 변경하시겠습니까?")) {
            document.getElementById("boardSeq").value = boardSeq;
            document.getElementById("iconId").value = iconId;
            document.getElementById("iconChangeForm").submit();
        }
    }
</script>


<!-- plugins:js -->
<script src="/assets/vendors/js/vendor.bundle.base.js"></script>
<!-- endinject -->
<!-- Plugin js for this page -->
<script src="/assets/vendors/chart.js/Chart.min.js"></script>
<script src="/assets/vendors/progressbar.js/progressbar.min.js"></script>
<script src="/assets/vendors/jvectormap/jquery-jvectormap.min.js"></script>
<script src="/assets/vendors/jvectormap/jquery-jvectormap-world-mill-en.js"></script>
<script src="/assets/vendors/owl-carousel-2/owl.carousel.min.js"></script>
<!-- End plugin js for this page -->
<!-- inject:js -->
<script src="/assets/js/off-canvas.js"></script>
<script src="/assets/js/hoverable-collapse.js"></script>
<script src="/assets/js/misc.js"></script>
<script src="/assets/js/settings.js"></script>
<script src="/assets/js/todolist.js"></script>
<!-- endinject -->
<!-- Custom js for this page -->
<script src="/assets/js/dashboard.js"></script>
<!-- End custom js for this page -->
</body>
</html>
