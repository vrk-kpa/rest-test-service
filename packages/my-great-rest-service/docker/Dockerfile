FROM centos:7

RUN yum -y install sudo git rpm-build java-11-openjdk-headless
RUN yum clean all
RUN sed -i 's/requiretty/!requiretty/' /etc/sudoers

USER root
CMD /workspace/build_rpm.sh
