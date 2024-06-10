package com.example.soloproject.board.mapper;

import com.example.soloproject.board.UploadFile;
import com.example.soloproject.board.domain.*;
import com.example.soloproject.member.domain.MemberDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Mapper
public interface BoardMapper {
    ArrayList<BoardDTO> getBoardList(Map<String, Object> params);

    void create(BoardForm dto);

    BoardDTO getBoardBySeq(String seq);

    int updateLikes(int likes, String seq);

    int getLikes(String seq);

    int updateDislikes(int dislike, String seq);

    int getDislikes(String seq);

    ArrayList<CommentDTO> getCommentBySeq(String seq);

    int updateCommentLikes(int like, String seq);

    int updateCommentDislikes(int dislike, String seq);

    int getCommentLikes(String seq);

    int getCommentDislikes(String seq);

    void insertComment(String content, String seq, String user_seq);

    ArrayList<IconDTO> getIconList();

    int insertIcon(String member_seq, String icon_seq);

    void updateUserIcon(String pic, String seq);

    MemberDTO getMember(String seq);

    ArrayList<IconDTO> getUserIconList(String seq);

    List<BoardDTO> getPostsWithMoreThanTenLikes();

    void insertPopularPosts(String seq);

    List<BoardDTO> getPopularPosts(Map<String, Integer> params);

    Integer existInPopularPosts(String seq);

    Integer checkLikeExist(String board_seq, String user_seq);

    void addLike(String board_seq,String user_seq);

    int checkDislikeExist(String board_seq, String user_seq);

    void addDislike(String board_seq,String user_seq);

    void incrementViews(String seq);

    MemberDTO getUserInfo(String seq);

    void saveFileAttachment(String uploadFileName, String storeFileName, Long boardSeq, String attachment);

    Long getBoardSeq();

    List<UploadFile> getFiles(String seq);


    List<UploadFile> getFileList();

    int getTotalBoardCount(String word);


    List<BoardDTO> getTodayBestPosts(String table_type);

    List<BoardDTO> getWeeklyBestPosts(String tableType);

    List<BoardDTO> getTodayBestPopularPosts();

    List<BoardDTO> getWeeklyBestPopularPosts();

    int getTotalPopularPostsCount();

    List<BoardDTO> getBoardByWord(Map<String, Object> params);

    int getTotalFreeBoardCount(String table_type);

    int isCommentLikeExist(String boardSeq, String userSeq);

    Long getUserSeq(MemberDTO loginMember);

    Long getUserMoney(String userSeq);

    void deductAmount(String user_seq, String icon_price);

    int hasUserIcon(String user_seq, String icon_seq);

    void deleteBoard(String board_seq);

    void updateBoard(BoardForm dto);

    List<CommentDTO> getBestComment(String seq);

    List<UploadFile> getAllFiles();

}
