
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>수정 페이지</title>
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
<link rel="shortcut icon" href="/assets/images/favicon.png" />
<style>
    #sb {
        margin-bottom: 30px;
    }
</style>

<div class="container-scroller">


    <%@ include file="../common/header.jsp"%>
    <%@ include file="../common/side.jsp"%>


    <!-- partial   중간 메인화면-->
    <div class="main-panel">
        <div class="content-wrapper">



            <div class="col-12 grid-margin stretch-card">
                <div class="card">
                    <div class="card-body">
                        <h4 class="card-title">글 수정하기</h4>
                        <form method="post" action="/board/edit" >



                            <div class="form-group">
                                <label for="exampleInputName1">제목</label>
                                <input type="text" class="form-control" id="exampleInputName1" name="title" required value="${dto.title}">
                            </div>



                            <div class="form-group">
                                <label for="exampleTextarea1">내용</label>
                                <textarea class="form-control" id="exampleTextarea1" rows="10" name="content" required >${dto.content}</textarea>
                            </div>





                            <input type="hidden" name="board_seq" value="${seq}">
                            <button type="submit" class="btn btn-primary mr-2">수정하기</button>
                            <button class="btn btn-dark" onclick="history.back()">취소</button>
                        </form>
                    </div>
                </div>
            </div>




        </div>
    </div>
</div>
<%--        <%@ include file="../common/footerdump.jsp"%>--%>








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
