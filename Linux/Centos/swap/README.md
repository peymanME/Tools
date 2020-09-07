# Linux > Centos > swap

## To Add Swap on CentOS 7

### step 1: Check the System for Swap Information

```bash
swapon -s
```
Or
```bash
free -m
```
Check Available Storage Space
```bash
df -h
```
Real swap partition or a swap file
```bash
swapon --show
```

### Step 2: Create a Swap File
This command will create a 4 gigabyte file.
```bash
sudo dd if=/dev/zero of=/swapfile count=4096 bs=1MiB
```

### Step 3: Enable a Swap File
Check the permissions on our swap file.
```bash
ls -lh /swapfile
```
It isn’t readable by anyone besides the root account.
```bash
sudo chmod 600 /swapfile
```
System to set up the swap space.
```bash
sudo swapon /swapfile
```

### Step 4: Make the Swap File Permanent
```bash
sudo nano /etc/fstab
```
Adding the line.
```bash
/swapfile   swap    swap    sw  0   0
```

### Step 5: Swappiness (Optional)
Swappiness configuration file.
```bash 
 vi /proc/sys/vm/swappiness
```
This setting will persist until the next reboot.
```bash 
sudo sysctl vm.swappiness=[0-100]
```
The server will now automatically set the swappiness to the value.
```bash
sudo nano /etc/sysctl.conf
```
Add the outputted line to our sysctl configuration file.
```bash
vm.swappiness = [0-100]
```
### Step 6: Cache Pressure (Optional)
Cache Pressure configuration file.
```bash 
 vi /proc/sys/vm/vfs_cache_pressure
```
This setting will persist until the next reboot.
```bash 
sudo sysctl vm.vfs_cache_pressure=[0-100]
```
The server will now automatically set the cache pressure to the value.
```bash
sudo nano /etc/sysctl.conf
```
Add the outputted line to our sysctl configuration file.
```bash
vm.vfs_cache_pressure = [0-100]
```
