package domain.book

case class Book(id: BookId, name: BookName, isbn: Isbn, genre: Genre, language: Language)

case class BookId(value: String)

case class BookName(value: String)

case class Isbn(value: String)

sealed trait Genre

case object Novel extends Genre

case object Comic extends Genre

sealed trait Language

case object Japanese extends Language

case object English extends Language
