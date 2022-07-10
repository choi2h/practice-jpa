package jpabook.jpashop.domain;

import lombok.Getter;

import javax.persistence.Embeddable;

/*
값타입은 불변클래스로 만들어야 한다.
기본클래스가 필요한 이유?
JPA구현 라이브러리가 객체 생성 시 리플렉션 드으이 기술을 사용할 수 있도록 지원해놔야 하기때문
 */

@Embeddable //내장타입을 쓸 떄는 @Embeddable @Embedded 둘 중 하나만 있어도 된다.
@Getter
public class Address {

    private String city;
    private String street;
    private String zipcode;

    protected Address() {
    }

    public Address(String city, String street, String zipcode) {
        this.city = city;
        this.street = street;
        this.zipcode = zipcode;
    }
}
