package com.project.springbootrest.ropo;

import com.project.springbootrest.model.JobPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobRepo extends JpaRepository<JobPost,Integer> {
    List<JobPost> findByUsernameContainingOrExperienceContainingOrPostDescContaining(String username,String experience,String postDesc);

}


//List<JobPost> jobs = new ArrayList<>(Arrays.asList(
//        new JobPost(1,"ABC","Iam ABC","2",List.of("Reactjs")),
//        new JobPost(2,"XYZ","Iam xyz","5",List.of("HTML","CSS")),
//        new JobPost(3,"Surya","Iam surya","1.5",List.of("HTML","CSS","Java")),
//        new JobPost(4,"Praveen","Iam praveen","2",List.of("IIB"))
//));

//public List<JobPost> allJobs() {
//    return jobs;
//}
//
//public void addJob(JobPost job) {
//    jobs.add(job);
//    System.out.println(jobs);
//}
//
//public JobPost getJob(int postId) {
//    for (JobPost job : jobs) {
//        if (job.getPostId() == postId)
//            return job;
//    }
//    return null;
//}
//public void updateJob(JobPost jobpost) {
//    for (JobPost jobpost1 : jobs) {
//        if (jobpost1.getPostId() == jobpost.getPostId()) {
//            jobpost1.setUsername(jobpost.getUsername());
//            jobpost1.setPostDesc(jobpost.getPostDesc());
//            jobpost1.setExperience(jobpost.getExperience());
//            jobpost1.setPostTechStack(jobpost.getPostTechStack());
//        }
//    }
//}
//
//public void deleteJob(int postId) {
//    for (JobPost jobPost : jobs) {
//        if (jobPost.getPostId() == postId) {
//            jobs.remove(jobPost);
//        }
//    }
//}
