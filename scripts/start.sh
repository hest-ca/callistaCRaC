#!/bin/bash

START_TIME=$(($(date +'%s * 1000 + %-N / 1000000')))
java -DSTART_TIME=$START_TIME -jar build/libs/callistaCRaC-0.0.1-SNAPSHOT.jar

