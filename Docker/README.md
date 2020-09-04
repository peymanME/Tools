# Docker
* [Run postgres on dicker](https://github.com/peymanME/Tools/edit/master/Docker/README.md)

## Run postgres on dicker
### Step 1: Pull postgres image
```bash
$ docker pull postgres
```
### Step 2: Run postgres container
```bash
$ docker run --name [YOUR NAME CONTAINER] -p 5432:5432 -e POSTGRES_PASSWORD=[YOUR PASSWORD] -d postgres
```
### Step 3: Test your container
```bash
$ docker ps
```
### Step 4: Connect to postgres
```bash
$ docker exec -it [YOUR NAME CONTAINER] bash
```

----
## Stop container
```bash
$ docker stop [YOUR NAME CONTAINER]
$ docker rm [YOUR NAME CONTAINER]
```
## To get rid of everything
```bash
$ docker system prune
```

## Run MySql5.7 on dicker
### Step 1: Start Mysql container
```bash
$ docker run --name mysql57 -p 3306:3306 -e MYSQL_ROOT_PASSWORD=1234 -d mysql/mysql-server:5.7
```
### Step 2: Check your container running
```bash
$ docker ps -a
```
### Step 3: Create a database
```bash
$ docker exec -it mysql57 bash
```
- #### Access the mysql container
```bash
    bash# mysql -h localhost -u root -p
``` 
- #### Create a user for out-of-container access
```bash
    mysql> CREATE USER '[YOUR USER]' IDENTIFIED BY '[YOUR PASSWORD]';
    mysql> grant all on *.* to '[YOUR USER]'@'%' identified by '[YOUR PASSWORD]';
    mysql> FLUSH PRIVILEGES;
```
- #### Create a database
```bash
    mysql> CREATE DATABASE [YOUR DATABASE NAME] CHARACTER SET utf8 COLLATE utf8_general_ci;
```
### OR Step 2: Check your container running
```bash
$ docker run --name mysql57 -p 3306:3306 \
    -e MYSQL_ROOT_PASSWORD=1234 \
    -e MYSQL_USER=[YOUR USER] \
    -e MYSQL_PASSWORD=[YOUR PASSWORD] \
    -e MYSQL_DATABASE=[YOUR DATABASE NAME] \
    -d mysql/mysql-server:5.7
```

----


## Install docker on windows 10 home 

### 1. Install Oracle VirtualBox 
#### - Install ubuntu
##### - Install docker
``` bash
    $ sudo apt-get update
    $ sudo apt-get remove docker docker-engine docker.io
    $ sudo apt install docker.io
    $ sudo systemctl start docker
    $ sudo systemctl enable docker
    $ docker --version
``` 
