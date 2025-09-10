# AuthTest

- new dynamic web project
- 프로젝트명: AuthTest
- context root: auth
- Tomcat 9.0
- web.xml 체크

#### 파일

- com.test.java
  - Index.java: 시작페이지
- com.test.java.auth
  - Login.java: 로그인(폼)
  - LoginOk.java: 로그인(처리)
  - LogoutOk.java: 로그아웃(처리)
- com.test.java.member
  - Member.java: 회원 전용
- com.test.java.admin
  - Admin.java: 관리자 전용
- com.test.java.model
  - AuthDAO.java
  - UserDTO.java
  
- webapp/WEB-INF/views
  - index.jsp
  - auth/login.jsp
  - member/member.jsp
  - admin/admin.jsp
- AuthTest
  - script.sql

#### URL 설계

- /index.do
- /auth/login.do
- /auth/loginok.do
- /auth/logoutok.do
- /member/member.do
- /admin/admin.do

#### 라이브러리
- ojdbc8.jar
- jstl-1.2.jar
- lombok.jar

---

### 작업 순서
1. LoginOk.java
   1. 데이터 가져오기(id, pw)
   2. DB작업
2. 