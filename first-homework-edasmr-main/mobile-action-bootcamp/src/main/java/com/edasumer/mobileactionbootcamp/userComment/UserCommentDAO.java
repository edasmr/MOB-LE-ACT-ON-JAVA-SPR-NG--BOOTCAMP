package com.edasumer.mobileactionbootcamp.userComment;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserCommentDAO extends JpaRepository<UserComment, Long> {
}