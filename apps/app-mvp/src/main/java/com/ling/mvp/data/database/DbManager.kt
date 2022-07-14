package com.ling.mvp.data.database

import android.util.Log
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.ling.utils.Utils

/**
 * author : wangchengzhen
 * time   : 2022/7/8
 * desc   : 数据管理类封装 - 数据库管理工具
 * Room 包含三个主要组件
 *  1.数据实体（Entities），用于表示应用的数据库中的表
 *  2.数据访问对象 (Data Access Objects【Dao】)，提供您的应用可用于查询、更新、插入和删除数据库中的数据的方法
 *  3.数据库类（Room Database），用于保存数据库并作为应用持久性数据底层连接的主要访问点
 */
object DbManager {

    /** 数据库名 */
    private const val dbName = "zroom"

    /** 懒加载创建数据库 */
    val db: AppDatabase by lazy {
        Room.databaseBuilder(Utils.getApp(), AppDatabase::class.java, dbName)
            // 允许在主线程操作
            .allowMainThreadQueries()
            // 增加回调监听
            .addCallback(DbCreateCallback)
            // 增加数据库迁移
            .addMigrations(DbMigration)
            .build()
    }

    /**
     * 回调监听
     */
    private object DbCreateCallback : RoomDatabase.Callback() {

        /**
         * 第一次创建数据库时调用
         */
        override fun onCreate(db: SupportSQLiteDatabase) {
            super.onCreate(db)
            Log.e("DbCreateCallback", "first onCreate db version: ${db.version}")
        }
    }

    /**
     * 数据库升级
     */
    private object DbMigration : Migration(1, 2) {

        override fun migrate(database: SupportSQLiteDatabase) {
            Log.e("DbMigration", "执行数据库升级 migrate")
        }
    }
}
