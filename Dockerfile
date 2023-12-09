# Use Ubuntu as the base image
FROM ubuntu:latest

# Set environment variables
ENV DEBIAN_FRONTEND noninteractive
ENV JAVA_HOME /usr/lib/jvm/java-8-openjdk-amd64
ENV CATALINA_HOME /opt/tomcat

# Create a directory named MyApp in the home directory
RUN mkdir -p ~/MyApp

# Set it as the working directory
WORKDIR ~/MyApp

# Update and install necessary packages
RUN apt-get update && \
    apt-get install -y openjdk-8-jdk wget && \
    rm -rf /var/lib/apt/lists/*

# Download and install Apache Tomcat
RUN wget -q http://mirror.linux-ia64.org/apache/tomcat/tomcat-8/v8.5.72/bin/apache-tomcat-8.5.72.tar.gz -O /tmp/tomcat.tar.gz && \
    mkdir $CATALINA_HOME && \
    tar xzvf /tmp/tomcat.tar.gz -C $CATALINA_HOME --strip-components=1 && \
    rm /tmp/tomcat.tar.gz

# Remove the default Tomcat webapps
RUN rm -rf $CATALINA_HOME/webapps/*

# Copy your web application WAR file to the Tomcat webapps directory
COPY ./StudentEnrollment/target/StudentEnrollment.war $CATALINA_HOME/webapps/

# Expose the Tomcat port
EXPOSE 8080

# Start Tomcat
CMD ["$CATALINA_HOME/bin/catalina.sh", "run"]
