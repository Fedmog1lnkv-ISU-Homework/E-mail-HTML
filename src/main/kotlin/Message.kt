import java.io.File

data class Message(
    val address: String?,
    val topic: String?,
    val content: String?,
    val date: String?
) {
    fun toHTML(): String = StringBuilder().apply {
        append("<table style=\"font-family: Arial, sans-serif; border-collapse: collapse; width: 50%; margin: 20px;\">")
        append(generateRow("Address", address))
        append(generateRow("Date", date))
        append(generateRow("Topic", topic))
        append(generateRow("Content", content))
        append("</table>")
    }.toString()

    private fun generateRow(label: String, value: String?): String =
        value.takeIf { !it.isNullOrBlank() }?.run {
            "<tr><td style=\"border: 1px solid #dddddd; text-align: left; padding: 8px;\">$label</td><td style=\"border: 1px solid #dddddd; text-align: left; padding: 8px;\">$this</td></tr>\n"
        } ?: ""

    fun toTemplate(): String = run {
        val html = toHTML()
        File("template.html").readText().replace("{{content}}", html)
    }

    fun toHtmlFile(filename: String): String = run {
        if (!filename.endsWith(".html", ignoreCase = true)) {
            throw IllegalArgumentException("Invalid file extension. File must have '.html' extension.")
        }

        val template = toTemplate()
        File(filename).apply {
            writeText(template)
        }.absolutePath
    }
}
