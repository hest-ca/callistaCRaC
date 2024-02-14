FROM ubuntu:23.10

ENV CRAC_JDK_URL https://cdn.azul.com/zulu/bin/zulu21.32.17-ca-crac-jdk21.0.2-linux_x64.tar.gz

ENV JAVA_HOME /opt/jdk
ENV PATH $JAVA_HOME/bin:$PATH
ENV CRAC_FILES_DIR /opt/crac-files

RUN apt-get update && apt-get install -y curl

ADD $CRAC_JDK_URL $JAVA_HOME/openjdk.tar.gz
RUN tar --extract --file $JAVA_HOME/openjdk.tar.gz --directory "$JAVA_HOME" --strip-components 1; rm $JAVA_HOME/openjdk.tar.gz;
RUN mkdir -p /opt/app
COPY build/libs/callistaCRaC-0.0.1-SNAPSHOT.jar /app.jar
COPY cracit.sh /cracit.sh

## TODO do we need to delete the h2 config and replace with postgress in "prod" ?

ENTRYPOINT ["/cracit.sh"]