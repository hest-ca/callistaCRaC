#!/bin/bash

java -Dspring.profiles.active=build -XX:CRaCCheckpointTo=./checkpoint -jar /app.jar &

JAVA_APP_PID=$!

sleep 10

if ps -p $JAVA_APP_PID > /dev/null; then
    echo "Java application is running, warming up JVM"
    for i in {1..10}; do
        curl http://localhost:8080/blogs
    done

    echo "creating checkpoint"
    jcmd /app.jar JDK.checkpoint

    sleep infinity
else
    echo "Java application is not running."
    exit 1
fi

