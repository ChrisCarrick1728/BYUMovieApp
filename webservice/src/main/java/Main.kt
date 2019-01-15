import spark.Spark.*
import java.util.logging.Level
import java.util.logging.Logger

/**
 * @author      Christopher Carrick <carrick.chris@gmail.com>
 * @version     0.1
 *
 * Initializes a SparkJava embedded web server and configures some paths for the client to connect to
 */
fun main(args: Array<String>) {

    // Set up spark server
    port(9000)
    val corsKotlin = CorsKotlin()
    corsKotlin.apply()
    init()

    // Root, displays message so user knows spark server is running
    get("/") { _, _ -> "Server Started!" }

    // Path to access /search, must include a query or search parameter
    get("/movies") { req, _ ->
        val s = SearchMovie()
        val r = s.searchMovie(req.queryParams("search")); r
    }

    // Path to stop the server
    get("/stop") { _, _ -> stop(); "Server Stopped" }
}
