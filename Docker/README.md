# Docker

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
