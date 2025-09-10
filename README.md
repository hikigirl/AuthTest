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
   2. DB작업 -> 확인
   3. 결과
      1. 맞다 -> 인증 티켓 발급
      2. 틀리다 -> 경고
2. AuthDAO.java
   1. login() 메서드 구현. LoginOk.java에서 호출
3. LogoutOk.java
   1. 로그아웃 = 티켓 정보 날리기
4. index.jsp
   1. 로그인 여부에 따라 보여줄 화면 변경(로그인정보 출력, 로그인/아웃 버튼 표시)
   2. 회원 전용 페이지 → 우회 경로 접근제어 필요
   3. 관리자 전용 페이지 → 우회 경로 접근제어 필요
5. Member.java, Admin.java
   1. 우회 경로 접근제어
   2. 방금 이 서블릿을 요청한 사람이 인증받은 사람인지를 검사