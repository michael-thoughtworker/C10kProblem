## About The Project

This repo is used to help evaluate the performance of web server with different IO model
## Getting Started

You need to install mvn command in your system

### Usage

To compile the code
* compile
  ```sh
  mvn clean compile
  ```

To run the bio example code
* bio
  ```sh
  mvn exec:java -Dexec.mainClass="com.example.bio.main"
  ```

To run the bio multi threading example code
* bioMultiThreading
  ```sh
  mvn exec:java -Dexec.mainClass="com.example.bioMultiThreading.main"
  ```

To run the bio thread pool example code
* bioThreadPool
  ```sh
  mvn exec:java -Dexec.mainClass="com.example.bioThreadPool.main"
  ```

To run the nio example code
* nio
  ```sh
  mvn exec:java -Dexec.mainClass="com.example.nio.main"
  ```
  
To run the tomcat example code
* tomcat
  ```sh
  mvn exec:java -Dexec.mainClass="com.example.tomcat.main"
  ``

To run the netty server example code
* netty
  ```sh
  cd netty
  mvn clean compile
  mvn exec:java -Dexec.mainClass="com.example.netty.main"
  ``
  
To provision one linux server via vagrant
```sh
cd vagrant
make setup
```

To run performance testing
```sh
cd perf
k6 run main.js  -e TPS=200 -e DURATION=60s -e DEBUG=false -e VUS=1000
```

To montior the system call

```sh
cd perf
sudo strace -f  -p 22844 2>&1 | grep -E “22844|clone|HTTP”
```