package mhashim6.school.sorting

/**
 *@author mhashim6 on 08/10/2018
 */

interface Sorter {
    var algorithm: SortingStrategy
    fun sort(array: IntArray): SortingResult

    companion object Factory {
        fun create(algorithm: SortingStrategy): Sorter = SorterImpl(algorithm)
    }
}

private class SorterImpl(override var algorithm: SortingStrategy) : Sorter {
    override fun sort(array: IntArray): SortingResult {
        val (sortedArray, time) = executionTimeOf { algorithm.sort(array) }
        return SortingResult.create(sortedArray, time)
    }
}