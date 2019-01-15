/**
 * @author      Christopher Carrick <carrick.chris@gmail.com>
 * @version     0.1
 *
 * Defines the data structure of the JSON objects that will be returned to the caller
 */
data class Movie(
        val movie_id: Int,
        var title: String,
        val poster_image_url: String,
        val popularity_summary: String
)
