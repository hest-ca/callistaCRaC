#!/bin/bash

docker run -it --privileged --cap-add CHECKPOINT_RESTORE --cap-add SYS_ADMIN --rm -p 8080:8080 --name spring-boot-crac-demo callista:checkpoint


./docker-checkpoint.sh && docker compose -f docker-compose.yml up -d && docker logs -f $(docker ps -qf "name=app")
