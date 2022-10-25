package com.demo.fe.model;


import lombok.*;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;
@ToString
@Setter
@Getter
public class Board {

    private Long seq;

    @NotEmpty
    @Length(max = 200, message = "제목은 최소 0자,최대 200자 작성해주세요.")
    private String subject;

    @NotEmpty
    @Length(max = 2000, message = "내용은 최대 2000자 작성해주세요.")
    private String content;
    private Integer hits;

    @NotEmpty
    @Length(max = 100, message = "작성자를 입력해주세요.")
    private String createdId;

    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime createdDate;

    @Length(max = 100)
    private String modifiedId;

    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime modifiedDate;
}
