package com.project.springbootrest.service;

import com.project.springbootrest.ropo.JobRepo;
import com.project.springbootrest.model.JobPost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class JobService {
    @Autowired
    private JobRepo repo;
    public void addJob(JobPost jobpost) {
        repo.save(jobpost);
    }

    public List<JobPost> allJobs() {
        return repo.findAll();
    }

    public JobPost getJob(int postId) {
        Optional<JobPost> j = repo.findById(postId);
        return j.orElse(new JobPost());
    }
    public List<JobPost> search(String keyword) {
        return repo.findByUsernameContainingOrExperienceContainingOrPostDescContaining(keyword,keyword,keyword);
    }

    public void updateJob(JobPost jobpost) {
        repo.save(jobpost);
    }

    public void deleteJob(int postId) {
        repo.deleteById(postId);
    }

    public void load() {

        List<JobPost> jobs = new ArrayList<>(List.of(
        new JobPost(1,"ABC","Iam ABC","2",List.of("Reactjs")),
        new JobPost(2,"XYZ","Iam xyz","5",List.of("HTML","CSS")),
        new JobPost(3,"Surya","Iam surya","1.5",List.of("HTML","CSS","Java")),
        new JobPost(4,"Praveen","Iam praveen","2",List.of("IIB"))
));
        repo.saveAll(jobs);

    }

}
