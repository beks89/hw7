package ru.netology.exceptions

class PostNotFoundException(message: String = "Пост не найден") : RuntimeException(message)