# Linux > Centos

# Routine commands

## apache is running
``` bash
pgrep apache
```
## restart and get status a service
``` bash
sudo systemctl restart [YOUR SERVICE]
sudo systemctl status [YOUR SERVICE]
```
## restart and get status a service
``` bash
sudo firewall-cmd --permanent --zone=public --add-service=http
sudo firewall-cmd --permanent --zone=public --add-service=https
sudo firewall-cmd --reload
---------------------------------------
sudo ss -tulpn
---------------------------------------
ip a
```
## listening
``` bash
netstat -ntap | grep LISTEN | grep ":80"
```
## to give some clues
``` bash
iptables -nL
```
## change password
```bash
sudo passwd [USER]
```
## list process with the ps command
``` bash
ps -aux | less
// show all processes on your server/workstation
ps -A
ps -e
// to see every process except those running as root
ps -U root -u root -N
ps -U root -u root --deselect
//  to display a tree of processes
pstree
// Get info about threads
ps -eLf
ps axms
// Get security info
ps -eo euser,ruser,suser,fuser,f,comm,label
ps axZ
ps -eM

```

# [Install Redmine on CentOS 7)[https://www.vultr.com/docs/how-to-install-redmine-on-centos-7]
# [Show All Running Processes in Linux using ps/htop commands](https://www.cyberciti.biz/faq/show-all-running-processes-in-linux/)

# Install Jenkins on CentOS

## Update CentOS 7 system
``` bash
sudo yum install epel-release
sudo yum update
sudo reboot
```
## Install 
```bash 
sudo yum install firewalld
sudo systemctl start firewalld
sudo systemctl enable firewalld
sudo systemctl status firewalld
```

## Install Java
```bash
sudo yum install java-1.8.0-openjdk.x86_64
java -version
sudo cp /etc/profile /etc/profile_backup
echo 'export JAVA_HOME=/usr/lib/jvm/jre-1.8.0-openjdk' | sudo tee -a /etc/profile
echo 'export JRE_HOME=/usr/lib/jvm/jre' | sudo tee -a /etc/profile
source /etc/profile
```

## Install Jenkins
```bash
cd ~ 
sudo wget -O /etc/yum.repos.d/jenkins.repo https://pkg.jenkins.io/redhat-stable/jenkins.repo
sudo rpm --import https://pkg.jenkins.io/redhat-stable/jenkins.io.key
yum install jenkins
sudo systemctl start jenkins.service
sudo systemctl enable jenkins.service
sudo firewall-cmd --zone=public --permanent --add-port=8080/tcp
sudo firewall-cmd --reload
```
# Install GitLab CE

## Perform basic tasks for hosting GitLab CE
``` bash
sudo dd if=/dev/zero of=/swapfile count=4096 bs=1M
sudo chmod 600 /swapfile
sudo mkswap /swapfile
sudo swapon /swapfile
echo '/swapfile   none    swap    sw    0   0' | sudo tee -a /etc/fstab
free -m
echo 'vm.swappiness=10' | sudo tee -a /etc/sysctl.conf
sudo sysctl -p
cat /proc/sys/vm/swappiness

sudo firewall-cmd --permanent --add-service=http
sudo firewall-cmd --permanent --add-service=https
sudo systemctl reload firewalld.service

sudo yum install -y epel-release
sudo yum -y update && sudo shutdown -r now

sudo yum install -y curl policycoreutils-python openssh-server openssh-clients

sudo yum install -y postfix
sudo systemctl enable postfix.service
sudo systemctl start postfix.service

sudo firewall-cmd --permanent --add-service=smtp
sudo firewall-cmd --permanent --add-service=pop3
sudo firewall-cmd --permanent --add-service=imap
sudo firewall-cmd --permanent --add-service=smtps
sudo firewall-cmd --permanent --add-service=pop3s
sudo firewall-cmd --permanent --add-service=imaps
sudo firewall-cmd --reload

curl -sS https://packages.gitlab.com/install/repositories/gitlab/gitlab-ce/script.rpm.sh | sudo bash

sudo EXTERNAL_URL="http://gitlab.example.com" yum install -y gitlab-ce

```
