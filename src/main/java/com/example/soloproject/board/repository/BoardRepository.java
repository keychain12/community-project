package com.example.soloproject.board.repository;

import com.example.soloproject.board.UploadFile;
import com.example.soloproject.board.domain.*;
import com.example.soloproject.board.mapper.BoardMapper;
import com.example.soloproject.member.domain.MemberDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
@RequiredArgsConstructor
public class BoardRepository {
    private final BoardMapper mapper;

    public ArrayList<BoardDTO> getBoardList(Map<String, Object> params) {
        return mapper.getBoardList(params);
    }

    public void create(BoardForm dto) {
        mapper.create(dto);
    }


    public BoardDTO getBoardBySeq(String seq) {
        return mapper.getBoardBySeq(seq);
    }

    public int updateLikes(int likes, String seq) {

        return mapper.updateLikes(likes,seq);
    }

    public int getLikes(String seq) {
        return mapper.getLikes(seq);
    }

    public int updateDislikes(int dislike, String seq) {
        return mapper.updateDislikes(dislike, seq);
    }

    public int getDislikes(String seq) {
        return mapper.getDislikes(seq);
    }

    public ArrayList<CommentDTO> getCommentBySeq(String seq) {
        return mapper.getCommentBySeq(seq);
    }

    public int updateCommentLikes(int like, String seq) {
        return mapper.updateCommentLikes(like, seq);
    }

    public int updateCommentDislikes(int dislike, String seq) {
        return mapper.updateCommentDislikes(dislike, seq);
    }

    public int getCommentLikes(String seq) {
        return mapper.getCommentLikes(seq);
    }

    public int getCommentDislikes(String seq) {
        return mapper.getCommentDislikes(seq);
    }


    public void insertComment(String content, String seq, String user_seq) {
        mapper.insertComment(content, seq , user_seq);
    }

    public ArrayList<IconDTO> getIconList() {

        return mapper.getIconList();
    }

    public int insertIcon(String member_seq, String icon_seq) {
        return mapper.insertIcon(member_seq,icon_seq);
    }

    public void updateUserIcon(String pic, String seq) {
        mapper.updateUserIcon(pic,seq);
    }

    public MemberDTO getMember(String seq) {
        return mapper.getMember(seq);
    }

    public ArrayList<IconDTO> getUserIconList(String seq) {
        return mapper.getUserIconList(seq);
    }

    public List<BoardDTO> getPostsWithMoreThanTenLikes() {

        return mapper.getPostsWithMoreThanTenLikes();
    }

    public void insertPopularPosts(String seq) {
        mapper.insertPopularPosts(seq);
    }

    public List<BoardDTO> getPopularPosts(Map<String, Integer> params) {
        return mapper.getPopularPosts(params);
    }

    public Integer existInPopularPosts(String seq) {
        return mapper.existInPopularPosts(seq);
    }

    public Integer checkLikeExist(String board_seq, String user_seq) {
        return mapper.checkLikeExist(board_seq, user_seq);
    }


    public void addLike(String board_seq, String user_seq) {
        mapper.addLike(board_seq,user_seq);
    }

    public int checkDislikeExist(String board_seq, String user_seq) {
        return mapper.checkDislikeExist(board_seq, user_seq);

    }

    public void addDislike(String board_seq, String user_seq) {
        mapper.addDislike(board_seq, user_seq);
    }

    public void incrementViews(String seq) {
        mapper.incrementViews(seq);
    }

    public MemberDTO getUserInfo(String seq) {
        return mapper.getUserInfo(seq);
    }










    public void saveFileAttachment(String uploadFileName, String storeFileName, Long boardSeq, String attachment) {
        mapper.saveFileAttachment(uploadFileName,storeFileName,boardSeq,attachment);
    }


    public Long getBoardSeq() {
        return mapper.getBoardSeq();
    }

    public List<UploadFile> getFiles(String seq) {
        return mapper.getFiles(seq);
    }

    public List<UploadFile> getFileList() {
        return mapper.getFileList();
    }

    public int getTotalBoardCount(String word) {
        return mapper.getTotalBoardCount(word);
    }


    public List<BoardDTO> getTodayBestPosts(String table_type) {
        return mapper.getTodayBestPosts(table_type);
    }

    public List<BoardDTO> getWeeklyBestPosts(String tableType) {
        return mapper.getWeeklyBestPosts(tableType);
    }

    public List<BoardDTO> getTodayBestPopularPosts() {
        return mapper.getTodayBestPopularPosts();
    }

    public List<BoardDTO> getWeeklyBestPopularPosts() {
        return mapper.getWeeklyBestPopularPosts();

    }

    public int getTotalPopularPostsCount() {
        return mapper.getTotalPopularPostsCount();
    }

    public List<BoardDTO> getBoardByWord(Map<String, Object> params) {
        return mapper.getBoardByWord(params);
    }

    public int getTotalFreeBoardCount(String table_type) {

        return mapper.getTotalFreeBoardCount(table_type);
    }



    public Long getUserMoney(String user_seq) {
        return mapper.getUserMoney(user_seq);
    }

    public void deductAmount(String user_seq, String icon_price) {
        mapper.deductAmount(user_seq, icon_price);
    }

    public int hasUserIcon(String user_seq, String icon_seq) {
        return mapper.hasUserIcon(user_seq,icon_seq);
    }

    public void deleteBoard(String board_seq) {
        mapper.deleteBoard(board_seq);
    }

    public void updateBoard(BoardForm dto) {
        mapper.updateBoard(dto);
    }

    public List<CommentDTO> getBestComment(String seq) {
        return mapper.getBestComment(seq);
    }

    public List<UploadFile> getAllFiles() {

        return mapper.getAllFiles();
    }
}
