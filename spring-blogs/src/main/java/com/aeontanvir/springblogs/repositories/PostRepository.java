package com.aeontanvir.springblogs.repositories;

import com.aeontanvir.springblogs.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
}
