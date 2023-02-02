# [ JAVA 표준 ORM 프로그래밍 ] 스터디

### 0. 프로젝트 생성
>- java 11
>- maven 
>- h2 Database 2.1.214

### 1. 라이브러리 추가
>pom.xml
- 설치한 h2 Database의 버전을 확인하여 작성한다 (http://www.h2database.com)

### 2. JPA 설정
>src/main/resources/META-INF/persistence.xml
- DB 방언, 드라이버 등을 설정한다

### 3. 애플리케이션 개발
>src/main/java/hellojpa/JpaMain.java
- EntityManagerFactory 객체 생성 시, persistence.xml의 persistence-unit의 name 값을 참고한다
- ﻿javax.xml.bind.JAXBException 관련 오류 발생 시, pom.xml에 dependency 추가 (commit 기록 참고)
- main 함수 실행 시, 터미널에 빨간 글씨 있어도 괜찮다. 단,exit code는 0이어야 한다
>테이블 생성
- 터미널 창에서 h2 database 실행
  (windows : .\h2.bat )
- persistence.xml의 property에서 jdbc url 값을 h2 database에 로그인할 때 Generic H2 (Server)로 설정하고, jdbc url 칸에 삽입 후 연결 버튼을 누른다
- create table Member ( id bigint not null, name varchar(255), primary key (id) );
>객체 생성
- src/main/java/hellojpa/Member.java
>객체와 테이블 매핑
- src/main/java/hellojpa/JpaMain.java
- 회원 저장
   - h2 database에서 확인 (select * from member;)


데이터 변경은 Transaction 내에서 이루어져야 한다