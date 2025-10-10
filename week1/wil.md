<<<<<<< HEAD
# 1.1주차 학습내용
=======
# 1. 1주차 학습내용
>>>>>>> 5f00ec189b35d4fdfb1f5e9e30e0160583602c69

  ## 1.1 웹

    ### 클라이언트 - 서버 모델

       클라이언트가 요청을 보내면 서버가 요청을 받아 처리하고 그에 대한 응답을 보낸다. 그 응답을 클라이언트가 받아 사용한다.

    ### URL

       웹에서 특정 자원의 위치를 나타내는 주소

       Host, Path, Query 등 포함

       http 등의 프로토콜 사용


  ## 1.2 HTTP

    ### HTTP 요청

       start line: 요청 메서드, 경로, HTTP 버전 정보 포함

       headers: 요청에 대한 부가정보 포함

       body: 실제 전송할 데이터

    ### HTTP 응답

       status line: HTTP 버전, HTTP 상태코드, 상태메시지 포함

       headers: 응답에 대한 부가정보

       body: 실제 응답 데이터


  ## 1.3 API

    ### API

       클라이언트와 서버가 소통할때 어떻게 요청하고 응답할지를 정해놓은 규칙과 기능


  ## 1.4 REST API

    ### REST

       자원 - URI: 모든 자원은 고유한 URI 가짐 ex /members/1

       행위 - Method: 자원을 조작하기 위해 HTTP Method 사용

       표현: 서버와 클라이언트가 데이터를 주고받는 방식. JSON이 일반적.

    ### HTTP Method

       POST: 리소스 생성

       GET: 리소스 조회

       PUT/PATCH: 리소스 수정

       DELETE: 리소스 삭제

    ### HTTP 응답상태코드

       200: 요청 정상 수행

       201: 리소스 생성 요청 -> 성공적으로 생성

       400: 요청 부적절

       401: 인증되지 않은 클라이언트가 보호된 리소스 요청

       404: 요청된 리소스 없음


---


# 2. 스크린샷
![스크린샷](https://github.com/timerrrr/2025-2-Backend-Study/blob/main/week1/gdg_week1_screenshot.jpg)


---

# 3. 온라인 쇼핑몰 API 명세서

  ## 3.1 상품 기능

  + 상품 정보 등록

<<<<<<< HEAD
  HTTP Method: POST

  URI: /items
=======
    HTTP Method: POST

    URI: /items
>>>>>>> 5f00ec189b35d4fdfb1f5e9e30e0160583602c69

  + 상품 목록 조회

    HTTP Method: GET

    URI: /items

  + 개별 상품 정보 상세 조회

    HTTP Method: GET

    URI: /items/{itemId}

  + 상품 정보 수정
   
     HTTP Method: PATCH

     URI: /items/{itemId}
  
  + 상품 삭제

     HTTP Method: DELETE

     URI: /items/{itemId}


  ## 3.2 주문 기능

  + 주문 정보 생성

<<<<<<< HEAD
  HTTP Method: POST

  URI: /orders
=======
    HTTP Method: POST

    URI: /orders
>>>>>>> 5f00ec189b35d4fdfb1f5e9e30e0160583602c69

  + 주문 목록 조회

    HTTP Method: GET

    URI: /orders

  + 개별 주문 정보 상세 조회

    HTTP Method: GET

    URI: /orders/{orderId}
  
  + 주문 취소

     HTTP Method: DELETE

     URI: /orders/{orderId}
<<<<<<< HEAD


  

=======
    
>>>>>>> 5f00ec189b35d4fdfb1f5e9e30e0160583602c69
       
