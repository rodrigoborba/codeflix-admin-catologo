FROM  openjdk:11-jdk

#RUN useradd -rm -d /home/gradle -s /bin/bash -g root -G sudo -u 1000 gradle
#RUN groupadd -r gradle -g 901 && useradd -u 901 -r -g gradle
RUN useradd -rm -d /home/gradle -s /bin/bash -g root -G sudo -u 1000 gradle

USER gradle
VOLUME "/home/rodrigo/.gradle"
WORKDIR /home/gradle