import com.google.gson.Gson
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL
import java.net.URLEncoder
import java.util.HashMap
import java.util.logging.Level
import java.util.logging.Logger
import io.github.cdimascio.dotenv.dotenv

/**
 * @author      Christopher Carrick <carrick.chris@gmail.com>
 * @version     0.1
 *
 * Is used to make a connection to @link http://www.themoviedb.org and performs a search query that returns the results
 * in JSON format to be passed back to the caller
 */
class SearchMovie {
    private val logger: Logger = Logger.getAnonymousLogger()
    private var success: Boolean = false
    private var tmdbSearchResults = ""
    private var searchString = ""

    fun getSearchString(): String {
        return this.searchString
    }

    private fun setSearchString(searchString: String) {
        this.searchString = searchString
    }
    fun getTmdbSearchResults(): String {
        return this.tmdbSearchResults;
    }

    private fun setTmdbSearchResults(tmdbSearchResults: String) {
        this.tmdbSearchResults = tmdbSearchResults
    }

    fun getSuccess(): Boolean {
        return this.success;
    }

    private fun setSuccess(success: Boolean) {
        this.success = success
    }
    /**
     * Performs the search
     * @param searchString Receives a String with the search query
     */
    fun searchMovie(searchString: String): String {
        val params = HashMap<String, String>()
        setSearchString(searchString)
        val dotenv = dotenv {
            directory = "./src/main/resources" // Pull environmental vars from .env file
            ignoreIfMalformed = false
            ignoreIfMissing = false
        }

        params["api_key"] = dotenv["API_KEY"].toString()
        params["include_adult"] = dotenv["INCLUDE_ADULT"].toString()
        params["query"] = searchString
        params["language"] = dotenv["LANGUAGE"].toString()
        params["page"] = dotenv["PAGE"].toString()
        params["region"] = dotenv["REGION"].toString()

        // Build our URL and establish a connection with the server
        var url = dotenv["QUERY_URL"].toString()
        url += parameterBuilder(params)
        val obj = URL(url)
        with(obj.openConnection() as HttpURLConnection) {
            // optional default is GET
            requestMethod = "GET"

            // read the input stream being received from the server
            BufferedReader(InputStreamReader(inputStream)).use {
                val response = StringBuffer()
                var inputLine = it.readLine()
                while (inputLine != null) {
                    response.append(inputLine)
                    inputLine = it.readLine()
                }

                // Convert JSON response to kotlin object, and remove items we don't need
                val movie = Gson().fromJson(response.toString(), MovieObject::class.java)
                setTmdbSearchResults(Gson().toJson(movie))
                val movieArray: ArrayList<Movie> = ArrayList()
                var i = 0
                try {
                    for (count in movie.results) {
                        if (i != 10) {
                            val moviePath: String = if (count.poster_path.isNullOrBlank()) {
                                "null"
                            } else {
                                dotenv["POSTER_PATH_URL"] + count.poster_path  // Build Poster path
                            }
                            val tempMovie = Movie(
                                    (count.id),
                                    (count.title),
                                    (moviePath),
                                    (count.vote_average.toString()) + " out of " + count.vote_count.toString() + " votes")
                            movieArray.add(tempMovie)
                        } else {
                            // Only Show 10 results then break loop
                            break
                        }
                        i++
                    }
                } catch (e: Exception) {
                    setSuccess(false);
                    logger.log(Level.INFO, "ERROR: $e")
                }
                setSuccess(true);
                return Gson().toJson(movieArray)
            }
        }
    }

    /**
     * Builds the query URL by encoding all key, value pairs and building a URL header
     *
     * @param param Accepts a HashMap of Key:String, Value:String that is used to build the URL header
     */
    private fun parameterBuilder(param: HashMap<String, String>) :String{
        var parameter = "?"
        val size = param.size
        var count = 1
        for ((k, v) in param) {
            parameter += URLEncoder.encode(k, "UTF-8")
            parameter += "="
            parameter += URLEncoder.encode(v, "UTF-8")
            if (size != count) {
                parameter += "&"
            }
            count++
        }
        return parameter
    }
}