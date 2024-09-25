FROM alpine/java:20-jdk

WORKDIR /opt/ptransportes
COPY ./target/cadastros-1.1.2-DEPLOY.jar /opt/ptransportes
EXPOSE 8080
CMD [ "java", "-jar", "-Xms1024M", "-Xmx2048M", "-XX:+UseParallelGC","cadastros-1.1.2-DEPLOY.jar" ]