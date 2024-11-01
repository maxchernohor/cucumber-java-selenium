### Build stage
###
#FROM maven:3.6.0-jdk-11-slim AS build
#COPY features/ ./features/
#COPY *.properties .
#COPY *.json .
#COPY *.sh .
#COPY ./src /home/app/src
#COPY ./pom.xml /home/app
#RUN mvn -f /home/app/pom.xml package
#
#FROM azul/zulu-openjdk:11
#RUN apt-get update && apt-get install -y \
#gnupg2 \
#wget \
#less \
#&& rm -rf /var/lib/apt/lists/*
#
### Install Microsoft Edge Stable
#RUN wget -qO- https://packages.microsoft.com/keys/microsoft.asc | gpg --dearmor > microsoft.gpg && \
#    mv microsoft.gpg /etc/apt/trusted.gpg.d/microsoft.gpg && \
#    echo "deb [arch=amd64] https://packages.microsoft.com/repos/edge stable main" > /etc/apt/sources.list.d/microsoft-edge.list && \
#    apt-get update && \
#    apt-get install -y microsoft-edge-stable
#
## Install Cucumber and dependencies
#RUN apt-get install -y maven
#
## Copy jar from docker build
#COPY --from=build /home/app/target/cucumber-0.0.1-SNAPSHOT-test-jar-with-dependencies.jar .
#
#RUN mkdir -v seleniumCache resolutionCache
#
##EXPOSE 8080
#ENTRYPOINT ["java","-Xss2048k","-jar", "-Dwdm.cachePath=seleniumCache", "-Dwdm.resolutionCachePath=resolutionCache", "cucumber-0.0.1-SNAPSHOT-test-jar-with-dependencies.jar"]
##ENTRYPOINT ["mvn", "clean", "compile", "test", "-Dcucumber.plugin=json:report.json", "-Dcucumber.features=features/"]


#####


FROM maven:3.8.1-openjdk-17-slim AS build

# Create a default user
RUN groupadd --system automation && \
    useradd --system --create-home --gid automation automation && \
    chown --recursive automation:automation /home/automation

RUN apt-get update && apt-get install -y unzip wget gnupg2

## Install Microsoft Edge Stable
#RUN wget -qO- https://packages.microsoft.com/keys/microsoft.asc | gpg --dearmor > microsoft.gpg && \
#    mv microsoft.gpg /etc/apt/trusted.gpg.d/microsoft.gpg && \
#    echo "deb [arch=amd64] https://packages.microsoft.com/repos/edge stable main" > /etc/apt/sources.list.d/microsoft-edge.list && \
#    apt-get update && \
#    apt-get install -y microsoft-edge-stable

## Install Chrome
RUN wget -q -O - https://dl-ssl.google.com/linux/linux_signing_key.pub | apt-key add - && \
    echo "deb http://dl.google.com/linux/chrome/deb/ stable main" > /etc/apt/sources.list.d/google-chrome.list && \
    apt-get update && \
    apt-get install -y google-chrome-stable

WORKDIR /source

COPY features/ ./features/
COPY *.properties .
COPY *.xml .
COPY *.sh .
COPY src/ ./src/

RUN chown -R automation.automation /source
USER automation

RUN mvn dependency:resolve

ENV PATH $PATH:/home/automation/.local/bin

ENTRYPOINT ["mvn", "clean", "compile", "test", "-Dtest=TestRunner", "-Dcucumber.plugin=json:report.json", "-Dcucumber.features=features/"]