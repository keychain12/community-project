<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <style>
        .auth.login-bg {
            background: url(/assets/images/auth/Login_bg.jpg);
            background-size: cover;
        }
    </style>
    <!-- Required meta tags -->
    <link rel="stylesheet" href="/css/main.css">
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>로그인</title>
    <!-- plugins:css -->
    <link rel="stylesheet" href="/assets/vendors/mdi/css/materialdesignicons.min.css">
    <link rel="stylesheet" href="/assets/vendors/css/vendor.bundle.base.css">
    <!-- endinject -->
    <!-- Plugin css for this page -->
    <!-- End plugin css for this page -->
    <!-- inject:css -->
    <!-- endinject -->
    <!-- Layout styles -->
    <link rel="stylesheet" href="/css/style.css">
    <!-- End layout styles -->
    <link rel="shortcut icon" href="/assets/images/favicon.png" />
</head>
<style>
    .form-container {
        display: flex;
        justify-content: space-around;
        flex-wrap: wrap;
        gap: 10px; /* 폼 간의 간격 */
    }

    .form-container form {
        display: inline-block; /* 폼을 인라인 블록으로 설정 */
    }
</style>

<body>
<div class="container-scroller">
    <div class="container-fluid page-body-wrapper full-page-wrapper">
        <div class="row w-100 m-0">
            <div class="content-wrapper full-page-wrapper d-flex align-items-center auth login-bg">
                <div class="card col-lg-4 mx-auto">
                    <div class="card-body px-5 py-5">
                        <h3 class="card-title text-left mb-3">Login</h3>
                        <form method="post" action="/login/view.do">
                            <div class="form-group">
                                <label>Email *</label>
                                <input type="email" style="color: #e4eaec" class="form-control p_input" name="email" >
                            </div>
                            <div class="form-group">
                                <label>Password *</label>
                                <input type="password" style="color: #e4eaec" class="form-control p_input" name="pw">
                            </div>
                            <div class="form-group d-flex align-items-center justify-content-between">
                                <div class="form-check">
                                    <label class="form-check-label">
                                        <input type="checkbox" class="form-check-input"> 로그인 상태 유지 </label>
                                </div>
                                <a href="#" class="forgot-pass">비밀번호 찾기</a>
                            </div>
                            <div class="text-center">
                                <button type="submit" class="btn btn-primary btn-block enter-btn">Login</button>
                            </div>
                            <div class="d-flex">
                                <button class="btn btn-facebook mr-2 col">
                                    <i class="mdi mdi-facebook"></i> Facebook </button>
                                <button class="btn btn-google col">
                                    <i class="mdi mdi-google-plus"></i> Google plus </button>
                            </div>
                            <p class="sign-up">계정이 없으신가요?<a href="/register/view.do"> 회원가입</a></p>
                            <p style="text-align: center"><a href="/board/view.do">홈으로</a> </p>
                        </form>
                        <%--    관리자용 로그인 --%>
                        <%--       <div class="form-container">
                               <form method="POST" action="/login/view.do">
                                   <input type="hidden" name="email" value="qjtjzj2733@naver.com">
                                   <input type="hidden" name="pw" value="admin">
                                   <button type="submit" class="login button admin">관리자</button>
                                   &lt;%&ndash;		<input type="hidden" name="${_csrf.parameterName}"&ndash;%&gt;
                                   &lt;%&ndash;			value="${_csrf.token}">&ndash;%&gt;
                               </form>

                               <form method="POST" action="/login/view.do">
                                   <input type="hidden" name="email" value="jyun@naver.com">
                                   <input type="hidden" name="pw" value="jyun">
                                   <button type="submit" class="login button admin">jyun</button>
                                   &lt;%&ndash;		<input type="hidden" name="${_csrf.parameterName}"&ndash;%&gt;
                                   &lt;%&ndash;			value="${_csrf.token}">&ndash;%&gt;
                               </form>

                               <form method="POST" action="/login/view.do">
                                   <input type="hidden" name="email" value="burger@naver.com">
                                   <input type="hidden" name="pw" value="burger">
                                   <button type="submit" class="login button admin">burger_king</button>
                                   &lt;%&ndash;		<input type="hidden" name="${_csrf.parameterName}"&ndash;%&gt;
                                   &lt;%&ndash;			value="${_csrf.token}">&ndash;%&gt;
                               </form>

                               <form method="POST" action="/login/view.do">
                                   <input type="hidden" name="email" value="test1@naver.com">
                                   <input type="hidden" name="pw" value="test1">
                                   <button type="submit" class="login button admin">이지은</button>
                                   &lt;%&ndash;		<input type="hidden" name="${_csrf.parameterName}"&ndash;%&gt;
                                   &lt;%&ndash;			value="${_csrf.token}">&ndash;%&gt;
                               </form>

                               <form method="POST" action="/login/view.do">
                                   <input type="hidden" name="email" value="test2@naver.com">
                                   <input type="hidden" name="pw" value="test2">
                                   <button type="submit" class="login button admin">나얼</button>
                                   &lt;%&ndash;		<input type="hidden" name="${_csrf.parameterName}"&ndash;%&gt;
                                   &lt;%&ndash;			value="${_csrf.token}">&ndash;%&gt;
                               </form>
                               </div>--%>

                    </div>
                </div>
            </div>
            <!-- content-wrapper ends -->
        </div>
        <!-- row ends -->
    </div>
    <!-- page-body-wrapper ends -->
</div>
<!-- container-scroller -->
<!-- plugins:js -->
<script src="/assets/vendors/js/vendor.bundle.base.js"></script>
<!-- endinject -->
<!-- Plugin js for this page -->
<!-- End plugin js for this page -->
<!-- inject:js -->
<script src="/assets/js/off-canvas.js"></script>
<script src="/assets/js/hoverable-collapse.js"></script>
<script src="/assets/js/misc.js"></script>
<script src="/assets/js/settings.js"></script>
<script src="/assets/js/todolist.js"></script>
<!-- endinject -->
<script>
    document.addEventListener("DOMContentLoaded", function() {
        const urlParams = new URLSearchParams(window.location.search);
        const errorMessage = urlParams.get('errorMessage');
        if (errorMessage) {
            alert(errorMessage);
        }
    });
</script>
</body>
</html>
