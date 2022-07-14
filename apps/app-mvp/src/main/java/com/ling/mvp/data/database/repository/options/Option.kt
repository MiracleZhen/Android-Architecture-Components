package com.ling.mvp.data.database.repository.options

import androidx.room.*
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.ling.mvp.data.database.repository.questions.Question

/**
 * author : wangchengzhen
 * time   : 2022/7/8
 * desc   : 实体类 Option
 */
@Entity(tableName = "option", foreignKeys = [(ForeignKey(entity = Question::class,
    parentColumns = arrayOf("id"),
    childColumns = arrayOf("question_id"),
    onDelete = ForeignKey.CASCADE))],
    indices = [Index(value = ["id"], unique = true), Index(value = ["question_id"])])
data class Option(

    @PrimaryKey(autoGenerate = true)
    var id: Long,

    @Expose
    @SerializedName("option_text")
    @ColumnInfo(name = "option_text")
    var optionText: String,

    @Expose
    @SerializedName("is_correct")
    @ColumnInfo(name = "is_correct")
    var isCorrect: Boolean,

    @Expose
    @SerializedName("question_id")
    @ColumnInfo(name = "question_id")
    var questionId: Long,

    @Expose
    @SerializedName("created_at")
    @ColumnInfo(name = "created_at")
    var createdAt: String?,

    @Expose
    @SerializedName("updated_at")
    @ColumnInfo(name = "updated_at")
    var updatedAt: String?
)
