FROM alpine/java:20-jdk

WORKDIR /opt/ptransportes
COPY ./build/cadastros.jar /opt/ptransportes
EXPOSE 8080
CMD [ "java", "-jar", "-Xms1024M", "-Xmx2048M","cadastros.jar" ]
