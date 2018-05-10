package vi_generics

import util.TODO
import java.util.*

fun task41(): Nothing = TODO(
    """
        Task41.
        Add a 'partitionTo' function that splits a collection into two collections according to a predicate.
        Uncomment the commented invocations of 'partitionTo' below and make them compile.

        There is a 'partition()' function in the standard library that always returns two newly created lists.
        You should write a function that splits the collection into two collections given as arguments.
        The signature of the 'toCollection()' function from the standard library may help you.
    """,
        references = { l: List<Int> ->
            l.partition { it > 0 }
            l.toCollection(HashSet<Int>())
        }
)

fun List<String>.partitionWordsAndLines(): Pair<List<String>, List<String>> {
    var l1 = ArrayList<String>()
    var l2 = ArrayList<String>()
    partitionTo(l1, l2) { s -> !s.contains(" ") }
    return Pair(l1, l2)
}

fun Set<Char>.partitionLettersAndOtherSymbols(): Pair<Set<Char>, Set<Char>> {
    var s1 = HashSet<Char>()
    var s2 = HashSet<Char>()
    partitionTo(s1, s2) { c -> c in 'a'..'z' || c in 'A'..'Z'}
    return Pair(s1, s2)
}

fun <F, T: MutableCollection<F>> Collection<F>.partitionTo (first: T, second: T, predicate: (item: F)-> Boolean) {
    val pair =  partition { predicate(it) }
    pair.first.toCollection(first)
    pair.second.toCollection(second)
}
