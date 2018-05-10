package v_builders

import util.TODO
import util.doc39
import v_builders.data.getProducts
import v_builders.htmlLibrary.*

fun getTitleColor() = "#b9c9fe"
fun getCellColor(row: Int, column: Int) = if ((row + column) %2 == 0) "#dce4ff" else "#eff2ff"

fun todoTask39(): Nothing = TODO(
    """
        Task 39.
        1) Fill the table with the proper values from products.
        2) Color the table like a chess board (using getTitleColor() and getCellColor() functions above).
        Pass a color as an argument to functions 'tr', 'td'.
        You can call the 'main' function in the 'htmlDemo.kt' to see the rendered table.
    """,
    documentation = doc39()
)

fun renderProductTable(): String {
    return html {
        table {
            tr {
                td(getTitleColor()) {
                    text("Product")
                }
                td(getTitleColor()) {
                    text("Price")
                }
                td(getTitleColor()) {
                    text("Popularity")
                }
            }
            val products = getProducts()
            for (i in products.indices) {
                tr {
                    td(getCellColor(i + 1, 0)) {
                        text(products[i].description)
                    }
                    td(getCellColor(i + 1, 1)) {
                        text(products[i].price)
                    }
                    td(getCellColor(i + 1, 2)) {
                        text(products[i].popularity)
                    }
                }
            }
        }
    }.toString()
}
