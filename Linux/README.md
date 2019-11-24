# Linux 

## Checking ports

```bash
    netstat -plntu
``` 
   or
```bash
    sudo netstat -tulpn | grep LISTEN
```
##List all groups
```bash
    cut -d':' -f 1 /etc/group
```
##Users can't see my files
~ (your homedir) only accessible to yourself (the root user will also be able to access it, but no one else).
```bash
    chmod 700 ~
```