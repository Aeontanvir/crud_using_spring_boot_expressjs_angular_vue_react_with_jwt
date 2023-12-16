package com.aeontanvir.springblogs.initdata;

import com.aeontanvir.springblogs.models.Comment;
import com.aeontanvir.springblogs.models.Post;
import com.aeontanvir.springblogs.repositories.PostRepository;
import com.aeontanvir.springblogs.services.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

@RequiredArgsConstructor
@Service
public class BootDataImporter implements CommandLineRunner {

    private final PostRepository postRepository;
    @Override
    public void run(String... args) throws Exception {
        List<Post> posts = IntStream.rangeClosed(1, 10)
                .mapToObj(num-> new Post(num+"Title", num+"Details"))
//                .map(post->{
//                    post.setComments(
//                            IntStream.rangeClosed(1, 10)
//                                    .mapToObj(num-> new Comment(num+"Comment", post ))
//                                    .toList()
//                    );
//                    return post;
//
//                })
                .toList();
        postRepository.saveAll(posts);

    }

}
