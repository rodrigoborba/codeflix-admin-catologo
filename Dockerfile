FROM  adoptopenjdk/openjdk11:alpine

#USER gradle
#VOLUME "/C/Gradle/.gradle"
#WORKDIR /C/Gradle

USER gradle
VOLUME "home/gradle/.gradle"
WORKDIR /home/gradle