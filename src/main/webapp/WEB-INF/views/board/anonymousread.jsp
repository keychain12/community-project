
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>${board.title}</title>
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

    .comment-like-btn,
    .comment-dislike-btn {
        background: none;
        border: none;
        padding: 0;
        font: inherit;
        cursor: pointer;
        outline: inherit;
    }

    .img-small {
        width: 30px;
        height: 30px;
        object-fit: cover; /* 이미지가 크기에 맞게 잘리거나 비율이 유지됩니다. */
    }



</style>

<div class="container-scroller">


    <%@ include file="../common/header.jsp"%>
    <%@ include file="../common/side.jsp"%>


    <!-- partial   중간 메인화면-->
    <div class="main-panel">
        <div class="content-wrapper">
            <%--            여기부터   --%>



            <%-- 글 자료 시작 --%>
            <div class="row ">
                <div class="col-12 grid-margin">
                    <div class="card">
                        <div class="card-body">

                            <div class="preview-item border-bottom">
                                <h2 class="card-title">${board.title}</h2>
                            </div>

                            <div class="table-responsive">
                                <table class="table">


                                    <div class="preview-item-content d-sm-flex flex-grow">
                                        <div class="flex-grow">
                                            <h6 class="preview-subject">작성자</h6>
                                            <div class="preview-thumbnail">
                                                <img src="/icon/${memberdto.pic}" alt="image" class="rounded-circle img-small">
                                            </div>
                                            익명의 작성자
                                        </div>

                                        <div class="mr-auto text-sm-right pt-2 pt-sm-0">
                                            <p class="text-muted">조회수 ${board.views} 추천수 ${board.likes}</p>
                                            <%--                                    <p class="text-muted mb-0"> </p>--%>
                                        </div>
                                    </div>

                                    <div class="preview-item border"></div>

                                    <%--    글내용 --%>
                                    <div style="min-height: 350px;">

                                        <!-- 이미지 파일 표시 -->
                                        <c:if test="${not empty files}">
                                            <div>
                                                <div class="image-gallery">
                                                    <c:forEach var="file" items="${files}">
                                                        <img src="${file.url}" alt="${file.originalFileName}" style="max-width: 500px;"/>
                                                    </c:forEach>
                                                </div>
                                            </div>
                                        </c:if>


                                        <%--                                        글내용--%>
                                        ${board.content}

                                    </div>






                                    <div id="good-button-bad-button" class="d-flex justify-content-center">
                                        <button type="button" class="btn btn-outline-success btn-fw" id="likes">
                                            <div id="likesCount">${board.likes}</div>
                                            <div class="mdi mdi-heart">좋아요</div>
                                        </button>
                                        <button type="button" class="btn btn-outline-danger btn-fw" id="dislikes">
                                            <div class="mdi mdi-heart-broken">싫어요</div>
                                            <div id="disLikesCount">${board.dislikes}</div>
                                        </button>
                                    </div>








                                </table>
                            </div>
                        </div>
                    </div>
                </div>
            </div>



            <%--  여기까지가 글 자료 끝 --%>

            <%--                중간  이전, 목록으로 , 다음글  이거  시작--%>
            <div class="row ">
                <div class="col-12 grid-margin">
                    <div class="card">
                        <div class="card-body">

                            <div class="d-flex justify-content-center">
                                <button type="button" onclick="history.back()" class="btn btn-outline-primary btn-fw" >
                                    목록으로
                                </button>
                            </div>

                        </div>
                    </div>
                </div>
            </div>

            <%--                중간  이전, 목록으로 , 다음글  끝 --%>



            <%--                여기서부터 댓글창 작업--%>


            <div class="row ">
                <div class="col-12 grid-margin">
                    <div class="card">
                        <div class="card-body">

                            <%--                                여기서부터 댓글--%>


                            <div class="card-body">
                                <div class="d-flex flex-row justify-content-between">
                                    <h4 class="card-title">댓글</h4>
                                    <p class="text-muted mb-1 small">View all</p>
                                </div>
                                <div class="preview-list">
                                    <c:forEach var="list" items="${commentList}">
                                        <div class="preview-item border-bottom">
                                            <div class="preview-thumbnail">
                                                <img src="/icon/${list.pic}" alt="image" class="rounded-circle">
                                            </div>
                                            <div class="preview-item-content d-flex flex-grow">
                                                <div class="flex-grow">
                                                    <div class="d-flex d-md-block d-xl-flex justify-content-between">
                                                        <h6 class="preview-subject">익명의 누리꾼
                                                            <span class="comment-buttons" data-seq="${list.comment_seq}">
                                                                <button type="button" class="text-muted text-small comment-like-btn">
                                                                    <b class="mdi mdi-thumb-up-outline" id="commentlikescount_${list.comment_seq}">${list.likes}</b>
                                                                </button>
                                                                <button type="button" class="text-muted text-small comment-dislike-btn">
                                                                    <b class="mdi mdi-thumb-down-outline" id="commentdislikescount_${list.comment_seq}">${list.dislikes}</b>
                                                                </button>
                                                            </span>
                                                        </h6>
                                                        <input type="hidden" id="test123" value="${list.comment_seq}">
                                                        <p class="text-muted text-small">${list.regdate}</p>
                                                    </div>
                                                    <p class="text-muted">${list.content}</p>
                                                </div>
                                            </div>
                                        </div>
                                    </c:forEach>


                                </div>
                            </div>
                            <%-- 댓글 끝--%>

                            <%--    댓글 쓰기  시작--%>
                            <form method="POST" action="/board/comment/write">
                                <div class="add-items d-flex">
                                    <input type="hidden" name="seq" value="${seq}">
                                    <input type="hidden" name="redirectURL" value="/board/read?board_seq=${seq}">
                                    <input type="text" class="form-control todo-list-input" placeholder="글쓰기.." name="content">
                                    <button  type="submit" class="btn btn-outline-success btn-fw">작성</button>
                                </div>
                            </form>
                            <%-- 댓글 쓰기 끝--%>

                        </div>
                    </div>
                </div>
            </div>





            <%--                여기까지가 댓글창 작업--%>






            <%-- 중간 메인화면은  여기까지 --%>
        </div>
    </div>
</div>
<%--        <%@ include file="../common/footerdump.jsp"%>--%>





<script>  // 글 추천 / 반대 / 추천수 / 반대수 ajax 처리
$('#likes').click(function () {
    const seq = ${seq};
    const likes = 1;

    $.ajax({
        type: 'post',
        url: '/board/likesCount?seq=' + seq,
        contentType: 'application/json',
        data: JSON.stringify({
            likes: likes,
            seq: seq
        }),
        success: function (response) {
            if (response === "success") {
                // 서버에서 좋아요 처리가 성공한 경우
                // 좋아요 수를 업데이트
                updateLikesCount(seq);
            } else if (response === "failure") {
                // 서버에서 좋아요 처리가 실패한 경우
                alert('이미 좋아요를 누른 게시물입니다.');
            } else  if (response === 'login'){
                alert('로그인 후 이용 가능합니다.');
            }
        },
        error: function (xhr, status, error) {
            // AJAX 요청 실패 시 처리
            alert('이미 좋아요를 누를 게시물입니다..');
            console.error(error);
        },
    });
});


$('#dislikes').click(function () {
    const seq = ${seq};
    const dislikes = 1;

    $.ajax({
        type: 'post',
        url: '/board/dislikesCount?seq=' + seq,
        contentType: 'application/json',
        data: JSON.stringify({
            dislikes: dislikes,
            seq: seq
        }),
        success: function (response) {
            if (response === "success") {
                // 서버에서 좋아요 처리가 성공한 경우
                // 좋아요 수를 업데이트
                updateDislikesCount(seq);
            } else if (response === "failure") {
                // 서버에서 좋아요 처리가 실패한 경우
                alert('이미 싫어요를 누른 게시물입니다.');
            } else {
                alert('로그인 후 이용가능합니다.');
            }
        },
        error: function (xhr, status, error) {
            // AJAX 요청 실패 시 처리
            alert('이미 싫어요를 누른 게시물입니다.');
            console.error(error);
        },
    });
});





// 좋아요 수 업데이트 함수
function updateLikesCount(seq) {
    $.ajax({
        type: 'get',
        url: '/board/likesRead?seq=' + seq,
        success: function (response) {
            $('#likesCount').text(response);
        },
        error: function (xhr, status, error) {
            alert('AJAX 요청에 실패하였습니다.');
            console.error(error);
        },
    });
}


// 싫어요 수 업데이트 함수
function updateDislikesCount(seq) {
    $.ajax({
        type: 'get',
        url: '/board/disLikesRead?seq=' + seq,
        success: function (response) {
            $('#disLikesCount').text(response);
        },
        error: function (xhr, status, error) {
            alert('AJAX 요청에 실패하였습니다.');
            console.error(error);
        },
    });
}



</script>

<script>  // 댓글 /추천 / 반대 / 추천수 / 반대수 ajax 처리


// 좋아요 버튼 클릭 시
$(document).on('click', '.comment-like-btn', function () {
    const seq = $(this).closest('.comment-buttons').data('seq');
    const likes = 1;
    $.ajax({
        type: 'post',
        url: '/board/comment/likesCount?seq=' + seq,
        contentType: 'application/json',
        data: JSON.stringify({
            likes: likes,
            seq: seq,
        }),
        success: function (response) {
            if (response === "success") {
                updateCommentLikesCount(seq);
            } else if (response === 'failure') {
                alert('이미 추천을 누른 댓글 입니다.');
            } else {
                alert('로그인후 추천이 가능합니다.');
            }
        },
        error: function (xhr, status, error) {
            alert('이미 추천을 누른 댓글 입니다.');
            console.error(error);
        },
    });
});

// 싫어요 버튼 클릭 시
$(document).on('click', '.comment-dislike-btn', function () {
    const seq = $(this).closest('.comment-buttons').data('seq');
    const dislikes = 1;
    $.ajax({
        type: 'post',
        url: '/board/comment/dislikesCount?seq=' + seq,
        contentType: 'application/json',
        data: JSON.stringify({
            dislikes: dislikes,
            seq: seq,
        }),
        success: function (response) {
            if (response === "success") {
                updateCommentDislikesCount(seq);
            } else if (response === 'failure') {
                alert('이미 반대를 누른 댓글입니다.');
            } else {
                alert('로그인후 반대가 가능합니다. ');
            }
        },
        error: function (xhr, status, error) {
            alert('이미 반대를 누른 댓글입니다.');
            console.error(error);
        },
    });
});

// 좋아요 수 업데이트 함수
function updateCommentLikesCount(seq) {
    $.ajax({
        type: 'get',
        url: '/board/comment/likesRead?seq=' + seq,
        success: function (response) {
            $('#commentlikescount_' + seq).text(response);
        },
        error: function (xhr, status, error) {
            alert('AJAX 요청에 실패하였습니다.');
            console.error(error);
        },
    });
}

// 싫어요 수 업데이트 함수
function updateCommentDislikesCount(seq) {
    $.ajax({
        type: 'get',
        url: '/board/comment/disLikesRead?seq=' + seq,
        success: function (response) {
            $('#commentdislikescount_' + seq).text(response);
        },
        error: function (xhr, status, error) {
            alert('AJAX 요청에 실패하였습니다.');
            console.error(error);
        },
    });
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

