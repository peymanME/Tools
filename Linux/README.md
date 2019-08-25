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