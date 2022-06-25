package com.edasumer.mobileactionbootcamp.userComment;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/comment")
@AllArgsConstructor
public class CommentController {

    private UserCommentDAO userCommentDAO;


    //bütün yorumları getirme
    @GetMapping
    public ResponseEntity<List<UserComment>> findAllComments(){
        List<UserComment> userComments = userCommentDAO.findAll();

        return new ResponseEntity<>(userComments, HttpStatus.ACCEPTED);
    }

    // yorumları kaydetme
    @PostMapping
    public ResponseEntity<UserComment> saveComment(@RequestBody UserComment userComment){
        userComment = userCommentDAO.save(userComment);
        return new ResponseEntity<>(userComment, HttpStatus.ACCEPTED);
    }

    // id ye göre yorum silme
    @DeleteMapping("/{id}")
    public ResponseEntity<UserComment> deleteComment(@RequestParam long id){

        UserComment userComment = userCommentDAO.findById(id).orElseThrow();

        userCommentDAO.delete(userComment);

        return new ResponseEntity<>(null, HttpStatus.ACCEPTED);
    }

    // sadece yoruma göre değiştirme yapma diğer türlü throw
    @PatchMapping("/update/{id}/{newComment}")
    public ResponseEntity<UserComment> updateComment(@RequestParam long id, String newComment){
        UserComment userComment =  userCommentDAO.findById(id).orElseThrow();
        userComment.setComment(newComment);
        userCommentDAO.save(userComment);

        return new ResponseEntity<>(userComment, HttpStatus.ACCEPTED);
    }
}