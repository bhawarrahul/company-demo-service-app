FROM openjdk:8-jdk-alpine
VOLUME /file_volume
COPY company-demo-service-app-0.0.1-SNAPSHOT.jar company-demo-service-app-0.0.1-SNAPSHOT.jar
CMD ["java","-jar","/company-demo-service-app-0.0.1-SNAPSHOT.jar"]



#docker build -t deployimage .
#docker run  -p8888:8888 deployimage
