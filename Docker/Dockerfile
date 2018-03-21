FROM primetoninc/jdk:1.8

ARG ARTIFACT_URL 
ARG ARTIFACT_FILE
ARG APPLICATION_NAME
ARG ARTIFACTS_TYPE

USER root

RUN mkdir -p /app && \
    chmod 755 -R /app/ && \
    mkdir -p /env && \
    chmod 755 -R /env && \
    mkdir -p /secrets && \
    chmod 755 -R /secrets 
    
RUN  curl -o /opt/$APPLICATION_NAME.$ARTIFACTS_TYPE -u admin:admin123  $ARTIFACT_URL/$ARTIFACT_FILE
    
EXPOSE 8080 

USER 1001
