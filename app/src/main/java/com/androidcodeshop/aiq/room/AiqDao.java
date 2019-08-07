package com.androidcodeshop.aiq.room;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.androidcodeshop.aiq.model.QuestionAnswerModel;

import java.util.List;

@Dao
public interface AiqDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(QuestionAnswerModel questionAnswerModel);

    @Query("UPDATE AIQ_TABLE SET bookmarked = :bookm WHERE questionNumber = :quesNumber")
    void replaceBookmark(int quesNumber, int bookm);

    @Query("SELECT * from AIQ_TABLE")
    List<QuestionAnswerModel> getAllQuestionAnswers();

    @Query("SELECT * from AIQ_TABLE LIMIT 1")
    List<QuestionAnswerModel> getOne();
}
