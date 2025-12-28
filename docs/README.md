# 버거킹 키오스크 만들기

```java
    이번 과제는 구현은 하였지만 아직 검증 및 리팩토링이 진행되지 않았습니다.
```

- 문제정의
    - 화면 구성
        - 홈
            - 햄버거 | 사이드 | 음료 | 장바구니 | 종료
        - 햄버거 | 사이드 | 음료 선택
            - 리스트와 가격
        - 장바구니
            - 담은 메뉴 리스트
            - 주문하기 | 수량 조절하기 | 삭제하기
- 설계
    - 구상
        - Class
            - 메뉴

                ```java
                - 이름
                - 가격
                ```

            - 햄버거 extends 메뉴

                ```java
                + toString()
                ```

            - 사이드 extends 메뉴

                ```java
                + toString()
                ```

            - 음료 extends 메뉴

                ```java
                + toString()
                ```

            - 장바구니

                ```java
                - 메뉴
                - 개수
                
                + 주문하기()
                + 수량 조절하기()
                + 삭제하기()
                ```

            - 키오스크

                ```java
                - ArrayList<장바구니>
                
                + 홈()
                + 햄버거()
                + 사이드()
                + 음료()
                + 장바구니()
                + 주문하기()
                + 수량 조절하기()
                + 삭제하기()
                
                + 종합()
                ```

        - Enum
            - 햄버거 | 사이드 | 음료 : Enum

                ```java
                - 이름
                - 가격
                
                + toString()
                + 전체 출력
                ```

            - 장바구니 : Class

                ```java
                - 이름
                - 개수
                
                + valueOf()로 가격 계산
                ```

            - 키오스크

                ```java
                + 햄버거
                + 사이드
                + 음료
                
                - ArrayList<Enum> 메뉴
                - arraylist 장바구니
                
                + 주문
                + 수량 
                + 삭제
                ```

    - 구현
        - Class
            - Cart
            - Item
            - Kiosk
        - Enum
            - Drink
            - Hamburger
            - Side
