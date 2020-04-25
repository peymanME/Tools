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

