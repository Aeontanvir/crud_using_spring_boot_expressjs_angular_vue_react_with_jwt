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
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@RequiredArgsConstructor
@Service
public class BootDataImporter implements CommandLineRunner {

    private final PostRepository postRepository;
    @Override
    public void run(String... args) throws Exception {
        List<String> wordList = Arrays.asList("apple", "banana", "orange", "grape", "kiwi", "melon", "peach", "pear");
        List<Post> posts = IntStream.rangeClosed(1, 10)
                .mapToObj(num -> new Post(num + generateRandomWordString(wordList, 5), num + generateRandomWordString(wordList, 40)))
                .map(post -> {
                    post.setComments(
                            IntStream.rangeClosed(1, 10)
                                    .mapToObj(num -> new Comment(num + generateRandomWordString(wordList, 10), post))
                                    .collect(Collectors.toList())
                    );
                    return post;
                })
                .collect(Collectors.toList());

        postRepository.saveAll(posts);

    }

    private static String generateRandomWordString(List<String> wordList, int numberOfWords) {
        Random random = new Random();

        return random.ints(numberOfWords, 0, wordList.size())
                .mapToObj(wordList::get)
                .collect(Collectors.joining(" "));
    }

}
