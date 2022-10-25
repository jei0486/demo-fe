
# docker cmd
docker pull ${DOCKER_IMAGE}:latest || true
docker build --cache-from ${DOCKER_IMAGE}:latest --tag ${DOCKER_IMAGE}:latest --tag ${DOCKER_IMAGE}:$CI_COMMIT_SHORT_SHA .
docker push ${DOCKER_IMAGE}:latest
docker push ${DOCKER_IMAGE}:$CI_COMMIT_SHORT_SHA

# Dockerfile
FROM gradle:7.5.1-jdk11-alpine AS build
COPY --chown=gradle:gradle ./ /home
WORKDIR /home
RUN gradle build --no-daemon

FROM openjdk:11
EXPOSE 9099
RUN mkdir /app

COPY --from=build /home/build/libs/*-SNAPSHOT.jar ./app/application.jar

ENTRYPOINT ["java","-jar","/app/application.jar"]