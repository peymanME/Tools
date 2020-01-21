# Maven

## Important commands

### 1. 
    ```bash 
    mvn dependency:tree -Dincludes=:spring*:
    ```
### 2. 
    ```bash 
    mvn package -Dmaven.test.skip=true
    ```
### 3. Really two commands run in sequence will first build the library and then run the application
    ```bash 
    mvn install && mvn spring-boot:run -pl application
    ```

# Notes

## 