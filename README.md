# neo4jpoc

actuator
http://localhost:8080/actuator/health

docker-compose up -d 
http://localhost:7474/browser/


Create a basic Gradle project with the Spring Initializr
curl https://start.spring.io/starter.tgz \
  -d dependencies=web,actuator \
  -d bootVersion=2.1.10.RELEASE \
  -d baseDir=Neo4jSpringBootExampleGradle \
  -d name=Neo4j%20SpringBoot%20Example2 | tar -xzvf -
  
  
  curl https://start.spring.io/starter.tgz \
    -d dependencies=web,actuator \
    -d type=gradle-project \
    -d bootVersion=2.1.10.RELEASE \
    -d baseDir=Neo4jSpringBootExampleGradle \
    -d name=Neo4j%20SpringBoot%20Example2 | tar -xzvf -

