import java.io.File

data class Message(
    val address: String?,
    val topic: String?,
    val content: String?,
    val date: String?
) {
    fun toHTML(): String {
        var template =
            "<table style=\"font-family: Arial, sans-serif; border-collapse: collapse; width: 50%; margin: 20px;\">"

        template += generateRow("Address", address)
        template += generateRow("Date", date)
        template += generateRow("Topic", topic)
        template += generateRow("Content", content)

        template += "</table>"
        return template
    }

    private fun generateRow(label: String, value: String?): String {
        return if (!value.isNullOrBlank()) {
            "<tr><td style=\"border: 1px solid #dddddd; text-align: left; padding: 8px;\">$label</td><td style=\"border: 1px solid #dddddd; text-align: left; padding: 8px;\">$value</td></tr>\n"
        } else {
            ""
        }
    }


    fun toTemplate(): String {
        val html = this.toHTML()
        val templateFile = File("template.html")
        var template = templateFile.readText()
        template = template.replace("{{content}}", html)
        return template
    }

    fun toHtmlFile(filename: String): String {
        if (!filename.endsWith(".html", ignoreCase = true)) {
            throw IllegalArgumentException("Invalid file extension. File must have '.html' extension.")
        }

        val template = toTemplate()
        val outputFile = File(filename)
        outputFile.writeText(template)

        return outputFile.absolutePath
    }
}