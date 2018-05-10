package ii_collections

fun example2(list: List<Int>) {

    val isZero: (Int) -> Boolean = { it == 0 }

    val hasZero: Boolean = list.any(isZero)

    val allZeros: Boolean = list.all(isZero)

    val numberOfZeros: Int = list.count(isZero)

    val firstPositiveNumber: Int? = list.firstOrNull { it > 0 }
}

fun Customer.isFrom(city: City): Boolean {
    return this.city == city
}

fun Shop.checkAllCustomersAreFrom(city: City): Boolean {
    return this.customers.all { it.isFrom(city) }
}

fun Shop.hasCustomerFrom(city: City): Boolean {
    // Return true if there is at least one customer from the given city
    return this.customers.count { it.isFrom(city) } >= 1
}

fun Shop.countCustomersFrom(city: City): Int {
    // Return the number of customers from the given city
    return this.customers.count { it.isFrom(city)}
}

fun Shop.findFirstCustomerFrom(city: City): Customer? {
    return this.customers.firstOrNull { it.isFrom(city) }
}
