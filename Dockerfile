FROM openjdk:10-jre

MAINTAINER maxbalan

#adding user to sudo group
RUN apt-get update && apt-get -y install sudo
RUN adduser --disabled-password --gecos '' signupservice
RUN adduser signupservice sudo
RUN echo '%sudo ALL=(ALL) NOPASSWD:ALL' >> /etc/sudoers

#copy service image
ADD build/distributions/dropwizard-opentracing-demo-0.1.tar /home/hello/
ADD docker/entrypoint.sh ./entrypoint.sh

RUN chmod +x /entrypoint.sh

# expose ENV variables for the service
ENV HOME /home/signupservice

ENV JAEGER_SERVICE_NAME "HelloService"
ENV JAEGER_SAMPLER_TYPE "const"
ENV JAEGER_SAMPLER_PARAM 1
ENV JAEGER_REPORTER_LOG_SPANS true

#Expose ports
EXPOSE 9082:9082

# Slim down the image
RUN apt-get clean
RUN rm -rf /var/lib/apt/lists/* /tmp/* /var/tmp/*

ENTRYPOINT ["/bin/bash"]
CMD ["./entrypoint.sh"]
#User root