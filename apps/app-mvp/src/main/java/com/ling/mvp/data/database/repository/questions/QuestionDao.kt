package com.ling.mvp.data.database.repository.questions

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

/**
 * author : wangchengzhen
 * time   : 2022/7/8
 * desc   : QuestionsDao - 数据访问对象 （DAO）创建
 */
@Dao
interface QuestionDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(questions: List<Question>)

    @Query("SELECT * FROM question")
    fun loadAll(): List<Question>
}
