# GithubRepo
App to get the most popular repository of any organisation and its best contributors
This application is create in Java 8 and it is a Maven Spring Boot Project.
To Run this Project Locally on your system you can either run the command : 
./mvnw spring-boot:run or open the project on Jetbrains Intellij and run the <a href="https://github.com/mufaddalnaya/GithubRepo/blob/master/src/main/java/com/almabase/GithubRepo/GithubRepoApplication.java">GithubRepoApplication.java</a> file.
<br>

<h4> About Rest Endpoints </h4>
This application contains 2 rest endpoints
<ol>
<li></li>
</ol>

<h4>POJO Model Classes Present in the Spring Boot Application</h4>
<ol>
<li> <b><a href="https://github.com/mufaddalnaya/GithubRepo/blob/master/src/main/java/com/almabase/GithubRepo/Models/Author.java">Author</a></b>: This Model class contains Information of a particular user present on github. The variable <b>login</b> represents users github id.
![Author Model Class](https://github.com/mufaddalnaya/GithubRepo/blob/master/Screenshots/Author.png?raw=true)
<li> <b><a href="https://github.com/mufaddalnaya/GithubRepo/blob/master/src/main/java/com/almabase/GithubRepo/Models/Contributor.java">Contributor</a></b>: This Model class contains Information of a particular contributor of a particular repo. The variable <b>total</b> represents total commits and <b>author</b> contains the details of the author.
![Contributor Model Class](https://github.com/mufaddalnaya/GithubRepo/blob/master/Screenshots/Contributor.png?raw=true)
<li> <b><a href="https://github.com/mufaddalnaya/GithubRepo/blob/master/src/main/java/com/almabase/GithubRepo/Models/Organisation.java">Organisation</a></b>: This Model class contains Information about a particular organisation.
![Organisation Model Class](https://github.com/mufaddalnaya/GithubRepo/blob/master/Screenshots/Organisation.png?raw=true)
<li> <b><a href="https://github.com/mufaddalnaya/GithubRepo/blob/master/src/main/java/com/almabase/GithubRepo/Models/Repository.java">Repository</a></b>: This Model class contains Information of a particular repository of a particular organisation. The variable <b>fork_count</b> represents total forks made to this repo. 
![Repository Model Class](https://github.com/mufaddalnaya/GithubRepo/blob/master/Screenshots/Repository.png?raw=true)
</ol>

 