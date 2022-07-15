package jpabook.jpashop.controller;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter @Setter
public class BookForm {

    private Long id;

    @NotEmpty(message = "상품명을 입려해주세요.")
    private String name;
    @NotEmpty(message = "가격을 입력해주세요.")
    private int price;
    @NotEmpty(message = "상품의 수를 입력해 주세요.")
    private int stockQuantity;

    private String author;
    private String isbn;
}
