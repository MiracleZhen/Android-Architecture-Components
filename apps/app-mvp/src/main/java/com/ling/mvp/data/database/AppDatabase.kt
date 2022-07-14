package com.ling.mvp.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.ling.mvp.data.database.repository.options.Option
import com.ling.mvp.data.database.repository.options.OptionDao
import com.ling.mvp.data.database.repository.questions.Question
import com.ling.mvp.data.database.repository.questions.QuestionDao

/**
 * author : wangchengzhen
 * time   : 2022/7/8
 * desc   : AppDatabase - 数据库（Database）创建
 * blog   : Android Room 数据库最佳入门教程 (https://blog.csdn.net/Ae_fring/article/details/124723516)
 * entities: 实体类
 * version: 数据库初始版本号
 * exportSchema: 是否允许数据库架构将导出到给定的文件夹中【 默认true 】
 */
@Database(entities = [Question::class, Option::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun questionDao(): QuestionDao

    abstract fun optionDao(): OptionDao
}
