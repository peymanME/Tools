# Ubuntu

## remove divice 
```bash
$ sudo dpkg --remove --force-remove-reinstreq {PACKAGE-NAME}
```

## check Ubuntu version
```bash
$ hostnamectl
```
or
```bash
$ cat /etc/issue
```

## Increase swap in 20.04
```bash
$ sudo swapoff /swapfile  
$ sudo rm  /swapfile
$ sudo dd if=/dev/zero of=/swapfile bs=1M count={YOUR-AMOUNT}
$ sudo chmod 600 /swapfile
$ sudo mkswap /swapfile
$ sudo swapon /swapfile
```
- restart ubuntu

## Check swap usage size and utilization in Linux
```bash
$ swapon -s
```
or
```bash
$ free -m
```

## Status of firewall
```bash
sudo ufw status
```
## Open the port
```bash
sudo ufw allow 443/tcp
```

## Checking Ubuntu Version From the Terminal

```bash
    $ lsb_release -a
```

## Clipboard sharing
```bash
sudo apt install linux-headers-$(uname -r) build-essential dkms
```
## Extract
```bash
tar -xf archive.tar.gz -C /home/linuxize/files
```
## Install notepad++
```bash
sudo snap install notepad-plus-plus
```

## If the java command works, you can to find the location of the java by the following command:
```bash
readlink -f $(which java)
```
---

# nmap
## Checking open port
```bash
sudo nmap -sS localhost
```
