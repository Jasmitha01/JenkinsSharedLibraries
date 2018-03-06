FROM primetoninc/jdk:1.8
USER root 
RUN curl -o /opt/spring-boot-rest-example-0.5.0.war -u admin:admin123 http://nexus-daac-nexus.apps.openshiftpoc.online/repository/test/44.war
EXPOSE 8080 
USER 1001
ENTRYPOINT [ "java", "-jar", "-Dspring.profiles.active=test", "/opt/spring-boot-rest-example-0.5.0.war" ]
