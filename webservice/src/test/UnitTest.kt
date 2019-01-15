import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions

class UnitTest {
    private val s = SearchMovie()
    private var r = ""

    @Test
    fun testSearchMovieReturnsSuccess() {
        // Verify Queries are successful
        // Test Single word
        r = s.searchMovie("Bourne")
        System.out.println("TEST 1 (\"Bourne\"):\n\n $r\n")
        Assertions.assertEquals("Bourne", s.getSearchString())
        Assertions.assertEquals(true, s.getSuccess())


        // Test Double word with space
        r = s.searchMovie("Toy Story")
        System.out.println("TEST 1 (\"Toy Story\"):\n\n $r\n")
        Assertions.assertEquals("Toy Story", s.getSearchString())
        Assertions.assertEquals(true, s.getSuccess())

        // Test Numbers
        r = s.searchMovie("21")
        System.out.println("TEST 1 (\"21\"):\n\n $r\n")
        Assertions.assertEquals("21", s.getSearchString())
        Assertions.assertEquals(true, s.getSuccess())
    }
}