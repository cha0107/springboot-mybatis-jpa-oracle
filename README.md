# Work Team - Spring Boot Example

## 使用技術
Spring Boot, Maven, mybatis, Spring Data JPA, Oracle

## 使用說明
* 1. oracle jdbc driver因license問題無法直接由POM檔設定後自動下載，執行以下mvn指令將Jar安裝至local repository
install:install-file -DgroupId=com.oracle -DartifactId=ojdbc8 -Dversion=19.3.0.0 -Dpackaging=jar -Dfile=D:\dev_software\Oracle_JDBC_Driver\ojdbc8.jar

* 2. 於Maven Build設定Goals為clean spring-boot:run並執行

* 3. 於瀏覽器輸入http://localhost:9090/swagger-ui.html可使用Swagger測試WebAPI
