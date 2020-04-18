# Linux > Centos > mysql

## Install mysql

### Step:1 In a web browser, visit:
``` bash
    https://dev.mysql.com/downloads/repo/yum/ 
```
### Step:2 Download the mysql *.noarch.rpm file
For example:
```bash
    wget https://dev.mysql.com/get/mysql80-community-release-el7-3.noarch.rpm
```

### Step:3 Install the package

```bash
    md5sum mysql80-community-release-el7-3.noarch.rpm
    sudo rpm -ivh mysql80-community-release-el7-3.noarch.rpm
    sudo yum install mysql-server
```     
### Step:4 Starting MySQL.

```bash
    sudo systemctl start mysqld
    sudo systemctl status mysqld 
```

### Step:5 Get a temporary password
During the installation process, a temporary password is generated for the MySQL root user.
Locate it in the mysqld.log with this command:

```bash
    sudo grep 'temporary password' /var/log/mysqld.log
```

### Step:6 Configuring MySQL

```bash
    sudo mysql_secure_installation
  ```  
This will prompt you for the default root password.
 As soon as you enter it, you will be required to change it.
 Enter a new 12-character password that contains at least one uppercase letter, one lowercase letter, one number and one special character.
 Re-enter it when prompted.
 After we decline the prompt to change the password again, we’ll press Y and then ENTER to all the subsequent questions in order to remove anonymous users, disallow remote root login, remove the test database and access to it, and reload the privilege tables.
 

### Step:7 Testing MySQL

```bash
    mysqladmin -u root -p version
```
