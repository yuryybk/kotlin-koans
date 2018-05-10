package iii_conventions

data class MyDate(val year: Int, val month: Int, val dayOfMonth: Int): Comparable<MyDate> {

    override operator fun compareTo(value: MyDate): Int {
        if (this.year < value.year) {
            return -1
        } else if (this.year > value.year) {
            return 1
        } else {
            if (this.month < value.month) {
                return -1
            } else if (this.month > value.month) {
                return 1
            } else {
                if (this.dayOfMonth < value.dayOfMonth) {
                    return -1
                } else if (this.dayOfMonth > value.dayOfMonth) {
                    return 1
                } else {
                    return 0
                }
            }
        }
    }
}

operator fun MyDate.rangeTo(other: MyDate): DateRange {
    return DateRange(this, other)
}

enum class TimeInterval {
    DAY,
    WEEK,
    YEAR
}

class DateRange(val start: MyDate, val endInclusive: MyDate): Iterable<MyDate> {

    val inner = object : Iterator<MyDate> {

        var nextDay: MyDate = start

        override fun hasNext(): Boolean {
           return nextDay <= endInclusive
        }

        override fun next(): MyDate {
            val ret = nextDay
            nextDay = nextDay.nextDay()
            return ret
        }

    }

    override operator fun iterator(): Iterator<MyDate> {
        return inner
    }
}

operator fun DateRange.contains(d: MyDate): Boolean {

    return d >= start && d <= endInclusive
}

class RepeatedTimeInterval(var timeInterval: TimeInterval, var repeated:Int)



