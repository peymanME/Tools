# Linux > Centos > mysql > commands

## To create a new MySQL user account

``` bash
    CREATE USER '[NEWUSER]'@'localhost' IDENTIFIED BY '[PASSWORD]';
```
## Remove an Existing MySQL User Account

``` bash
    DROP USER '[YOURUSER]'@'localhost';
```
## Create a MySQL Database

``` bash
    CREATE DATABASE IF NOT EXISTS [NEWDATABASE];
```
## Display MySQL User Account Privileges

``` bash
    SHOW GRANTS FOR '[YOUR_USER]';
    --
    SHOW GRANTS FOR '[YOUR_USER]'@'localhost';
```
The most commonly used privileges are:
``` bash
ALL PRIVILEGES – Grants all privileges to a user account.
CREATE – The user account is allowed to create databases and tables.
DROP - The user account is allowed to drop databases and tables.
DELETE - The user account is allowed to delete rows from a specific table.
INSERT - The user account is allowed to insert rows into a specific table.
SELECT – The user account is allowed to read a database.
UPDATE - The user account is allowed to update table rows.```
```
## Grand all privileges to a user account over a specific database

``` bash
    GRANT ALL PRIVILEGES ON [YOUR_DATABASE].* TO '[YOUR_USER]'@'localhost';
```
##  Reload the permissions
```bash 
FLUSH PRIVILEGES;
```
## List of hosts to access
``` bash 
SELECT host FROM mysql.user WHERE User = '[YOUR USER]';
```

## Change password
```bash
mysql> ALTER USER '[YOUR USER]'@'localhost' IDENTIFIED BY '[NEW USER PASSWORD]';
mysql> FLUSH PRIVILEGES;
```

## Backup file
```bash
$ mysqldump [YOUR DATABASE NAME] -u [YOUR USER] -p -h 'localhost'  > [YOUR/PATH/TO/FILE].sql 
```
# Changing the mysql root account password
## Stop mysql:
```bash
$ systemctl stop mysqld
```
## Set the mySQL environment option:
```bash
$ systemctl set-environment MYSQLD_OPTS="--skip-grant-tables"
```
## Start mysql using the options you just set:
```bash
$ systemctl start mysqld
```
## Login as root:
```bash
$ mysql -u root
```
## Update the root user password with these mysql commands:
```bash
mysql> ALTER USER 'root'@'localhost' IDENTIFIED BY '[YOUR PASSWORD]';
ERROR 1290 (HY000): The MySQL server is running with the --skip-grant-tables option so it cannot execute this statement
mysql> FLUSH PRIVILEGES;
mysql> ALTER USER 'root'@'localhost' IDENTIFIED BY '[YOUR PASSWORD]';
mysql> FLUSH PRIVILEGES;
```
## Stop mysql:
```bash
$ systemctl stop mysqld
```
## Unset the mySQL envitroment option so it starts normally next time:
```bash
$ systemctl unset-environment MYSQLD_OPTS
```
## Start mysql normally:
```bash
$ systemctl start mysqld
```

## Disable ssl
```bash
$ sudo vim /etc/mysql/mysql.conf.d/mysqld.cnf
```
```cnf
[mysqld]
...

skip_ssl
# disable_ssl

...
```
