# BYUMovieApp

This is an app created at the request of some awesome BYU recruiters, to show off some coding skill!
---
## About Me

I'm **Chris Carrick**, and I've never used __vue.js__ or __kotlin__. These last couple of day's have been a bit crazy as I've read and watched all sorts of tutorials to be able to come up to speed on this project. The actual coding was the easiest part. The part I struggled with most was the setup, and by that I mean learning how to setup and run a kotlin project, understanding what a SparkJava embedded server is and how to get it to work the way I wanted it. In the end this has been a very rewarding project that has stretched my abilities and confirmed my belief that there is nothing I can not learn.

Let me know what I could've done better, because I'm sure there's a lot left for me to learn. I look forward to meeting with you.

>Cell: 801-494-7232
>Email: carrick.chris@gmail.com
>[LinkedIn](https://www.linkedin.com/in/chris-carrick-99528680/)
---
## About the app

This kotlin portion was implemented using a [SparkJava](http://http://sparkjava.com/) embedded web server as was suggested in the app requirements. I used Intellij IDEA to code and run my kotlin code.

There are 3 path's that can be followed once the server is up and running:
*`http://localhost:9000/` Will take you to the root path and display a message __Server Started!__ to let you know that the server is up and running.
* `http://localhost:9000/moives?search=toy%20story` Will take return the raw JSON that has been retrieved from [tmdb.com](http://www.tmdb.com) and then formatted and stripped of the unnecessary data.
# `http://localhost:9000/stop` can be used to stop the SparkJava server.
