FROM tomee:8-jdk-7.0.1-plus

WORKDIR /usr/local/tomee/

COPY ./tcf-backend.war ./webapps/.
COPY ./resources/start-tcf.sh .

RUN ["chmod", "u+x", "./start-tcf.sh"]

EXPOSE 8009
EXPOSE 8080

ENTRYPOINT ["./start-tcf.sh"]