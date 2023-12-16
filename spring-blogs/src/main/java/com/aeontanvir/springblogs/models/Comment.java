package com.aeontanvir.springblogs.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Comment  extends BaseModel{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String comment;
    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;

    public Comment(String comment, Post post) {
        this.comment = comment;
        this.post = post;
    }
    public Comment(String comment) {
        this.comment = comment;
    }
}
