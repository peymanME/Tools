# Windows command line

## To kill a process by its PID

```bash
    taskkill /F /PID [PID_NUMBER]
``` 

## To kill a process by its name

```bash
    taskkill /IM "[PROCESS_NAME]" /F
```
## To see the list of running processes

```bash
    tasklist | more
```
## Checking which application is using a ports

```bash
    netstat -aon | findstr :[PORT_NUMBER]
```
or 
```
netstat -aon | find /i "listening"
```
or 
```
netstat -aon | find /i "listening" |find "port"
```
## Checking which application is using a pid

```bash
    tasklist | find '[PID]'
```
## Check SMTP Port 587
```bash
    telnet localhost.tld 587
```
## There's a native GUI for Windows:
```
resmon.exe
```
