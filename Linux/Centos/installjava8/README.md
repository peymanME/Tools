# Linux > Centos > installjava8

## Installing Java 8 on CentOS 7

### Step 1: Update
As a matter of best practice we’ll update before installing any new programs:
```bash
yum -y update
```
### Step 2: Install Java 8
```bash
yum install java-1.8.0-openjdk
```

### Step 3:  Verify Java is Installed
```bash
java -version
```

Example Output:
```bash
java -version
openjdk version "1.8.0_191"
OpenJDK Runtime Environment (build 1.8.0_191-b12)
OpenJDK 64-Bit Server VM (build 25.191-b12, mixed mode)
```

## Set Java’s Home Environment
### Step 1: Find Java’s Path
Let’s set the JAVA_HOME variable, using the following command will give us a path so we can set the variable.

```bash
update-alternatives --config java
```
You’ll see a prompt to “Enter to keep the current selection[+], or type selection number:”, if you had multiple Java version you could set the default here, but all we need is the path of Java so we can exit pressing enter.  The highlighted area is the path we will need to copy/paste into our .bash_profile file.
```bash
Selection    Command
-----------------------------------------------
*+ 1           java-1.8.0-openjdk.x86_64 (/usr/lib/jvm/java-1.8.0-openjdk-1.8.0.191.b12-1.el7_6.x86_64/jre/bin/java)</code?
```
### Step 2: Setting Java’s Path in Your Environment
After copying your Java’s path, open the .bash_profile with your text editor.

```bash
vim .bash_profile
```
Export your Java path into the .bash_profile by adding the following to the bottom of the file. (Your path may look different from mine, and it’s not important that they vary.)
```bash
export JAVA_HOME=/usr/lib/jvm/java-1.8.0-openjdk-1.8.0.191.b12-1.el7_6.x86_64/jre/bin/java
```
Refresh the File:
```bash
source ~/.bash_profile
```
When you use the JAVA_HOME variable you’ll now be able to see the path you set.
```bash
echo $JAVA_HOME
```
Example Output:
```bash
/usr/lib/jvm/java-1.8.0-openjdk-1.8.0.191.b12-1.el7_6.x86_64/jre/bin/java
```
