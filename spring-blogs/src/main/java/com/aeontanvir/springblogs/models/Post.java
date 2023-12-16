package com.aeontanvir.springblogs.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Post extends BaseModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String details;
    @OneToMany(mappedBy = "post", cascade = CascadeType.PERSIST)
    private List<Comment> comments;

    public Post(String title, String details) {
        this.title = title;
        this.details = details;
    }

    public Post(String title, String details, List<Comment> comments) {
        this.title = title;
        this.details = details;
        this.comments = comments;
    }
}
