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
## Allow a logged-in user to upload files to your FTP server.

Limit FTP users to their own home directory. Find and adjust the entry to match the following:
```bash
 chroot_local_user=YES
 allow_writeable_chroot=YES
```
**Note**: for test purposes, the allow_writeable_chroot=YES option will create a functioning FTP server that you can test and use. Some administrators advocate the use of the user_sub_token option for better security. Refer to the vsftpd [documentation](http://vsftpd.beasts.org/vsftpd_conf.html) for more information on this option.

The vsftpd utility provides a way to create an approved user list. To manage users this way, find the userlist_enable entry, then edit the file to look as follows:
```bash
userlist_enable=YES
userlist_file=/etc/vsftpd/user_list
userlist_deny=NO
```
You can now edit the /etc/vsftpd/user_list file, and add your list of users. (List one per line.) The userlist_deny option lets you specify users to be included; setting it to yes would change the list to users that are blocked.

Once you’re finished editing the configuration file, save your changes. Restart the vsftpd service to apply changes:
```bash
sudo systemctl restart vsftpd
```
Add the (sk) user to the userlist:
```bash
echo sk | sudo tee –a /etc/vsftpd/user_list
```
Create a directory for the (sk) user, and adjust permissions:
```bash
mkdir –p /home/testuser/ftp/upload
chmod 550 /home/sk/ftp
chmod 750 /home/sk/ftp/upload
chown –R testuser: /home/sk/ftp
```
**Note**: This creates a home/sk directory for the new user, with a special directory for uploads. It sets permissions for uploads only to the /uploads directory.
## Remove VSFTPD
```bash
yum remove vsftpd
```