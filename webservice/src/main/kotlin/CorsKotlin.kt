import java.util.HashMap
import spark.Filter
import spark.Spark

/**
 * @author      Christopher Carrick <carrick.chris@gmail.com>
 * @version     0.1
 *
 * Used to set the CORS policy on the SparkJava embedded web server. With out this class, any testing from a localhost
 * will fail due to a cross origin request being block by the web browser
 */
class CorsKotlin() {
    private val corsHeaders = HashMap<String, String>()

    init {
        corsHeaders["Access-Control-Allow-Methods"] = "GET,PUT,POST,DELETE,OPTIONS"
        corsHeaders["Access-Control-Allow-Origin"] = "*"
        corsHeaders["Access-Control-Allow-Headers"] = "Content-Type,Authorization,X-Requested-With,Content-Length,Accept,Origin,"
        corsHeaders["Access-Control-Allow-Credentials"] = "true"
    }

    fun apply() {
        val filter = Filter { request, response -> corsHeaders.forEach { key, value -> response.header(key, value) } }
        Spark.after(filter)
    }
}