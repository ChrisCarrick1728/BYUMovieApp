new Vue({
  el: '#vue-app',
  data: {
    // searchSuccesfull: used to show/hide results screen
    searchSuccesfull: false,

    // searchString: bound to input text box to store user input
    searchString: '',

    // moviesObject: JavaScript object to contain our search results
    moviesObject: [{'movie_id': '', 'poster_img_url':'','title':'','popularity_summary':''}]
  },
  methods: {

    // getResults: function that is run when user clicks search button/
    getResults: function() {
      // verify that the search string is not empty
      if (this.searchString != '') {
        // Perform async connection to webservice
        fetch("http://localhost:9000/movies?search=" + encodeURI(this.searchString))
          .then(response => response.json())
          .then((data) => {
            this.moviesObject = data;
            this.searchSuccesfull = true })
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
  },
});
