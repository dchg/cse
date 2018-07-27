FROM 100.125.0.198:20202/hwcse/dockerhub-java:8-jre-alpine

WORKDIR /home/dchgtest/cseapp/
ADD dchgtestartifact-1.0.1-SNAPSHOT.jar .

ADD start.sh .

ENTRYPOINT ["sh", "/home/dchgtest/cseapp/start.sh"]
