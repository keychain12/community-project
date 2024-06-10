
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Corona Admin</title>
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

<div class="container-scroller">


    <%@ include file="../common/header.jsp"%>
    <%@ include file="../common/side.jsp"%>


    <!-- partial   중간 메인화면-->
    <div class="main-panel">
        <div class="content-wrapper">


            <div class="col-md-8 grid-margin stretch-card">
                <div class="card">
                    <div class="card-body">
                        <div class="d-flex flex-row justify-content-between">
                            <h4 class="card-title mb-1">결제 내역</h4>
                            <p class="text-muted mb-1"><a href="/member/buy-points">Point 충전하기</a></p>
                        </div>
                        <div class="row">
                            <div class="col-12">
                                <div class="preview-list">


                        <c:forEach items="${paymentHistory}" var="list">

                                    <div class="preview-item border-bottom">
                                        <div class="preview-thumbnail">
                                            <img class="/icon/${list.pic}">
                                        </div>
                                        <div class="preview-item-content d-sm-flex flex-grow">
                                            <div class="flex-grow">
                                                <h6 class="preview-subject">아이콘명 : ${list.name}</h6>
                                                <p class="text-muted mb-0">주문 번호 : ${list.payment_id}</p>
                                            </div>
                                            <div class="mr-auto text-sm-right pt-2 pt-sm-0">
                                                <p class="text-muted">${list.price} Point</p>
                                                <p class="text-muted mb-0">${list.payment_date} </p>
                                            </div>
                                        </div>
                                    </div>

                        </c:forEach>




                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>






        </div>
    </div>
</div>







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
