package com.example.soloproject.board.controller;

import com.example.soloproject.board.FileResponse;
import com.example.soloproject.board.UploadFile;
import com.example.soloproject.board.domain.*;
import com.example.soloproject.board.service.BoardService;
import com.example.soloproject.member.domain.MemberDTO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static com.example.soloproject.member.SessionConst.LOGIN_MEMBER;
@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/board")
public class BoardController {

    private final BoardService service;

    @GetMapping("/")
    public String test() {
        return "Test";
    }

    @GetMapping("/view.do")
    public String view(@RequestParam(defaultValue = "1") int page, Model model) { // 메인화면 , 인기포스트


        // 인기글 가져오기
        List<BoardDTO> popularPosts = service.getPopularPosts(page);

        //  모든 첨부파일 가져오기
        List<FileResponse> files = service.getAllFiles();


        //페이징 작업
        // 총 게시물 개수
        int totalCount = service.getTotalPopularPostsCount();
        // 한 페이지 게시물수 10
        int pageRange = service.getPageRange();
        // 페이지 사이즈  1~10
        int pageSize = service.getPageSize();
        // 총 페이지 개수
        int totalPageCount = (int) Math.ceil(totalCount / (double) pageSize);

        //현재 페이지가 속한 페이지 범위
        int currentGroup = (int) Math.ceil(page / (double) pageRange);
        // 시작페이지
        int startPage = (currentGroup - 1) * pageRange + 1;
        // 끝페이지
        int endPage = Math.min(currentGroup * pageRange, totalPageCount);


        // 인기포스트 오늘의 베스트 글 가져오기
        List<BoardDTO> todayBestPosts = service.getTodayBestPopularPosts();

        // 인기포스트 주간 베스트 글 가져오기
        List<BoardDTO> weeklyBestPosts = service.getWeeklyBestPopularPosts();


        model.addAttribute("files", files);
        model.addAttribute("fileList", files);
        model.addAttribute("weeklyBestPosts", weeklyBestPosts);
        model.addAttribute("todayBestPosts", todayBestPosts);
        model.addAttribute("hasNextGroup", endPage < totalPageCount);
        model.addAttribute("hasPreviousGroup", startPage > 1);
        model.addAttribute("startPage", startPage);
        model.addAttribute("endPage", endPage);
        model.addAttribute("totalPageCount", totalPageCount);
        model.addAttribute("currentPage", page);
        model.addAttribute("popularPosts", popularPosts);
        return "board/view";
    }

    @GetMapping("/free.do")
    public String freeView(@RequestParam(defaultValue = "1") int page, Model model) { // 자유게시판
        String table_type = "자유게시판";
        //자유게시판 디비 가져오기
        ArrayList<BoardDTO> list = service.getBoardList(page, table_type);

        //  모든 첨부파일 가져오기
        List<FileResponse> files = service.getAllFiles();

        //페이징 작업
        // 총 게시물 개수
        int totalCount = service.getTotalFreeBoardCount(table_type);
        // 한 페이지 게시물수 10
        int pageRange = service.getPageRange();
        // 페이지 사이즈  1~10
        int pageSize = service.getPageSize();
        // 총 페이지 개수
        int totalPageCount = (int) Math.ceil(totalCount / (double) pageSize);

        //현재 페이지가 속한 페이지 범위
        int currentGroup = (int) Math.ceil(page / (double) pageRange);
        // 시작페이지
        int startPage = (currentGroup - 1) * pageRange + 1;
        // 끝페이지
        int endPage = Math.min(currentGroup * pageRange, totalPageCount);


        // 자유게시판 오늘의 베스트 글 가져오기
        List<BoardDTO> todayBestPosts = service.getTodayBestPosts(table_type);

        // 자유게시판 주간 베스트 글 가져오기
        List<BoardDTO> weeklyBestPosts = service.getWeeklyBestPosts(table_type);


        model.addAttribute("weeklyBestPosts", weeklyBestPosts);
        model.addAttribute("todayBestPosts", todayBestPosts);
        model.addAttribute("hasNextGroup", endPage < totalPageCount);
        model.addAttribute("hasPreviousGroup", startPage > 1);
        model.addAttribute("startPage", startPage);
        model.addAttribute("endPage", endPage);
        model.addAttribute("totalPageCount", totalPageCount);
        model.addAttribute("currentPage", page);
        model.addAttribute("files", files);
        model.addAttribute("freeBoardList", list);

        return "board/freeboard";
    }


    @GetMapping("/create")
    public String createForm() {  //글작성 폼

        return "board/create";
    }

    @PostMapping("/create")  //보드 글쓰기
    public String create(@Valid BoardForm dto, BindingResult bindingResult, HttpServletRequest request,RedirectAttributes redirectAttributes) throws IOException {
        if (bindingResult.hasErrors()) {
            return "board/create";
        }

        HttpSession session = request.getSession();
        MemberDTO loginMember = (MemberDTO) session.getAttribute(LOGIN_MEMBER);


        dto.setUser_seq(loginMember.getUser_seq());


        //글쓰기
        service.create(dto);





        return "redirect:/board/free.do";
    }

    @GetMapping("/read") //글읽기 메서드
    public String read(@RequestParam("board_seq") String seq, Model model) {

        //읽어올 게시판 가져오기 (해당 시퀀스번호넣고)
        BoardDTO board = service.getBoardBySeq(seq);
        // 첨부파일 가져오기
       List<FileResponse> files = service.getFiles(seq);


        System.out.println("files = " + files.toString());

        //게시물 작성자 정보 가져오기
        MemberDTO writer = service.getUserInfo(seq);


        // 조회수 증가
        service.incrementViews(seq);

        // 댓글 가져오기
        ArrayList<CommentDTO> commentList = service.getCommentBySeq(seq);
        List<CommentDTO> bestCommentList = service.getBestComment(seq);


        model.addAttribute("files", files);
        model.addAttribute("bestCommentList", bestCommentList);
        model.addAttribute("memberdto", writer);
        model.addAttribute("commentList", commentList);
        model.addAttribute("seq", seq);
        model.addAttribute("board", board);

        return "board/read";
    }


    @PostMapping("/likesCount") //  추천 ajax 처리
    public ResponseEntity<?> updateLikesCount(@RequestBody BoardDTO likes, @RequestParam("seq") String seq, HttpServletRequest request) {

        int like = likes.getLikes();

        // 로그인 유저 세션 가져오기
        HttpSession session = request.getSession(false);

        // 로그인 한 상태인지 확인
        if (session == null || session.getAttribute(LOGIN_MEMBER) == null) {
            return ResponseEntity.ok().body("login");
        }

        MemberDTO loginMember = (MemberDTO) session.getAttribute(LOGIN_MEMBER);


        // 좋아요수 추가하기
        int result = service.updateLikes(like, seq, loginMember);

        if (result > 0) {
            return ResponseEntity.ok().body("success");
        } else {
            return ResponseEntity.badRequest().body("failure");
        }
    }

    @PostMapping("/dislikesCount") // 비추
    public ResponseEntity<?> updateDislikesCount(@RequestBody BoardDTO dislikes, @RequestParam("seq") String seq, HttpServletRequest request) {

        int dislike = dislikes.getDislikes();

        // 로그인 유저 세션 가져오기
        HttpSession session = request.getSession();

        //로그인 했는지 확인
        MemberDTO loginMember = (MemberDTO) session.getAttribute(LOGIN_MEMBER);
        if (session == null || loginMember == null) {
            return ResponseEntity.ok().body("login");
        }

        int result = service.updateDislikes(dislike, seq, loginMember);

        if (result > 0) {
            return ResponseEntity.ok().body("success");
        } else {
            return ResponseEntity.badRequest().body("failure");
        }
    }


    @GetMapping("/likesRead") //추천수 ajax 처리
    public ResponseEntity<Integer> readLikes(@RequestParam("seq") String seq) {

        int updateLikes = service.getLikes(seq);


        return ResponseEntity.ok().body(updateLikes);
    }

    @GetMapping("/disLikesRead") // 비추천수 ajax 처리
    public ResponseEntity<Integer> readDislikes(@RequestParam("seq") String seq) {

        int updateDislikes = service.getDislikes(seq);


        return ResponseEntity.ok().body(updateDislikes);
    }


    @PostMapping("/comment/likesCount") //  댓  추천 ajax 처리
    public ResponseEntity<?> updateCommentLikesCount(@RequestBody CommentDTO likes, @RequestParam("seq") String seq, HttpServletRequest request) {

        int like = likes.getLikes();


        // 로그인 유저 세션 가져오기
        HttpSession session = request.getSession();

        // 로그인 한 상태인지 확인
        MemberDTO loginMember = (MemberDTO) session.getAttribute(LOGIN_MEMBER);
        if (session == null && loginMember == null) {
            return ResponseEntity.badRequest().body("login");
        }

        int result = service.updateCommentLikes(like, seq);


        if (result > 0) {
            return ResponseEntity.ok().body("success");
        } else {
            return ResponseEntity.badRequest().body("failure");
        }
    }


    @PostMapping("/comment/dislikesCount") //댓글 비추
    public ResponseEntity<?> updateCommentDislikesCount(@RequestBody BoardDTO dislikes, @RequestParam("seq") String seq, HttpServletRequest request) {

        int dislike = dislikes.getDislikes();

        int result = service.updateCommentDislikes(dislike, seq);

        // 로그인 유저 세션 가져오기
        HttpSession session = request.getSession();

        // 로그인 한 상태인지 확인
        MemberDTO loginMember = (MemberDTO) session.getAttribute(LOGIN_MEMBER);
        if (session == null && loginMember == null) {
            return ResponseEntity.badRequest().body("login");
        }

        if (result > 0) {
            return ResponseEntity.ok().body("success");
        } else {
            return ResponseEntity.badRequest().body("failure");
        }
    }


    @GetMapping("/comment/likesRead") // 댓글 추천수 ajax 처리
    public ResponseEntity<Integer> readCommentLikes(@RequestParam("seq") String seq) {

        int updateLikes = service.getCommentLikes(seq);


        return ResponseEntity.ok().body(updateLikes);
    }

    @GetMapping("/comment/disLikesRead") //  댓글 비추천수 ajax 처리
    public ResponseEntity<Integer> readCommentDislikes(@RequestParam("seq") String seq) {

        int updateDislikes = service.getCommentDislikes(seq);

//        String updateLikes2 = String.valueOf(updateLikes);

        return ResponseEntity.ok().body(updateDislikes);
    }

    @PostMapping("/comment/write") // 댓글쓰기
    public String write(String content, String seq, HttpServletRequest request, @RequestParam(defaultValue = "/") String redirectURL) {

        HttpSession session = request.getSession();

        MemberDTO memberDTO = (MemberDTO) session.getAttribute(LOGIN_MEMBER);


        service.insertComment(content, seq, memberDTO.getUser_seq());

        return "redirect:" + redirectURL;
    }

    @GetMapping("/item")
    public String itemShop(Model model, HttpServletRequest request) { // 아이템샵

        // 아이콘 리스트 가져오기
        ArrayList<IconDTO> iconList = service.getIconList();

        // 로그인한 유저가 가지고 있는 아이콘 리스트 가져오기
        HttpSession session = request.getSession();

        MemberDTO loginMember = (MemberDTO) session.getAttribute(LOGIN_MEMBER);

        if (loginMember != null) {
            ArrayList<IconDTO> userIconList = service.getUserIconList(loginMember.getUser_seq());
        }


        model.addAttribute("dto", loginMember);
        model.addAttribute("iconList", iconList);
        return "board/item";
    }

    @PostMapping("/item/buy")
    public String itemBuy(String member_seq, String icon_seq, String pic, String icon_price, HttpServletRequest request, RedirectAttributes redirectAttributes) { // 아이콘 구매
        //해당유저의 포인트
        Long money = service.getUserMoney(member_seq);

        // 포인트 부족시
        if (money < Long.valueOf(icon_price)) {
            redirectAttributes.addAttribute("errorMessage", "포인트가 부족합니다. 충전 후 다시 시도해주세요");
            return "redirect:/board/item";
        }
        if (service.hasUserIcon(member_seq, icon_seq)) {
            redirectAttributes.addAttribute("errorMessage", "이미 구매한 아이콘 입니다.");
            return "redirect:/board/item";
        }


        // 디비에 저장
        int result = service.insertIcon(member_seq, icon_seq);

        //금액 빼기
        service.deductAmount(member_seq, icon_price);

        //아이콘 바로적용
        service.updateUserIcon(pic, member_seq, request);


        return "redirect:/board/item";
    }

    @GetMapping("/search") // 검색결과
    public String search(String word, @RequestParam(defaultValue = "1") int page, Model model) {

        // 검색 결과 글들
        List<BoardDTO> searchResults = service.getBoardByWord(word, page);


        //  모든 첨부파일 가져오기
        List<FileResponse> files = service.getAllFiles();

        //페이징 작업
        //  검색한  게시물 개수
        int totalCount = service.getTotalBoardCount(word);
        // 한 페이지 게시물수 10
        int pageRange = service.getPageRange();
        // 페이지 사이즈  1~10
        int pageSize = service.getPageSize();
        // 총 페이지 개수
        int totalPageCount = (int) Math.ceil(totalCount / (double) pageSize);

        //현재 페이지가 속한 페이지 범위
        int currentGroup = (int) Math.ceil(page / (double) pageRange);
        // 시작페이지
        int startPage = (currentGroup - 1) * pageRange + 1;
        // 끝페이지
        int endPage = Math.min(currentGroup * pageRange, totalPageCount);


        model.addAttribute("hasNextGroup", endPage < totalPageCount);
        model.addAttribute("hasPreviousGroup", startPage > 1);
        model.addAttribute("startPage", startPage);
        model.addAttribute("endPage", endPage);
        model.addAttribute("totalPageCount", totalPageCount);
        model.addAttribute("currentPage", page);
        model.addAttribute("files", files);
        model.addAttribute("searchResults", searchResults);

        return "board/search";
    }


    @GetMapping("/anonymous")
    public String anonymousView(@RequestParam(defaultValue = "1") int page, Model model) { // 자유게시판
        String table_type = "익명게시판";
        //자유게시판 디비 가져오기
        ArrayList<BoardDTO> list = service.getBoardList(page, table_type);

        //  모든 첨부파일 가져오기
        List<FileResponse> files = service.getAllFiles();

        //페이징 작업
        // 총 게시물 개수
        int totalCount = service.getTotalFreeBoardCount(table_type);
        // 한 페이지 게시물수 10
        int pageRange = service.getPageRange();
        // 페이지 사이즈  1~10
        int pageSize = service.getPageSize();
        // 총 페이지 개수
        int totalPageCount = (int) Math.ceil(totalCount / (double) pageSize);

        //현재 페이지가 속한 페이지 범위
        int currentGroup = (int) Math.ceil(page / (double) pageRange);
        // 시작페이지
        int startPage = (currentGroup - 1) * pageRange + 1;
        // 끝페이지
        int endPage = Math.min(currentGroup * pageRange, totalPageCount);


        // 익명게시판 오늘의 베스트 글 가져오기
        List<BoardDTO> todayBestPosts = service.getTodayBestPosts(table_type);

        // 익명게시판 주간 베스트 글 가져오기
        List<BoardDTO> weeklyBestPosts = service.getWeeklyBestPosts(table_type);


        model.addAttribute("weeklyBestPosts", weeklyBestPosts);
        model.addAttribute("todayBestPosts", todayBestPosts);
        model.addAttribute("hasNextGroup", endPage < totalPageCount);
        model.addAttribute("hasPreviousGroup", startPage > 1);
        model.addAttribute("startPage", startPage);
        model.addAttribute("endPage", endPage);
        model.addAttribute("totalPageCount", totalPageCount);
        model.addAttribute("currentPage", page);
        model.addAttribute("files", files);
        model.addAttribute("freeBoardList", list);

        return "board/anonymous";
    }


    @GetMapping("/read/an") //  익명게시판 읽기 메서드
    public String readen(@RequestParam("board_seq") String seq, Model model) {

        //읽어올 게시판 가져오기 (해당 시퀀스번호넣고)
        BoardDTO board = service.getBoardBySeq(seq);
        // 첨부파일 가져오기
        List<FileResponse> files = service.getFiles(seq);


        //게시물 작성자 정보 가져오기
        MemberDTO writer = service.getUserInfo(seq);


        // 조회수 증가
        service.incrementViews(seq);


        // 댓글 가져오기
        ArrayList<CommentDTO> commentList = service.getCommentBySeq(seq);

        model.addAttribute("files", files);
        model.addAttribute("memberdto", writer);
        model.addAttribute("commentList", commentList);
        model.addAttribute("seq", seq);
        model.addAttribute("board", board);

        return "board/anonymousread";
    }


    @GetMapping("/study")
    public String studyForm(@RequestParam(defaultValue = "1") int page, Model model) { // 공부게시판
        String table_type = "공부게시판";
        //자유게시판 디비 가져오기
        ArrayList<BoardDTO> list = service.getBoardList(page, table_type);

        //  모든 첨부파일 가져오기
        List<FileResponse> files = service.getAllFiles();

        //페이징 작업
        // 총 게시물 개수
        int totalCount = service.getTotalFreeBoardCount(table_type);
        // 한 페이지 게시물수 10
        int pageRange = service.getPageRange();
        // 페이지 사이즈  1~10
        int pageSize = service.getPageSize();
        // 총 페이지 개수
        int totalPageCount = (int) Math.ceil(totalCount / (double) pageSize);

        //현재 페이지가 속한 페이지 범위
        int currentGroup = (int) Math.ceil(page / (double) pageRange);
        // 시작페이지
        int startPage = (currentGroup - 1) * pageRange + 1;
        // 끝페이지
        int endPage = Math.min(currentGroup * pageRange, totalPageCount);


        // 익명게시판 오늘의 베스트 글 가져오기
        List<BoardDTO> todayBestPosts = service.getTodayBestPosts(table_type);

        // 익명게시판 주간 베스트 글 가져오기
        List<BoardDTO> weeklyBestPosts = service.getWeeklyBestPosts(table_type);


        model.addAttribute("weeklyBestPosts", weeklyBestPosts);
        model.addAttribute("todayBestPosts", todayBestPosts);
        model.addAttribute("hasNextGroup", endPage < totalPageCount);
        model.addAttribute("hasPreviousGroup", startPage > 1);
        model.addAttribute("startPage", startPage);
        model.addAttribute("endPage", endPage);
        model.addAttribute("totalPageCount", totalPageCount);
        model.addAttribute("currentPage", page);
        model.addAttribute("files", files);
        model.addAttribute("freeBoardList", list);

        return "board/study";
    }


    @GetMapping("/dating")
    public String datingForm(@RequestParam(defaultValue = "1") int page, Model model) { // 연애게시판
        String table_type = "연애게시판";
        //자유게시판 디비 가져오기
        ArrayList<BoardDTO> list = service.getBoardList(page, table_type);

        //  모든 첨부파일 가져오기
        List<FileResponse> files = service.getAllFiles();

        //페이징 작업
        // 총 게시물 개수
        int totalCount = service.getTotalFreeBoardCount(table_type);
        // 한 페이지 게시물수 10
        int pageRange = service.getPageRange();
        // 페이지 사이즈  1~10
        int pageSize = service.getPageSize();
        // 총 페이지 개수
        int totalPageCount = (int) Math.ceil(totalCount / (double) pageSize);

        //현재 페이지가 속한 페이지 범위
        int currentGroup = (int) Math.ceil(page / (double) pageRange);
        // 시작페이지
        int startPage = (currentGroup - 1) * pageRange + 1;
        // 끝페이지
        int endPage = Math.min(currentGroup * pageRange, totalPageCount);


        // 익명게시판 오늘의 베스트 글 가져오기
        List<BoardDTO> todayBestPosts = service.getTodayBestPosts(table_type);

        // 익명게시판 주간 베스트 글 가져오기
        List<BoardDTO> weeklyBestPosts = service.getWeeklyBestPosts(table_type);


        model.addAttribute("weeklyBestPosts", weeklyBestPosts);
        model.addAttribute("todayBestPosts", todayBestPosts);
        model.addAttribute("hasNextGroup", endPage < totalPageCount);
        model.addAttribute("hasPreviousGroup", startPage > 1);
        model.addAttribute("startPage", startPage);
        model.addAttribute("endPage", endPage);
        model.addAttribute("totalPageCount", totalPageCount);
        model.addAttribute("currentPage", page);
        model.addAttribute("files", files);
        model.addAttribute("freeBoardList", list);

        return "board/dating";
    }

    @PostMapping("/delete")
    public String boardDelete(String board_seq) {

        // 글삭제
        service.deleteBoard(board_seq);

        return "redirect:/board/view.do";
    }

    @GetMapping("/edit")
    public String boardEditForm(String board_seq, Model model) {

        // 수정할떄 넘겨줄 작성했던 글내용
        BoardDTO dto = service.getBoardBySeq(board_seq);


        model.addAttribute("seq", board_seq);
        model.addAttribute("dto", dto);
        return "board/edit";
    }

    @PostMapping("/edit")
    public String boardEdit(BoardForm dto) {

        // 글수정
        service.updateBoard(dto);

        return "redirect:/board/read?board_seq=" + dto.getBoard_seq();
    }
}
