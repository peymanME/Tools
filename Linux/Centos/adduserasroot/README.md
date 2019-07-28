# Linux > Centos > adduserasroot

## How to Add a User and Grant Root Privileges on CentOS 7

### Step 1: Add the User
It’s just one simple command to add a user. In this case, we’re adding a user called mynewuser :
```bash
adduser mynewuser
```
Now set the password for the new user:
```bash
passwd mynewuser
```
Step 2: Grant Root Privileges to the User
For a refresher on editing files with vim see: New User Tutorial: Overview of the Vim Text Editor
```bash
visudo
```
Find the following code:
```bash
## Allow root to run any commands anywhere
root ALL=(ALL) ALL
```
In this case, we’re granting root privileges to the user mynewuser . Add the following below that code:
```bash
mynewuser ALL=(ALL) ALL
```
Then exit and save the file with the command :wq .

If you’ve followed the instruction above correctly, then you should now have a user setup by the name of mynewuser which can use sudo to run commands as root!