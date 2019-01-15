<template lang="html">
  <div>
    <div id="search">
      <div class="searchContainer">
        <div class="searchCenter">
          <input
            v-model="searchString"
            type="text"
            name="query"
            class="searchBox"
            placeholder="Search for movies..."
            v-on:keyup="keyPressed">
          <input
            type="button"
            name="button"
            value="search"
            class="searchButton"
            v-on:click="getResults">
        </div>
      </div>
    </div>
    <div
      v-show="searchSuccesfull"
      id="results">
      <div
        v-for="movies in moviesObject"
        class="tile">
        <div class="innerTile">
          <div class="poster">
            <span v-if="movies.poster_image_url != 'null'">
              <img
                :src="movies.poster_image_url"
                alt="">
            </span>
          </div>
          <div class="resultsText">
            <h3>{{ movies.title }}</h3>
            <p>{{ movies.popularity_summary }}</p>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  data: function() {
    return {
      // searchSuccesfull: used to show/hide results screen
      searchSuccesfull: false,

      // searchString: bound to input text box to store user input
      searchString: '',

      // moviesObject: JavaScript object to contain our search results
      moviesObject: [
        {
          movie_id: '1',
          poster_img_url:
            'https://image.tmdb.org/t/p/w500/kqjL17yufvn9OVLyXYpvtyrFfak.jpg',
          title: 'test',
          popularity_summary: 'test'
        }
      ]
    }
  },
  methods: {
    // getResults: function that is run when user clicks search button/
    getResults: function() {
      // verify that the search string is not empty
      if (this.searchString != '') {
        // Perform async connection to webservice
        fetch(
          'http://localhost:9000/movies?search=' + encodeURI(this.searchString)
        )
          .then(response => response.json())
          .then(data => {
            this.moviesObject = data
            this.searchSuccesfull = true
          })
      } else {
        this.searchSuccesfull = false
      }
    },
    // keyPressed: function to add esc and enter key functionallity
    keyPressed: function(event) {
      // keyCode: 13 = "return" key and calls the getResults function
      if (event.keyCode == 13) {
        this.getResults()
        // keyCode: 27 = "esc" and clears our searchString
      } else if (event.keyCode == 27) {
        this.searchString = ''
      }
    }
  }
}
</script>
<style lang="css" scoped>
@import url('https://fonts.googleapis.com/css?family=Paytone+One');

#search {
  padding-top: 40px;
  width: 100%;
}
.searchContainer {
  width: 100%;
}
.searchCenter {
  width:460px;
  margin-left: auto;
  margin-right: auto;
}

span {
  color: white;
}

input {
  background-color: #333;
  border: none;
  height: 50px;
  border: 1px solid #444;
  margin: 0px;
  font-size: 20px;
  outline: none;
  caret-color: #444;
  letter-spacing: 2px;
}

input.searchBox {
  width: 300px;
  text-indent: 20px;
  border-radius: 20px 0px 0px 20px;
  background-color: #333;
  padding: 0px;
  color: #888;
  font-weight: lighter;
}

input.searchButton {
  width: 100px;
  border-radius: 0px 20px 20px 0px;
  text-align: center;
  background-color: LightBlue;
  color: #333;
  cursor: pointer;
  height: 53px;
  border: none
}

input.searchBox:focus {
  background-color: #555;
  color: white;
}

input.searchButton:hover {
  cursor: pointer;
  background-color: lightYellow;
}

input:-webkit-autofill {
    -webkit-text-fill-color: #444 !important;
}

#results {
  width: 80%;
  margin-left: auto;
  margin-right: auto;
  margin-top: 20px;
  display: flex;
  flex-wrap: wrap;
}
.tile {
  width: 310px;
  max-width: 100%;
  margin: 20px;
  /* background-color: #444; */
  margin-left: auto;
  margin-right: auto;
  /* text-overflow: ellipsis; */
  /* box-shadow: 3px 3px 5px Black; */
}

.innerTile {
  width: 300px;
  max-width: 100%;
  margin: 20px;
  height: 100%;
  background-color: #555;
  margin-left: auto;
  margin-right: auto;
  text-overflow: ellipsis;
  box-shadow: 3px 3px 5px Black;
}

.poster {
  padding: 10px;
  display: inline;
  float: left;

}
.poster img {
  max-width: 100%;
  width: 280px;
  object-fit: cover;
}

.resultsText {
  display: inline;
  float: left;
  text-overflow: ellipsis;
  padding-left: 20px;
  padding-right: 20px;
}

.resultsText h3 {
  padding-top: 10px;
  margin: 0px;
  text-align: center;
  font-family: sans-serif;
  font-size: 30px;
  color: LightBlue;
  letter-spacing: 2px;
}

.resultsText p {
  text-align: center;
  font-family: sans-serif;
  font-weight: lighter;
  font-size: 15px;
  color: LightBlue;
}

@media only screen and (max-width: 460px) {
  .searchCenter {
    width: auto;
  }
  input.searchBox {
    width:100%;
    padding: 0px;
    border-radius: 0px;
    border-left: none;
    border-right: none;
  }

  input.searchButton {
    width: 100%;
    border-radius: 0px;
  }

  header h1{
    max-width: 200px;
    font-size: 6vw;
  }
}

</style>
