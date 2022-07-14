package com.ling.mvp.data.database.repository.options

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

/**
 * author : wangchengzhen
 * time   : 2022/7/8
 * desc   : OptionDao - 数据访问对象 （DAO）创建
 */
@Dao
interface OptionDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(options: List<Option>)

    @Query("SELECT * FROM option WHERE question_id = :questionId")
    fun loadOptionsByQuestionId(questionId: Long): List<Option>

    @Query("SELECT * FROM option")
    fun loadAll(): List<Option>
}
