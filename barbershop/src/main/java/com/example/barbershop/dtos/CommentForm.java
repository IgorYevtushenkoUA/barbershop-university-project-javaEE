package com.example.barbershop.dtos;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class CommentForm {
    @NotEmpty
    private String userComment;
    @NotNull
    private Integer rating;
}
