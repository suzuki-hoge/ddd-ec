package api.book.search.form

import domain.book._
import domain.book.search._

case object FilterForms {
  def bind(genre: String, language: String): Filter = {
    Filter(GenreForm.bind(genre), LanguageForm.bind(language))
  }
}

case object GenreForm {
  def bind(value: String): Option[Genre] = value match {
    case "novel" => Some(Novel)
    case "comic" => Some(Comic)
    case "" => None
 }
}

case object LanguageForm {
  def bind(value: String): Option[Language] = value match {
    case "japanese" => Some(Japanese)
    case "english" => Some(English)
    case "" => None
  }
}

