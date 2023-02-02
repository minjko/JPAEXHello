# [ JAVA 표준 ORM 프로그래밍 ] 스터디

### 0. 프로젝트 생성
- java 11
- maven
- h2 Database 2.1.214

### 1. 라이브러리 추가
- pom.xml
- 설치한 h2 Database의 버전을 확인하여 작성한다 (http://www.h2database.com)

### 2. JPA 설정
- src/main/resources/META-INF/persistence.xml
- DB 방언, 드라이버 등을 설정한다

### 3. 애플리케이션 개발
- src/main/java/hellojpa/JpaMain.java
- EntityManagerFactory 객체 생성 시, persistence.xml의 persistence-unit의 name 값을 참고한다
 
