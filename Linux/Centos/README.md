# Linux > Centos

## [Install Redmine on CentOS 7](https://www.vultr.com/docs/how-to-install-redmine-on-centos-7)
## [Installing and Configuring Pure-FTPD on RHEL / CentOS 7](https://www.alphahosting.com/blog/tips/installing-and-configuring-pure-ftpd-on-centos-7/)
## [open a port in the firewall on CentOS or RHEL](http://ask.xmodulo.com/open-port-firewall-centos-rhel.html)
## [Show All Running Processes in Linux using ps/htop commands](https://www.cyberciti.biz/faq/show-all-running-processes-in-linux/)
## [CentOS: Create admin user](https://www.printsupportcenter.com/hc/en-us/articles/360000680145-CentOS-Create-admin-user)

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
sudo firewall-cmd --permanent --add-port=21/tcp
sudo firewall-cmd --permanent --add-service=ftp
sudo firewall-cmd --reload
---------------------------------------
sudo ss -tulpn
---------------------------------------
ip a
```
## get information about Firewalld.
``` bash
sudo firewall-cmd --list-all
```
## listening
``` bash
netstat -ntap | grep LISTEN | grep ":80"
```

# Restore SELinux
``` bash
sed -i -e 's/SELINUX=disabled/SELINUX=enforcing/g' /etc/sysconfig/selinux
touch /.autorelabel
reboot
```
# Network state
```bash
 nmtui
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

##  list all Unix group names
``` bash 
cut -d: -f1 /etc/group | sort
```

## delete directory
```bash
rm -f -r [DIR NAME]
```

## to check permissions of a specific directory
```bash
ls -ld [DIR NAME]
```
## to change the primary group a user is assigned
```bash
usermod -g [GROUP NAME] [USER NAME]
```
## add a User account to a group
```bash
usermod  -a -g [GROUP NAME] [USER NAME]
```
## change permission
```bash
chown [GROUP NAME]:[USER NAME] [PATH/FOLDER]
```

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

# Remove GitLab CE
That directory is populated with gitlab-ce reconfigure command after installation and holds variable data, configurations related to gitlab-ce package.

The recommended process to uninstall it was

Remove services

``` bash
 sudo gitlab-ctl uninstall
```
Clean any data generated by usage of the package
``` bash
sudo gitlab-ctl cleanse
```
You may also want to remove any accounts you configured. To do so

``` bash
sudo gitlab-ctl remove-accounts
```
Then remove the package using
``` bash
sudo dpkg -P gitlab-ce
```
Furthermore, gitlab-ce uses these directories (as described here)

/opt/gitlab holds application code for GitLab and its dependencies.
/var/opt/gitlab holds application data and configuration files that gitlab-ctl reconfigure writes to.
/etc/gitlab holds configuration files for omnibus-gitlab. These are the only files that you should ever have to edit manually.
/var/log/gitlab contains all log data generated by components of omnibus-gitlab.
So, First remove the package recommended way (Even if you need to reinstall it). You can then remove those data using rm safely.
