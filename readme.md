## Instructions

Build your maven project:  
* open the project in an IDE (e.g., IntelliJ or Eclipse)
* `mvn clean install`
* open and run the `src/main/java/ShaclMain.java`

This small program will use the reference implementation of 
[SHACL Engine](https://github.com/TopQuadrant/shacl) to check the movie ontology
`src/main/resources/movie-owl.ttl` against `src/main/resources/movie-constraints.ttl` constraints.  

The result is saved as `report.ttl` in the root folder.

