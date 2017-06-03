package eu.burak.basket

/**
  * Created by bk on 02/06/2017.
  */
object Application {

  def main(args: Array[String]) = {
    var variable = 2
    variable += 3
    println(variable)
    val kostante = 2

    val text: String = "Text"
    var text2: String = "Text"

    var preis = 2
    lazy val lazyBespiel = preis
    preis += 3
    println(lazyBespiel)

    var `keyword var` = "text"
    println(`keyword var`)
  }

}
