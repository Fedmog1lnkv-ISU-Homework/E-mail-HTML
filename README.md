# Генерация HTML кода для сообщения электронной почты

Класс `Message` описывает сообщение электронной почты. Дополнен двумя полями `additionalField1` и `additionalField2` по
смыслу на усмотрение (1). Модифицирован код функции `toHTML()` таким образом, чтобы строки с пустыми (null) полями не
вставлялись в HTML код (2). Для этого использованы операторы `let`, `also` и `with`. Код HTML также дополнен стилями для
цветов, шрифтов и отступов (3).

Примеры использования операторов:
[DigitalOcean Tutorial](https://www.digitalocean.com/community/tutorials/kotlin-let-run-also-apply-with)

Документация:
[Kotlin Scope Functions](https://kotlinlang.org/docs/scope-functions.html)

![example.png](raw%2Fexample.png)