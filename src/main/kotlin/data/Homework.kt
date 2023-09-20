package data

import helpers.storage.Record
import java.sql.ResultSet

data class Homework(
    private val mId: Int,
    private val mHomeworkText: String,
    private val mCreatedUser: Long,
    private val mChatId: Long,
    private val mIsSent: Boolean,
    private val mNextDatePublish: Long,
    private val mCreationDate: Long
) : Record() {

    constructor(item: ResultSet) : this(
        item.getInt("id"),
        item.getString("homework_text"),
        item.getLong("created_user"),
        item.getLong("chat_id"),
        item.getBoolean("is_sent"),
        item.getLong("next_date_publish"),
        item.getLong("creation_date")
    )

    fun <T> map(mapper: Mapper<T>) = mapper.map(
        mId,
        mHomeworkText,
        mCreatedUser,
        mChatId,
        mIsSent,
        mNextDatePublish,
        mCreationDate
    )

    interface Mapper<T> {
        fun map(
            id: Int,
            homeworkText: String,
            createdUser: Long,
            chatId: Long,
            isSent: Boolean,
            nextDatePublish: Long,
            creationDate: Long
        ) : T
    }

    override fun deleteSQLQuery(tableName: String) = "DELETE FROM $tableName WHERE id = $mId"

    override fun insertSQLQuery(tableName: String) = "INSERT INTO $tableName (homework_text, created_user, chat_id," +
            " is_sent, next_date_publish, creation_date) VALUES('$mHomeworkText', $mCreatedUser, $mChatId," +
            " $mIsSent, $mNextDatePublish, $mCreationDate)"

    override fun updateSQLQuery(tableName: String) = "UPDATE $tableName SET homework_text = '$mHomeworkText'," +
            " created_user = $mCreatedUser, chat_id = $mChatId," +
            " is_sent = $mIsSent," +
            " next_date_publish = $mNextDatePublish, creation_date = $mCreationDate WHERE id = $mId"
}