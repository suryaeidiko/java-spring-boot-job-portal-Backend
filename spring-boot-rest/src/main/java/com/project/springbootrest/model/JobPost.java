package com.project.springbootrest.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.stereotype.Component;

import java.util.List;

@NoArgsConstructor
@Component
@AllArgsConstructor
@Data
@ToString
@Entity
public class JobPost {
    @Id
    private int postId;
    private String username;
    private String postDesc;
    private String experience;
    private List<String>postTechStack;

}
