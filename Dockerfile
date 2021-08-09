FROM adoptopenjdk:14-jre-hotspot
RUN mkdir /opt/app
COPY target/sv2021-jvjbf-zarovizsga-0.0.1-SNAPSHOT.jar /opt/app/sv2021-jvjbf-zarovizsga.jar
CMD ["java", "-jar", "/opt/app/sv2021-jvjbf-zarovizsga.jar"]