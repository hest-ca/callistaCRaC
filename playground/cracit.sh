#!/usr/bin/zsh

javac CRaCRestore.java

java -XX:CRaCCheckpointTo=tmp CRaCRestore &

sleep 10

jcmd CRaCRestore JDK.checkpoint

sleep 5

java -XX:CRaCRestoreFrom=tmp
