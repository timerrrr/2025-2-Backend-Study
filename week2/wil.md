# 2주차 학습내용

  ## 1. 스프링 계층형 아키텍쳐

    ### 스프링 계층형 아키텍쳐

        Borwser <-> Controller <-> Service <-> DAO <-> DB

        로 구성

       

    ### DTO, Entity

       + DTO

       데이터 전송 객체

       필요한 정보만 전달

       + Entity

       DB테이블과 맵핑되는 핵심 객체
       
       외부 직접 노출 금지
    
    ### Controller 계층

    HTTP 요청 및 응답

    DTO를 사용하여 서비스 계층과 데이터 교환

    ### Service 계층

    애플리케이션의 비즈니스로직 구현

    DTO or 엔티티로 레포지토리 계층과 소통



  ## 2. Response Entity 메서드

    ### 200 OK
    
     + ok.build() -> body X

     + ok(data) or ok().body(data) -> body = data

    ### 201 Created

     + created(uri).build() -> body X

    ### 204 No Content

     + noContent().build() -> body X



## 3. 스프링 빈 & 스프링 컨테이너

    ### 스프링 빈

        전역에서 사용할 공용 객체

        컨테이너에 빈을 저장, 필요한 빈을 받아 사용

        빈을 요구하는 객체 역시 스프링 빈

    ### 컴포넌트 스캔

        어떤 클래스가 빈인지 찾아 등록

        + 컴포넌트
            빈으로 등록하고 싶은 클래스에 @Component 붙이기
        
    ### 의존성 주입

        의존하는 객체를 직접 생산하지 않고 밖에서 주입받음.

        메모리 효율적 사용 가능
    
    ### 생성자 주입

        + final로 선언

        + @Autowired 사용하여 생성자 통해 빈 주입

        + 생성자가 하나만 있으면 @Autowired 생략 가능

        + @RequiredArgsConstructor로 간단하게 생성자 주입 가능


