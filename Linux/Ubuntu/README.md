# Ubuntu 

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
