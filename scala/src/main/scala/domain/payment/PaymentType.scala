package domain.payment

sealed trait PaymentType

case object PayWithCreditCard extends PaymentType

case object AtConvenienceStore extends PaymentType

case object AtReceived extends PaymentType
