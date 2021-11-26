From java:8-jre
WORKDIR usr/src
ENV MYSQL_DATABASE=newsdb
ENV MYSQL_USER=root
ENV MYSQL_PASSWORD=root
ENV MYSQL_CI_URL=jdbc:mysql://localhost:3306/newsdb
ENV MYSQL_ROOT_PASSWORD=root
ADD ./target/news-app-0.0.1-SNAPSHOT.jar /usr/src/news-app-0.0.1-SNAPSHOT.jar
ENTRYpoint ["java","-jar","news-app-0.0.1-SNAPSHOT.jar"]
