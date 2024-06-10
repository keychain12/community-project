
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

<style>
    .icon {
        margin: 0;
        padding: 0;
        list-style: none;
        text-align: center;
        white-space: nowrap;
        float: left;
        border: 1px solid #e5e5e5;
        margin: 0 -1px -1px 0;
    }

</style>
<div class="container-scroller">


    <%@ include file="../common/header.jsp"%>
    <%@ include file="../common/side.jsp"%>


    <!-- partial   중간 메인화면-->
    <div class="main-panel">
        <div class="content-wrapper">
            <div class="col-md-6 grid-margin stretch-card">
            <div class="card">
                <div class="card-body">

        <%--            <ul class="icon">
                        <li class="on"><a href="/member/info" class="dispMemberInfo"><span>회원정보</span></a></li>
&lt;%&ndash;                        <li><a href="/index.php?act=dispMemberScrappedDocument" class="dispMemberScrappedDocument"><span>스크랩</span></a></li>&ndash;%&gt;
&lt;%&ndash;                        <li><a href="/index.php?act=dispMemberSavedDocument" class="dispMemberSavedDocument"><span>저장함</span></a></li>&ndash;%&gt;
                        <li><a href="#" class="dispMemberOwnDocument"><span>내 글</span></a></li>
                        <li><a href="#" class="dispMemberOwnDocument"><span>내 댓글</span></a></li>
                        <li><a href="#" class="dispCommunicationMessages"><span>쪽지함</span></a></li>
                    </ul>--%>


                    <table class="table row">
                        <tbody><tr><th scope="col" colspan="2" class="t">
                            <div>기본 정보</div></th></tr>	<tr>
                            <th scope="row"><div>아이디</div></th>
                            <td class="w100">${dto.email}</td>	</tr>
                        <tr style="display:none;">
                            <th scope="row"><div>이름</div></th>	<td>아무개</td>	</tr>	<tr>
                            <th scope="row"><div>닉네임</div></th>	<td>	${dto.name}	(마지막 변경: 2019-11-08 01:19:40)	</td>	</tr><tr>
                            <th scope="row"><div>메일주소</div></th>	<td>	${dto.email}	</td>	</tr>			<%--<tr>		</tr>--%>
<%--                        <tr>	<th scope="row"><div>음성 MP4 자동재생</div></th>	<td>화면에 보이면 첫 영상 자동 재생	</td>	</tr>--%>
                        <tr>	<th scope="row"><div>대표 아이콘</div></th>	<td>	<img src="/icon/${dto.pic}" border="0" alt="정화" title="정화" style="vertical-align:middle;margin-right:3px">
                            <div>	<a href="/member/iconsetting" style="text-decoration:underline">대표 아이콘 설정하기</a>	</div>	</td>	</tr>	<tr>
                            <th scope="row"><div>가입일</div></th>	<td>2024</td>	</tr>
<%--                        <tr>	<th scope="row"><div>최근 로그인</div></th>	<td>2024-06-04 22:05</td>	</tr>	--%>
<%--                        <tr>	<th scope="row"><div>잉여력 / 레벨</div></th>	<td>	잉여력: 46,707 / 레벨: 26	</td>	</tr>--%>
                        </tbody>
                    </table>


                </div>
                </div>
            </div>
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
