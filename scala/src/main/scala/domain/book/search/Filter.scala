package domain.book.search

import domain.book.{Genre, Language}

case class Filter(genre: Option[Genre], language: Option[Language])

