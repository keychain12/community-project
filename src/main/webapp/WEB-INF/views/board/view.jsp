<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>인기 포스트</title>
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
    /* 페이징 네비게이션과 글쓰기 버튼을 같은 줄에 배치 */
    .pagination-container {
        display: flex;
        justify-content: space-between;
        align-items: center;
        margin-top: 10px; /* 간격 조정 */
    }

    /* 페이징 네비게이션 스타일 */
    .pagination {
        display: flex;
        list-style: none;
        padding: 0;
        margin: 0 auto; /* 가운데 정렬을 위한 설정 */
    }

    .pagination li {
        margin: 0 5px;
    }

    .pagination a {
        text-decoration: none;
        color: #007bff;
    }

    .pagination .active a {
        font-weight: bold;
        color: #495057;
    }

    /* 글쓰기 버튼 스타일 */
    #write {
        display: inline-block;
    }

    /* 테이블 헤더 위쪽에 선 추가 */
    thead {
        border-top: 1px solid #495057; /* 원하는 색상과 두께로 설정 */
    }

    /* best-container 스타일 */
    .best-container {
        display: flex;
        justify-content: space-around;
        align-items: center;
        margin-bottom: 10px;
    }

    .weekly-best {
        margin-left: 5%;
    }
    #good {
        margin-bottom: 20px;
    }

</style>


<div class="container-scroller">

    <%@ include file="../common/header.jsp"%>
    <%@ include file="../common/side.jsp"%>

    <!-- partial   중간 메인화면-->
    <div class="main-panel">
        <div class="content-wrapper">

            <div class="row">
                <div class="col-12 grid-margin">
                    <div class="card">
                        <div class="card-body">
                            <h4 class="card-title">인기 포스트</h4>



                            <%-- 인기글들 --%>
                            <div class="best-container">
                                <div>오늘의 베스트</div>
                                <div class="weekly-best">주간 베스트</div>
                            </div>

                            <div class="row" id="good">
                                <!-- 오늘의 베스트 -->
                                <div class="col-md-6">
                                    <div class="table-responsive">
                                        <table class="table">
                                            <tbody>
                                            <c:forEach items="${todayBestPosts}" var="list">
                                                <tr>
                                                    <td>
                                                            ${list.board_seq}
                                                    </td>
                                                    <td><a href="/board/read?board_seq=${list.board_seq}">${list.title}</a></td>
                                                    <td class="text-right" style="color: #e4eaec"> ${list.name} </td>
                                                    <td class="text-right font-weight-medium" style="color: #00d25b"> ${list.likes} </td>
                                                </tr>
                                            </c:forEach>

                                            </tbody>
                                        </table>
                                    </div>
                                </div>

                                <!-- 주간 베스트 -->
                                <div class="col-md-6">
                                    <div class="table-responsive">
                                        <table class="table">
                                            <tbody>
                                            <c:forEach var="list" items="${weeklyBestPosts}">

                                                <tr>
                                                    <td>
                                                            ${list.board_seq}
                                                    </td>
                                                    <td><a href="/board/read?board_seq=${list.board_seq}">${list.title}</a></td>
                                                    <td class="text-right" style="color: #e4eaec"> ${list.name}  </td>
                                                    <td class="text-right font-weight-medium" style="color: #00d25b"> ${list.likes} </td>
                                                </tr>
                                            </c:forEach>

                                            </tbody>
                                        </table>
                                    </div>
                                </div>
                            </div>

                            <div class="table-responsive">
                                <table class="table">
                                    <thead>
                                    <tr>
                                        <%--<th>
                                           <div class="form-check form-check-muted m-0">
                                                <label class="form-check-label">
                                                                                                        <input type="checkbox" class="form-check-input">
                                                </label>
                                            </div>
                                        </th>--%>
                                        <th> 이미지 </th>
                                        <th> 제목 </th>
                                        <th> 작성자 </th>
                                        <th> 게시판 </th>
                                        <th> 등록일 </th>
                                        <th> 조회 </th>
                                        <th> 추천 </th>
                                        <th> 반대 </th>
                                    </tr>
                                    </thead>
                                    <tbody style="color: #e4eaec">
                                    <c:forEach var="list" items="${popularPosts}">
                                        <tr>
                                                <%--  <td>
                                                      <div class="form-check form-check-muted m-0">
                                                           <label class="form-check-label">
                                                               <input type="checkbox" class="form-check-input">
                                                           </label>
                                                      </div>
                                                  </td>--%>
                                            <td>
                                                <c:if test="${not empty files}">
                                                    <c:set var="displayed" value="false" scope="page"/>
                                                    <c:forEach var="file" items="${files}">
                                                        <c:if test="${list.board_seq eq file.board_seq && !displayed}">
                                                            <img src="${file.url}" alt="${file.originalFileName}" style="max-width: 500px;"/>
                                                            <c:set var="displayed" value="true" scope="page"/>
                                                        </c:if>
                                                    </c:forEach>
                                                </c:if>
                                            </td>
                                            <td><a href="/board/read?board_seq=${list.board_seq}"> ${list.title} </a></td>
                                            <td> ${list.name} </td>
                                                    <td>${list.table_type}</td>
                                            <td> ${list.regdate} </td>
                                            <td> ${list.views} </td>
                                                    <td style="color: #00d25b"> ${list.likes} </td>
                                                    <td style="color: #fc424a"> ${list.dislikes} </td>
                                        </tr>
                                    </c:forEach>
                                    </tbody>
                                </table>
                            </div>

                            <!-- 페이징 네비게이션 -->
                            <div class="pagination-container">
                                <c:if test="${totalPageCount > 1}">
                                    <ul class="pagination">
                                        <c:if test="${hasPreviousGroup}">
                                            <li class="page-item">
                                                <a class="page-link" href="?page=${startPage - 1}">&laquo; 이전</a>
                                            </li>
                                        </c:if>
                                        <c:forEach begin="${startPage}" end="${endPage}" var="i">
                                            <li class="page-item ${i == currentPage ? 'active' : ''}">
                                                <a class="page-link" href="?page=${i}">${i}</a>
                                            </li>
                                        </c:forEach>
                                        <c:if test="${hasNextGroup}">
                                            <li class="page-item">
                                                <a class="page-link" href="?page=${endPage + 1}">다음 &raquo;</a>
                                            </li>
                                        </c:if>
                                    </ul>
                                </c:if>

                            </div>

                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <%--        <%@ include file="../common/footerdump.jsp"%>--%>

    <script>
        //버튼 이동시키기
        var writeButton  = document.getElementById('write');

        //클립 이벤트 핸들러 함수 정의
        function handleCheck(){
            window.location.href = '/board/create';
        }
        // 버튼 클릭에 이벤트 리스너 추가
        writeButton.addEventListener("click", handleCheck);
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

</div>
</html>
