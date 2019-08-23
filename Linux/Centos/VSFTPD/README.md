# Linux > Centos > VSFTPD

## Install VSFTPD

### Step:1 Install vsftpd and ftp 
``` bash
    yum install vsftpd ftp -y
```

### Step:2 Configure vsftpd
Edit vsftpd configuration file /etc/vsftpd/vsftpd.conf,
```bash
    vi /etc/vsftpd/vsftpd.conf
```
Find the following lines and make the changes as shown below:
```bash
[...]
## Disable anonymous login ##
anonymous_enable=NO

## Uncomment ##
ascii_upload_enable=YES
ascii_download_enable=YES

## Uncomment - Enter your Welcome message - This is optional ##
ftpd_banner=Welcome to UNIXMEN FTP service.

## Add at the end of this  file ##
use_localtime=YES
### Step:3 Extract the downloaded file and set CATALINA_HOME variable
```
Enable and start the vsftpd service:
```bash 
systemctl enable vsftpd
systemctl start vsftpd
```
### Step:3 Firewall And SELinux Configuration.
Allow the ftp service and port 21 via firewall.
```bash 
firewall-cmd --permanent --add-port=21/tcp
firewall-cmd --permanent --add-service=ftp
```
Restart firewall:
```bash 
firewall-cmd --reload
```
Then, update the SELinux boolean values for FTP service:
```bash 
setsebool -P tftp_home_dir on
```
### Step:4 Create Tomcat User
By default, root user is not allowed to login to ftp server for security purpose. So, let us create a normal testing user called “sk” with password “centos”.
```bash
useradd sk
passwd sk
```

### Step:5 Connecting to FTP server
Now, try to connect to FTP server itself with user “sk”:
```bash
    ftp localhost
  ```  
Enter the ftp user name and password.

Sample Output:


```bash
    Connected to 192.168.1.101 (192.168.1.101).
    220 Welcome to UNIXMEN FTP service.
    Name (192.168.1.101:root): sk
    331 Please specify the password.
    Password:
    230 Login successful.
    Remote system type is UNIX.
    Using binary mode to transfer files.
    ftp>
```
## Remove VSFTPD
```bash
yum remove vsftpd
```