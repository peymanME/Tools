# Linux > Centos > SSL

## Configure SSL/TLS for Apache Tomcat

### Step 1: Create a Keystore
```bash
$ keytool -genkey -alias [YOUR ALIAS] -keyalg RSA -keystore [PATH\TO\YOUR\KEYSTORE].jks 
```

### Step 2: Provide the correct answer to all the questions
### Step 3: Create the CSR

If you have certificate from your hosting provider you can ignore the step

```bash
$ keytool -certreq -keylag RSA -alias -file [YOUR CERTIFICATE NAME].csr -keystroke [PATH/TO/YOUR/KEYSTORE].jks
```
### Step 4: Install the SSL certificate
```bash
$ keytool -import -alias root -keystore [PATH\TO\YOUR\KEYSTORE].jks -trustcacerts -file [YOUR CERTIFICATE NAME].crt
``` 

### Step 5: Configure Apache Tomcat to utilize the Secure Socket Layer
```bash
$ vi [YOUR\PATH\TO\TOMCAT]\conf\server.xml 
``` 
```xml
...
<connetcor port="8443" scheme="https" secure="true" SSLEnabled="true"
SSLCertificateFile="[/PATH/TO/YOUR/CERTIFICATE].crt"
SSLCertificateKeyFile="[/PATH/TO/YOUR/KEYFILE]"
SSLPassword="[YOUR KEYSTORE PASSWORD]"
SSLCertificateChaineFile="[PATH/TO/YOUR/ROOT/CERTIFICATE]" KeyaAlias="[YOUR ALIAS]"
SSLProtocoal="TLSv1"/>
...
```
