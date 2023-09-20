import data.Homework
import executables.Executable
import executables.SendMessage

class HomeworkMessage(
    private val mKey: String
) : Homework.Mapper<Executable> {
    override fun map(
        id: Int,
        homeworkText: String,
        createdUser: Long,
        chatId: Long,
        isSent: Boolean,
        nextDatePublish: Long,
        creationDate: Long
    ): Executable {
        return SendMessage(
            mKey,
            homeworkText
        )
    }
}