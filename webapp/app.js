new Vue({
  el: '#vue-app',
  data: {
    searchSuccesfull: false,
    searchString: '',
    responseText: '',
    moviesObject: [{'poster_img_url':'','title':'','popularity_summary':''}]
  },
  methods: {
    getResults: function() {
      if (this.searchString != '') {
        try {
          fetch("http://localhost:9000/search/" + this.searchString)
            .then(response => response.json())
            .then((data) => {
              this.moviesObject = data;
              this.searchSuccesfull = true
          })
        } catch (e) {
          console.log("error: " + e);
        }
      } else {
        this.searchSuccesfull = false
      }
    },
    keyPressed: function(event) {
      console.log(event)
      if (event.keyCode == 13) {
        this.getResults()
      } else if (event.keyCode == 27) {
        this.searchString = ''
      }
    }
  },
  computed: {
    //empty
  }
});
