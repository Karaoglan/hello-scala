package eu.burak.basket

/**
  * Created by bk on 03/06/2017.
  */
object Start {
  def main(args: Array[String]): Unit = {
    val customer = new Customer("burak", "karaoglan")
    println(customer.fullName)
    println(customer.fullName)
    val basket = new Basket(customer)
    val euroPrice = Price(699.99, "EUR")
    val product = new OnlineProduct("samsugn TV", euroPrice)
    basket.addItem(product)
    basket.addItem2(product)
    println(basket.getItems)

    println(euroPrice.toUSD)

    val Price(a, b) = euroPrice
    println(a)
    println(b)
  }
}

class Customer(firstName: String, lastName: String) {
  lazy val fullName = {
    println("before berechnung")
    s"$firstName $lastName"
  }
}

case class Price(value: Double, currency: String) {
  def toUSD: Price = copy(value = value * 1.07, currency = "USD")
}

abstract class Product(name: String, price: Price) {
  override def toString: String = s"$name $price"
}

class OnlineProduct(name: String, price: Price) extends Product(name, price) with Serializable

class Basket(customer: Customer) {
  private var items = List.empty[Product]

  def addItem(product: Product): Unit = items = product :: items
  def addItem2(product: Product): Unit = items ::= product
  def getItems: List[Product] = items
}
