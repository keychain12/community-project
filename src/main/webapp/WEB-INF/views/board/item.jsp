<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
                <h4 class="card-title">아이콘 샵</h4>

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
                            <th>출시일</th>
                            <th>구매하기</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="list" items="${iconList}">
                            <tr>
                                <td></td>
                                <td>${list.seq}</td>
                                <td><img src="/icon/${list.pic}" alt="image"></td>
                                <td>${list.name}</td>
                                <td>${list.price}</td>
                                <td>${list.regdate}</td>
                                <td>
                                    <button type="button" class="badge badge-outline-success"
                                            data-toggle="modal"
                                            data-target="#purchaseModal"
                                            data-icon-name="${list.name}"
                                            data-icon-pic="${list.pic}"
                                            data-icon-price="${list.price}"
                                            data-icon-seq="${list.seq}"
                                            data-member-seq="${dto.user_seq}"
                                            data-member-money="${dto.money}">
                                        구매하기
                                    </button>
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>

            <!-- Modal -->
            <form method="post" action="/board/item/buy">
                <div class="modal fade" id="purchaseModal" tabindex="-1" aria-labelledby="purchaseModalLabel"
                     aria-hidden="true">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h5 class="modal-title" id="purchaseModalLabel">구매하기</h5>
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                    <span aria-hidden="true">&times;</span>
                                </button>
                            </div>
                            <div class="modal-body">
                                구매하시겠습니까?
                                <div>아이콘 : <span id="modal-icon-name"></span></div>
                                <img id="modal-icon-pic" src="" width="200">
                                <div>가격 : <span id="modal-icon-price"></span>Point</div>
                                <div>현재 포인트 : <span id="modal-member-money"></span>Point</div>
                                <input type="hidden" id="modal-icon-seq" name="icon_seq">
                                <input type="hidden" id="modal-member-seq" name="member_seq">
                                <input type="hidden" id="modal-icon-pic-hidden" name="pic">
                                <input type="hidden" id="modal-icon-price-hidden" name="icon_price">
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-secondary" data-dismiss="modal">취소</button>
                                <button type="submit" class="btn btn-primary">구매</button>
                            </div>
                        </div>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>

<script>
    $('#purchaseModal').on('show.bs.modal', function (event) {
        var button = $(event.relatedTarget); // 버튼을 눌러 모달을 띄운 요소
        var iconName = button.data('icon-name');
        var iconPic = button.data('icon-pic');
        var iconPrice = button.data('icon-price');
        var iconSeq = button.data('icon-seq');
        var memberSeq = button.data('member-seq');
        var memberMoney = button.data('member-money');

        // 모달의 각 요소에 데이터 설정
        var modal = $(this);
        modal.find('#modal-icon-name').text(iconName);
        modal.find('#modal-icon-pic').attr('src', '/icon/' + iconPic);
        modal.find('#modal-icon-price').text(iconPrice);
        modal.find('#modal-member-money').text(memberMoney);
        modal.find('#modal-icon-seq').val(iconSeq);
        modal.find('#modal-member-seq').val(memberSeq);
        modal.find('#modal-icon-pic-hidden').val(iconPic);
        modal.find('#modal-icon-price-hidden').val(iconPrice);
    });
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
