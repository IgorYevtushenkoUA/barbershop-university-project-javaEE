package com.example.barbershop.controllers;

import com.example.barbershop.dtos.AccountDto;
import com.example.barbershop.dtos.CommentDto;
import com.example.barbershop.dtos.CommentForm;
import com.example.barbershop.entity.CommentEntity;
import com.example.barbershop.exceptions.UnauthorizedException;
import com.example.barbershop.service.AccountService;
import com.example.barbershop.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.Instant;
import java.util.List;

@RequiredArgsConstructor
@RestController
public class CommentController {
    private final AccountService accountService;
    private final CommentService commentService;

    @RequestMapping("/comments")
    CommentDto getRecordComment(@RequestParam Integer recordId) {
        return commentService.findCommentById(recordId, CommentDto.class);
    }

    @RequestMapping("/comments/master")
    List<CommentDto> getMasterComment(@RequestParam Integer masterId) {
        return commentService.findAllCommentsByMaster(masterId, CommentDto.class);
    }

    @RequestMapping(value = "/comments", method = RequestMethod.POST)
    void addComment(@RequestParam Integer recordId, @RequestBody @Valid CommentForm comment) {
        var user = SecurityContextHolder.getContext().getAuthentication().getName();
        var account = accountService.findByEmail(user, AccountDto.class);
        if (account == null)
            throw new UnauthorizedException();
        var entity = new CommentEntity();
        entity.setRecordId(recordId);
        entity.setRating(comment.getRating());
        entity.setUserComment(comment.getUserComment());
        entity.setCommentTime(Instant.now());
        commentService.addNewComment(entity, account.getAccountId());
    }
}
