fun main() {
    val outputFilename = "output.html"
    val mess = Message("kuzneczov-f@susanoo.ru", "Test E-mail", "Hello, World!🌏", null)

    println("HTML dump to file: ${mess.toHtmlFile(outputFilename)}")
}
