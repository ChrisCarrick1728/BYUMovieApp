# BYUMovieApp
This is an app created at the request of some awesome BYU recruiters to show off some coding skill!

## About Me
![Image](https://github.com/ChrisCarrick1728/BYUMovieApp/blob/master/familyPic-8.jpg?raw=true)
Hi, I'm **Chris Carrick**, and I'm passionate about software development. I love learning new technologies and stretching my abilities. I approach problems with an attitude that proves there's nothing I can't learn or do, and this challenge is no exception. I've never used **vue.js** or **kotlin** before so this was quite the challenge. These last couple of day's have been a massive data download as I've read and watched all sorts of tutorials to be able to come up to speed on this project. The actual coding was the easiest part. The part I struggled with most was the setup, and by that I mean learning how to setup and run a **kotlin** project, understanding what a **SparkJava** embedded server is and how to get it to work the way I wanted it to, and learning how to use the **Nuxt CLI** to start my frontend. This has been a very rewarding project that has stretched my abilities and confirmed my belief that there is nothing I can not learn. In the end, I was able to complete all frontend and backend requirements and recommendations from the challenge, and have been able to produce a fully functioning app.

Let me know what I could've done better, because I'm sure there's a lot left for me to learn. I look forward to meeting with you and hope I have the opportunity to work with you in the future.

>Cell: 801-494-7232
>
>Email: carrick.chris@gmail.com
>
>Connect with me on [LinkedIn](https://www.linkedin.com/in/chris-carrick-99528680/)
---
# About the app
Read below for instructions on how to launch/run the backend and frontend of this app

## Kotlin Backend
The **kotlin** portion was implemented using a [SparkJava](http://sparkjava.com/) embedded web server as was suggested in the app requirements. I used Intellij IDEA to code and run my **kotlin** code.

There are 3 path's that can be followed once the **SparkJava** server is up and running:

* `http://localhost:9000/` Will take you to the root path and display the message __Server Started!__ to let you know that the server is up and running.

* `http://localhost:9000/movies?search=toy%20story` Retrieves the raw JSON that from [tmdb.com](http://www.themoviedb.org) and then formats and strips the results of any unnecessary data, which is then returned as a new JSON object to the client.

* `http://localhost:9000/stop` can be used to stop the SparkJava server.

## Vue.js Frontend
The **Vue.js** frontend was implemented using the **Nuxt CLI**. You will need browse to `\webapp\byumoviedb\` and run the command `npm install --save nuxt` in your terminal to install **Nuxt**. Then run the command `npm run dev` to start a server instance at [localhost:3000](http://localhost:3000) that you can use to view the frontend page.

## Proposed Future Features
If I was to continue to develop this app I would add more robust search functionality. the TMDB api has some awesome search features that we didn't get to use in our implementation. I would add database functionality and create a user comment board, where they could share what they liked and disliked, as well as respond to others posts allowing users to discuss the movies with others. I would clean up the UI and to make the user experience better. I would add components that could display which movies are trending, another to highlight new releases, and other features that would add visual interest to the main page.
