# Linux > Centos > tomecat9

## Install Apache Tomcat 9

### Step:1 Install Java 8
### Step:2 Download the Apache Tomcat 9 tar.gz file

For example:
```bash
    wget http://www-eu.apache.org/dist/tomcat/tomcat-9/v9.0.0.M17/bin/apache-tomcat-9.0.0.M17.tar.gz
```

### Step:3 Extract the downloaded file and set CATALINA_HOME variable

```bash
     tar -zxpvf apache-tomcat-9.0.0.M17.tar.gz -C /opt/
     cd /opt/
     mv apache-tomcat-9.0.0.M17.tar.gz tomcat
     echo "export CATALINA_HOME='/opt/tomcat/'" >> ~/.bash_profile
     source ~/.bash_profile
```     
### Step:4 Specify the Users for Manager GUI Page and Admin Page Access.
By default no user or account is allowed to access Manager GUI Page and Admin Page. So to grant access to the users add the following lines in the file “/opt/tomcat/conf/tomcat-users.xml” just above <tomcat-users> tag

```bash 
<!-- User linuxtechi who can access only manager section -->
<role rolename="manager-gui" />
<user username="linuxtechi" password="<Enter-Secure-Password>" roles="manager-gui" />

<!-- User Admin Who can access manager and admin section both -->
<role rolename="admin-gui" />
<user username="admin" password="<Enter-Secure-Password>" roles="admin-gui" />
```

### Step:5 Create Tomcat User

```bash
    sudo groupadd tomcat
    sudo useradd -M -s /bin/nologin -g tomcat -d /opt/tomcat tomcat
```

### Step:6 Update Permissions

```bash
    cd /opt/tomcat
    sudo chgrp -R tomcat /opt/tomcat
    sudo chmod -R g+r conf
    sudo chmod g+x conf
    sudo chown -R tomcat webapps/ work/ temp/ logs/
  ```  

### Step:7 Install Systemd Unit File

```bash
    sudo vi /etc/systemd/system/tomcat.service
```
Paste in the following script. You may also want to modify the memory allocation settings that are specified in CATALINA_OPTS:

```bash
# Systemd unit file for tomcat
[Unit]
Description=Apache Tomcat Web Application Container
After=syslog.target network.target

[Service]
Type=forking

Environment=JAVA_HOME=/usr/lib/jvm/jre
Environment=CATALINA_PID=/opt/tomcat/temp/tomcat.pid
Environment=CATALINA_HOME=/opt/tomcat
Environment=CATALINA_BASE=/opt/tomcat
Environment='CATALINA_OPTS=-Xms512M -Xmx1024M -server -XX:+UseParallelGC'
Environment='JAVA_OPTS=-Djava.awt.headless=true -Djava.security.egd=file:/dev/./urandom'

ExecStart=/opt/tomcat/bin/startup.sh
ExecStop=/bin/kill -15 $MAINPID

User=tomcat
Group=tomcat
UMask=0007
RestartSec=10
Restart=always

[Install]
WantedBy=multi-user.target
```  
Save and exit. This script tells the server to run the Tomcat service as the tomcat user, with the settings specified.

Now reload Systemd to load the Tomcat unit file:
```bash
sudo systemctl daemon-reload
```
Now you can start the Tomcat service with this systemctl command:
```bash
sudo systemctl start tomcat
```
Check that the service successfully started by typing:
```bash
sudo systemctl status tomcat
```
If you want to enable the Tomcat service, so it starts on server boot, run this command:
```bash
sudo systemctl enable tomcat
```
Tomcat is not completely set up yet, but you can access the default splash page by going to your domain or IP address followed by :8080 in a web browser:

Open in web browser:
http://server_IP_address:8080

### Step:8 Access the Web Interface

By default, newer versions of Tomcat restrict access to the Manager and Host Manager apps to connections coming from the server itself. Since we are installing on a remote machine, you will probably want to remove or alter this restriction. To change the IP address restrictions on these, open the appropriate context.xml files.

For the Manager app, type:
```bash
sudo vi /opt/tomcat/webapps/manager/META-INF/context.xml
```
For the Host Manager app, type:
```bash
sudo vi /opt/tomcat/webapps/host-manager/META-INF/context.xml
```
Inside, comment out the IP address restriction to allow connections from anywhere. Alternatively, if you would like to allow access only to connections coming from your own IP address, you can add your public IP address to the list:

context.xml files for Tomcat webapps
```bash
<Context antiResourceLocking="false" privileged="true" >
  <!--<Valve className="org.apache.catalina.valves.RemoteAddrValve"
         allow="127\.\d+\.\d+\.\d+|::1|0:0:0:0:0:0:0:1" />-->
</Context>
```
Save and close the files when you are finished.

To put our changes into effect, restart the Tomcat service:
```bash
sudo systemctl restart tomcat
```  