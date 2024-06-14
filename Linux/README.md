# Linux 

## Change some attribute value on json file 
```bash
sed -i -E "s/\"Host\": \"$target\"/\"Host\": \"$replace\"/" $pgadmin
```

## Kill the process by port
```bash
fuser -k 8080/tcp 
```

## Checking ports

```bash
    netstat -plntu
``` 
   or
```bash
    sudo netstat -tulpn | grep LISTEN
```
## List all groups

```bash
    cut -d':' -f 1 /etc/group
```
## How to change directory permissions in Linux
To change directory permissions in Linux, use the following:
```bash
chmod +rwx filename to add permissions.
chmod -rwx directoryname to remove permissions.
chmod +x filename to allow executable permissions.
chmod -wx filename to take out write and executable permissions.
```
Note that “r” is for read, “w” is for write, and “x” is for execute. 

## Users can't see my files

~ (your homedir) only accessible to yourself (the root user will also be able to access it, but no one else).

```bash
    chmod 700 ~
```
## Only root user to access

```bash
sudo chown -R root:root [YOUR DIR]

sudo chmod 0750 [YOUR DIR]
```

## Find directory 
```bash
    find / -type d -name "[dir-name-here]" 
```

## Unpack
```bash
tar -C /myfolder -zxvf file_name.tar.gz
```

## Show [USER] in the list as sudo
```bash
grep '^sudo' /etc/group
```

## To add a particular user to a particular group
```bash
sudo usermod -a -G groupname username
```
## To grant the user permission to just the current directory
```bash
sudo chmod 775 directory_name
```
## Type any one of the following command to check if a port is in use on Linux
```bash
sudo lsof -i -P -n | grep LISTEN
sudo netstat -tulpn | grep LISTEN
sudo netstat -tulpn | grep :443
sudo ss -tulpn | grep LISTEN
sudo ss -tulpn | grep ':22'
```

## Listening on a port on Linux
```bash
sudo netstat -tulpn | grep :443
sudo ss -tulpn | grep :443
```
