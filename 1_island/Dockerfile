FROM maven:3.3.9-jdk-8

USER root

RUN mkdir -p /usr/local/devops
WORKDIR /usr/local/devops

COPY island island
COPY resources resources
COPY spoon_rewriter spoon_rewriter
COPY pom.xml script.sh /usr/local/devops/

RUN mkdir volume
VOLUME /usr/local/devops/results

ENTRYPOINT ["./script.sh"]
