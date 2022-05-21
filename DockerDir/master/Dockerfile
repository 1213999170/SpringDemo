FROM 150620102644.dkr.ecr.cn-north-1.amazonaws.com.cn/openjdk:11-jdk-oracle-newrelic
MAINTAINER wallace.wan@porsche.cn

ENV LANG C.UTF-8

COPY build/libs/spring-demo-service-*.jar /opt/spring-cloud/lib/spring-demo-service.jar

RUN ln -sf /usr/share/zoneinfo/Asia/Shanghai    /etc/localtime

EXPOSE 8080

ENTRYPOINT ["java","-server","-Xms1024m","-Xmx1024m","-javaagent:/opt/newrelic/newrelic.jar","-jar","/opt/spring-cloud/lib/spring-demo-service.jar"]
