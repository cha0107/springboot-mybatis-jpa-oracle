# Work Team - Spring Boot Example

## 使用技術
Spring Boot, Maven, mybatis, Spring Data JPA, Oracle

## 使用說明
* 1. oracle jdbc driver因license問題無法直接由POM檔設定後自動下載，改讀project下 resources/lib/ojdbc7.jar檔案，無須另外設定

* 2. 於Maven Build設定Goals為clean spring-boot:run並執行

* 3. 於瀏覽器輸入http://localhost:9090/api/
