package com.example.shop.common.message;

public class ErrorMessage {

    //Member 관련 에러메시지
    public static final String MEMBER_NOT_FOUND = "회원을 찾을 수 없습니다.";
    public static final String MEMBER_ALREADY_EXISTS = "이미 존재하는 로그인 아이디입니다.";

    //Order 관련 에러메시지
    public static final String ORDER_NOT_FOUND = "주문을 찾을 수 없습니다.";

    //Product 관련 에러메시지
    public static final String PRODUCT_NOT_FOUND = "상품을 찾을 수 없습니다.";

    // Member DTO
    public static final String LOGIN_ID_NOT_NULL = "로그인 아이디는 필수입니다.";
    public static final String LOGIN_ID_SIZE = "로그인 아이디는 4자 이상 20자 이하입니다.";
    public static final String PASSWORD_NOT_NULL = "비밀번호는 필수입니다.";
    public static final String PASSWORD_SIZE = "비밀번호는 8자 이상 20자 이하입니다.";
    public static final String PHONE_NUMBER_NOT_NULL = "전화번호는 필수입니다.";
    public static final String PHONE_NUMBER_FORM = "전화번호 형식은 010-xxxx-xxxx입니다.";
    public static final String ADDRESS_SIZE = "주소는 1자 이상 255자 이하입니다.";

    // Order DTO
    public static final String MEMBER_ID_NOT_NULL = "회원 ID는 필수입니다.";
    public static final String MEMBER_ID_MIN = "유효한 회원 ID를 입력해주세요. (최소 1)";
    public static final String POINT_USED_MIN = "사용 포인트는 0 이상이어야 합니다.";
    public static final String ORDER_ITEMS_NOT_NULL = "주문 상품 목록은 필수입니다.";
    public static final String ORDER_ITEMS_SIZE = "주문 상품은 최소 1개 이상이어야 합니다.";
    public static final String PRODUCT_ID_NOT_NULL = "상품 ID는 필수입니다.";
    public static final String PRODUCT_ID_MIN = "유효한 상품 ID를 입력해주세요. (최소 1)";
    public static final String QUANTITY_NOT_NULL = "주문 수량은 필수입니다.";
    public static final String QUANTITY_MIN = "주문 수량은 최소 1개 이상이어야 합니다.";

    //Product DTO
    public static final String PRODUCT_NAME_NOT_BLANK = "상품명은 필수입니다.";
    public static final String PRODUCT_NAME_SIZE = "상품명은 1자 이상 100자 이하로 입력해주세요.";
    public static final String PRODUCT_PRICE_NOT_NULL = "상품 가격은 필수입니다.";
    public static final String PRODUCT_PRICE_MIN = "상품 가격은 0 이상이어야 합니다.";
    public static final String PRODUCT_STOCK_NOT_NULL = "재고 수량은 필수입니다.";
    public static final String PRODUCT_STOCK_MIN = "재고 수량은 0 이상이어야 합니다.";

}
