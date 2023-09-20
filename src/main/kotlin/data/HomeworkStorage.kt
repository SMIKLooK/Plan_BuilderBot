package data

import helpers.storage.StorageShell
import helpers.storage.jdbc_wrapping.DatabaseHelper
import logs.Logging
import java.sql.SQLException

interface HomeworkStorage : StorageShell {

    fun lastHomeworkForChat(chatId: Long): Homework

    fun insertHomework(homework: Homework)

    class Base private constructor(
        private val mTableName: String,
        private val mDatabase: DatabaseHelper
    ) : HomeworkStorage {

        override fun lastHomeworkForChat(chatId: Long): Homework {
            var homework: Homework? = null
            mDatabase.executeQuery(
                "SELECT * FROM $mTableName WHERE chat_id = $chatId ORDER BY creation_date DESC LIMIT 1"
            ) { item, _ ->
                homework = try {
                    Homework(item)
                } catch (e: SQLException) {
                    null
                }
            }
            return homework ?: throw Exception()
        }

        override fun insertHomework(homework: Homework) {
            try {
                mDatabase.executeQueryWithoutResult(homework.insertSQLQuery(mTableName))
            } catch (e: SQLException) {
                Logging.ConsoleLog.log(e.message ?: "")
            }
        }

        override fun tableName() = mTableName

        override fun tableSchema() = "CREATE TABLE $mTableName(" +
                "id int primary key auto_increment," +
                "homework_text varchar(512)," +
                "created_user bigint," +
                "chat_id bigint," +
                "is_sent bool," +
                "next_date_publish bigint," +
                "creation_date bigint" +
                ");"

        object Instance {
            private var mInstance: HomeworkStorage? = null

            fun create(tableName: String, databaseHelper: DatabaseHelper) {
                if (mInstance == null) {
                    mInstance = Base(tableName, databaseHelper)
                }
            }

            operator fun invoke() = mInstance ?: throw Exception()
        }
    }
}