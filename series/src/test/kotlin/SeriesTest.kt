import org.junit.Test
import kotlin.test.assertEquals

class SeriesTest {


    @Test
    fun slicesOfOneEmptyString() {
        assertEquals(listOf(), Series.slices(1, ""))
    }

    @Test
    fun slicesOfOne() {
        assertEquals(
                listOf(listOf(0), listOf(1), listOf(2), listOf(3), listOf(4)),
                Series.slices(1, "01234")
        )
    }

    @Test
    fun slicesOfTwoEmptyString() {
        assertEquals(listOf(), Series.slices(2, ""))
    }

    @Test
    fun slicesOfTwoSingle() {
        assertEquals(listOf(listOf(0, 1)), Series.slices(2, "01"))
    }

    @Test
    fun slicesOfTwoMultiple() {
        assertEquals(
                listOf(listOf(0, 1), listOf(1, 2), listOf(2, 3), listOf(3, 4)),
                Series.slices(2, "01234")
        )
    }

    @Test
    fun slicesOfThreeEmptyString() {
        assertEquals(listOf(), Series.slices(3, ""))
    }

    @Test
    fun slicesOfThreeSingle() {
        assertEquals(listOf(listOf(0, 1, 2)), Series.slices(3, "012"))
    }

    @Test
    fun slicesOfThreeMultiple() {
        assertEquals(
                listOf(listOf(0, 1, 2), listOf(1, 2, 3), listOf(2, 3, 4)),
                Series.slices(3, "01234")
        )
    }
}
