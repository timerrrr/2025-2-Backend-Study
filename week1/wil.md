1. 1주차 학습내용
  1.1 웹
    - 클라이언트 - 서버 모델
       클라이언트가 요청을 보내면 서버가 요청을 받아 처리하고 그에 대한 응답을 보낸다. 그 응답을 클라이언트가 받아 사용한다.
    - URL
       웹에서 특정 자원의 위치를 나타내는 주소
       Host, Path, Query 등 포함
       http 등의 프로토콜 사용
  1.2 HTTP
    - HTTP 요청
       start line: 요청 메서드, 경로, HTTP 버전 정보 포함
       headers: 요청에 대한 부가정보 포함
       body: 실제 전송할 데이터
    - HTTP 응답
       status line: HTTP 버전, HTTP 상태코드, 상태메시지 포함
       headers: 응답에 대한 부가정보
       body: 실제 응답 데이터
  1.3 API
    - API
       클라이언트와 서버가 소통할때 어떻게 요청하고 응답할지를 정해놓은 규칙과 기능
  1.4 REST API
    - REST
       자원 - URI: 모든 자원은 고유한 URI 가짐 ex /members/1
       행위 - Method: 자원을 조작하기 위해 HTTP Method 사용
       표현: 서버와 클라이언트가 데이터를 주고받는 방식. JSON이 일반적.
    - HTTP Method
       POST: 리소스 생성
       GET: 리소스 조회
       PUT/PATCH: 리소스 수정
       DELETE: 리소스 삭제
    - HTTP 응답상태코드
    
       
