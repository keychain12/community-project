package com.example.soloproject.board.service;

import com.example.soloproject.board.*;
import com.example.soloproject.board.domain.*;
import com.example.soloproject.board.repository.BoardRepository;
import com.example.soloproject.member.domain.MemberDTO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static com.example.soloproject.member.SessionConst.LOGIN_MEMBER;

@Service
@RequiredArgsConstructor
public class BoardService {
    public static final int PAGE_SIZE = 10; // 한페이지에 표시할 게시물수
    public static final int PAGE_RANGE = 10; // 페이지 범위 크기

    private final BoardRepository repository;


    private final S3Uploader s3Uploader;

    @Transactional
    public List<BoardDTO> getPopularPosts(int page) {  // 인기글 가져오기
        int offset = (page - 1) * PAGE_SIZE;
        Map<String,Integer> params = new HashMap<>();
        params.put("offset", offset);
        params.put("limit", PAGE_SIZE);

        // 추천수가 10개 넘은 게시물들 가져오
        List<BoardDTO> boardList = repository.getPostsWithMoreThanTenLikes();

        // 추천수 10 개가 넘은게 없을경우 예외 던지기
        if (boardList.isEmpty()) {
            throw new IllegalArgumentException("Invalid post id");
        }

        // 추천수 10개 넘은 게시물 인기포스트 디비에 저장하기
        for (BoardDTO candidate : boardList) {
            // 인기포스트에 이미 있는지 중복확인
            if (repository.existInPopularPosts(candidate.getBoard_seq()) == 0) {
                repository.insertPopularPosts(candidate.getBoard_seq());
            }
        }


        // 인기 포스트 넘기기
        return repository.getPopularPosts(params);
    }


    public ArrayList<BoardDTO> getBoardList(int page, String table_type) { // 보드리스트
        int offset = (page - 1) * PAGE_SIZE;
        Map<String,Object> params = new HashMap<>();
        params.put("offset", offset);
        params.put("limit", PAGE_SIZE);
        params.put("table_type", table_type);

        return repository.getBoardList(params);
    }

    public void create(BoardForm dto) throws IOException {

            // xss 방지 입력 필터링
            String sanitizedTitle = InputSanitizer.sanitize(dto.getTitle());
            String sanitizedContent = InputSanitizer.sanitize(dto.getContent());

            // 필터링 후 다시 설정
            dto.setTitle(sanitizedTitle);
            dto.setContent(sanitizedContent);

            // 보드 저장
            repository.create(dto);

            // 방금 저장한 보드 시퀀스 가져오기
            Long boardSeq = repository.getBoardSeq();

            // 파일 저장
               saveFiles(dto, boardSeq);


    }

    private void saveFiles(BoardForm dto, Long boardSeq) throws IOException {
        MultipartFile attachment = dto.getAttachment();
        List<MultipartFile> imageFiles = dto.getImageFiles();

        if (attachment != null && !attachment.isEmpty()) {
            String fileName = s3Uploader.upload(attachment, "attachments");
            repository.saveFileAttachment(attachment.getOriginalFilename(), fileName, boardSeq, FileType.ATTACHMENT);
        }

        if (imageFiles != null && !imageFiles.isEmpty()) {
            for (MultipartFile imageFile : imageFiles) {
                if (!imageFile.isEmpty()) {
                    String fileName = s3Uploader.upload(imageFile, "images");
                    repository.saveFileAttachment(imageFile.getOriginalFilename(), fileName, boardSeq, FileType.IMG);
                }
            }
        }
    }
    public List<FileResponse> getFiles(String seq) {

        List<UploadFile> files = repository.getFiles(seq);
        return files.stream().map(file -> new FileResponse(file.getOriginal_name(), s3Uploader.getFileUrl(file.getStored_name())))
                .collect(Collectors.toList());
    }


    public BoardDTO getBoardBySeq(String seq) {
        return repository.getBoardBySeq(seq);
    }

    // 좋아요 개수 증가 메서드
    public int updateLikes(int likes, String seq, MemberDTO loginMember) {

        // 해당 유저가 해당 게시물에 이미 좋아요 눌렀는지 체크
        if (checkLikeExist(seq, loginMember)) {
            return 0;   // 이미 추천 누른 게시물이면 0 을 리턴
        }

        String user_seq = String.valueOf(loginMember.getUser_seq());
        String board_seq = seq;

        // 좋아요 테이블에도 추가하기  ( 해당 유저가 해당 게시물에 좋아요 눌렀다는 테이블에 저장)
        repository.addLike(board_seq, user_seq);
        //Map.of는 Java 9에서 도입된 유틸리티 메서드로, 간단하고 읽기 쉬운 방식으로 불변(Map)을 생성하는 방법을 제공합니다.



        return repository.updateLikes(likes,seq);  //  아직 안눌렀다 그러면 게시물 좋아요수 업데이기
    }


    private boolean checkLikeExist(String seq, MemberDTO loginMember) {
        // 이미 좋아요 누른 게시물인지 체크
        int result =  repository.checkLikeExist(seq,loginMember.getUser_seq()); // 보드 , 유저 시퀀스 보내기

        return result > 0 ? true : false;
    }

    public int getLikes(String seq) {
        return repository.getLikes(seq);
    }

    //싫어요 업데이트
    public int updateDislikes(int dislike, String seq, MemberDTO loginMember) {
        // 이미 싫어요 누른 글이다 그럼 실패 0 리턴
        if (checkDislikeExist(seq, loginMember)) {
            return 0;
        }

        //처음 싫어요 누른거다

        repository.addDislike(seq, String.valueOf(loginMember.getUser_seq()));


        return repository.updateDislikes(dislike, seq);
    }

    //  싫어요 눌렀는지 체크
    private boolean checkDislikeExist(String seq, MemberDTO loginMember) {

        int result = repository.checkDislikeExist(seq, String.valueOf(loginMember.getUser_seq()));

        return result > 0 ? true : false;
    }

    public int getDislikes(String seq) {
        return repository.getDislikes(seq);
    }

    public ArrayList<CommentDTO> getCommentBySeq(String seq) {
        return repository.getCommentBySeq(seq);
    }

    public int updateCommentLikes(int like, String seq) {

        return repository.updateCommentLikes(like, seq);
    }



    public int updateCommentDislikes(int dislike, String seq) {
        return repository.updateCommentDislikes(dislike, seq);
    }

    public int getCommentLikes(String seq) {
        return repository.getCommentLikes(seq);
    }

    public int getCommentDislikes(String seq) {
        return repository.getCommentDislikes(seq);
    }



    public void insertComment(String content, String seq, String user_seq) {
        repository.insertComment(content, seq, user_seq);
    }

    public ArrayList<IconDTO> getIconList() {
        return repository.getIconList();
    }

    public int insertIcon(String member_seq, String icon_seq) {
        return repository.insertIcon(member_seq, icon_seq);
    }


    public void updateUserIcon(String pic, String seq, HttpServletRequest request) {
        repository.updateUserIcon(pic, seq);

        HttpSession session = request.getSession();

        MemberDTO member = repository.getMember(seq);

        session.setAttribute(LOGIN_MEMBER,member);

    }

    public ArrayList<IconDTO> getUserIconList(String seq) {
        return repository.getUserIconList(seq);
    }


    public void incrementViews(String seq) {
        repository.incrementViews(seq);
    }

    public MemberDTO getUserInfo(String seq) {
        return repository.getUserInfo(seq);
    }






    public List<UploadFile> getFileList() {
        return repository.getFileList();
    }

    public Map<String, String> getFirstImg(List<UploadFile> files) {
        Map<String,String> firstImg = new HashMap();
        for (int i = 0; i < files.size(); i++) {
            firstImg.put(files.get(i).getBoard_seq(), files.get(i).getStored_name());
        }
        return firstImg;
    }

    public int getTotalBoardCount(String word) {
        return repository.getTotalBoardCount(word);
    }





    public int getPageSize() {
        return PAGE_SIZE;
    }

    public int getPageRange() {
        return PAGE_RANGE;
    }

    public List<BoardDTO> getTodayBestPosts(String table_type) {
        return repository.getTodayBestPosts(table_type);
    }

    public List<BoardDTO> getWeeklyBestPosts(String tableType) {
        return repository.getWeeklyBestPosts(tableType);
    }

    public List<BoardDTO> getTodayBestPopularPosts() {

        return repository.getTodayBestPopularPosts();
    }

    public List<BoardDTO> getWeeklyBestPopularPosts() {

        return repository.getWeeklyBestPopularPosts();

    }

    public int getTotalPopularPostsCount() {
        return repository.getTotalPopularPostsCount();
    }

    public List<BoardDTO> getBoardByWord(String word, int page) {

        // xss 방지 입력 필터링
        String sanitizedWord = InputSanitizer.sanitize(word);


        int offset = (page - 1) * PAGE_SIZE;
        Map<String,Object> params = new HashMap<>();
        params.put("word", sanitizedWord);
        params.put("offset", offset);
        params.put("limit", PAGE_SIZE);

        return repository.getBoardByWord(params);
    }

    public int getTotalFreeBoardCount(String table_type) {
        return repository.getTotalFreeBoardCount(table_type);
    }


    public Long getUserMoney(String user_seq) {
        return repository.getUserMoney(user_seq);
    }

    public void deductAmount(String user_seq, String icon_price) {
        repository.deductAmount(user_seq, icon_price);
    }

    // 유저가 사려는 아이콘이 있는지 체크
    public boolean hasUserIcon(String memberSeq, String icon_seq) {

        int result = repository.hasUserIcon(memberSeq,icon_seq);

        return result > 0 ? true : false;
    }

    public void deleteBoard(String board_seq) {
        repository.deleteBoard(board_seq);
    }

    public void updateBoard(BoardForm dto) {
        repository.updateBoard(dto);
    }

    public List<CommentDTO> getBestComment(String seq) {

        return repository.getBestComment(seq);
    }

    public List<FileResponse> getAllFiles() {

        List<UploadFile> files = repository.getAllFiles();
        return files.stream().map(file -> new FileResponse(file.getOriginal_name(), s3Uploader.getFileUrl(file.getStored_name()),file.getBoard_seq()))
                .collect(Collectors.toList());

    }
}
