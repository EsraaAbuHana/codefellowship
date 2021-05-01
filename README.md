# CodeFellowship
# Overview
* An app that allows users to sign up through a form, which will hash their passwords and store them to a database.
*  After signing up, the user is taken to a page showing them a detailed view of their account.
*   Users can sign in to an account, and create posts on their own profile if desired. They can also view posts on another users profile

# Setup and Running
* clone down the repo.
* Refer to the [application.properties](src/main/resources/application.properties) file for of what is necessary to setup the app to work with a database.
* The app can be run running `./gradlew bootRun` in the terminal.

 # Routes
* `/` : home page 
 * `/userProfile` : To show a profile user which contain details of the user basic info and brief bio .
 * `/signup` :  To create a new account .
 * `/login` : let the user log in to him/her profile 
 * `/users/{id}` : which allows viewing the data about a single user.
 * `/feed` : To view all of the posts from the users that they follow.
 * `/addPost`: To create a new post .
 * `/allUsers`: To display  users and follow them.