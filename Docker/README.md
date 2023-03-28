# Docker
* [Run postgres on dicker](https://github.com/peymanME/Tools/blob/master/Docker/README.md#run-postgres-on-dicker)
* [Run MySql5.7 on dicker](https://github.com/peymanME/Tools/blob/master/Docker/README.md#run-mysql57-on-dicker)
* [Run mongodb on dicker](https://github.com/peymanME/Tools/blob/master/Docker/README.md#run-mongodb-on-dicker)
---
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

---

## Stop container
```bash
$ docker stop [YOUR NAME CONTAINER]
$ docker rm [YOUR NAME CONTAINER]
```
## Remove image
```bash
$ docker rmi [IMAGE-ID]
```
## Remove container
```bash
$ docker rm [CONTAINER-ID]
```

## To get rid of everything
```bash
$ docker system prune
```

## Run MySql5.7 on dicker
### Step 1: Start Mysql container
```bash
$ docker run --name mysql57 -p 3306:3306 -e MYSQL_ROOT_PASSWORD=my-secret-pw -d mysql/mysql-server:5.7
```
OR
#### save on local
```bash
docker run --rm --name mysql57 -p 3306:3306 -v /[SOMEDIR_IN_YOUR_HOME]/mysql:/var/lib/mysql -e MYSQL_ROOT_PASSWORD=my-secret-pw -d mysql/mysql-server:5.7
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
    ###### mysql 8
    mysql> GRANT ALL PRIVILEGES ON [YOUR DATABASE or *].* TO '[YOUR USER]'@'localhost';
    ######
    mysql> GRANT SELECT, INSERT ON [YOUR DATABASE].* TO '[YOUR USER]'@'[YOUR IP]';
    mysql> FLUSH PRIVILEGES;
    mysql> SELECT * FROM mysql.user
```
- #### Create a database
```bash
    mysql> CREATE DATABASE [YOUR DATABASE NAME] CHARACTER SET utf8 COLLATE utf8_general_ci;
```
## Run mongodb on dicker
### Step 1: Pull mongo
```bash
$ docker pull mongo
```
### Step 2: Create a /mongodata directory on the host system
### Step 3: Start the Docker container
```bash
$ docker run -it -v /data/db:/mongodata -p 27017:27017 --name mongodb -d mongo
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
----
## Run command on the win command 
```bash
winpty docker exec -it [YOUR_NAME_CONTAINER] bash
```

## Check docker enviroment
```bash
env
```


