FROM jeanblanchard/java:8

MAINTAINER Vibbo Dev Team <vibbo.dev@scmspain.com>

COPY ./api/build/libs/api.jar /app/
WORKDIR /app

EXPOSE 8000

CMD java -jar api.jar
