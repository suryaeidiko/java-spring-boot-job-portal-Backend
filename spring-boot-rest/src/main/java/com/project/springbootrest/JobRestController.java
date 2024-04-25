package com.project.springbootrest;

import com.project.springbootrest.model.JobPost;
import com.project.springbootrest.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@CrossOrigin(origins = "http://localhost:5173")
@CrossOrigin(origins = "*")

public class JobRestController {

    @Autowired
    private JobService service;

    @GetMapping(path = "/jobPosts", produces = {"application/json"})
    public List<JobPost> getAllJobs() {
        return service.allJobs();
    }

    @GetMapping("/jobPost/{postId}")
    public JobPost getJob(@PathVariable("postId") int postId) {
        return service.getJob(postId);
    }

    @GetMapping("/jobPost/keyword/{keyword}")
    public List<JobPost> searchByKeyword(@PathVariable("keyword") String keyword) {
        return service.search(keyword);
    }

    @PostMapping("/jobPost")
    public JobPost addJob(@RequestBody JobPost jobPost) {
        service.addJob(jobPost);
        return service.getJob(jobPost.getPostId());
    }

    @PutMapping("/jobPost")
    public JobPost updateJob(@RequestBody JobPost jobpost) {
        service.updateJob(jobpost);
        return service.getJob(jobpost.getPostId());
    }

    @DeleteMapping("/jobPost/{postId}")
    public String deleteJob(@PathVariable int postId) {
        service.deleteJob(postId);
        return "Deleted...";
    }

    @GetMapping("/load")
    public String load() {
        service.load();
        return "Success...";
    }
}
