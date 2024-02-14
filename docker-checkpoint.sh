#!/bin/bash

set -e

./gradlew clean build

docker build -t callista:builder .


#docker run -d --privileged --rm --name=callistacrac --ulimit nofile=1024 -p 8080:8080 -v $(pwd)/target:/opt/mnt -e FLAG=$1 callistacrac:builder

docker run -d --privileged --rm --name=checkpoint callista:builder
sleep 15
#docker commit --change='ENTRYPOINT ["/opt/app/entrypoint.sh"]' $(docker ps -qf "name=callistacrac") callistacrac:checkpoint
docker commit --change='ENTRYPOINT ["java", "-XX:CRaCRestoreFrom=./checkpoint"]' $(docker ps -qf "name=checkpoint") callista:checkpoint

docker kill $(docker ps -qf "name=checkpoint")

docker compose -f docker-compose.yml up -d && docker logs -f $(docker ps -qf "name=app")
