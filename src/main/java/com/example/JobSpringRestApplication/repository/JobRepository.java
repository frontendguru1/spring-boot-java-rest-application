package com.example.JobSpringRestApplication.repository;

import com.example.JobSpringRestApplication.exception.NoJobFoundException;
import com.example.JobSpringRestApplication.model.JobPost;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class JobRepository implements IJobRepository {
    // arrayList to store JobPost objects
    List<JobPost> jobs = new ArrayList<>();

    // constructor->injecting objects into ArrayList defined above.
    public JobRepository() {

    }

    // method to return all JobPosts
    public List<JobPost> returnAllJobPosts() {
        return jobs;
    }

    // method to save a job post object into arrayList
    public void addJobPost(JobPost job) {
        jobs.add(job);
    }


    //method to get a job by jobId
    public JobPost getJob(int jobId) {
//        for(JobPost job: jobs) {
//            if(job.getPostId() == jobId) {
//                return job;
//            }
//        }
        return jobs.stream().filter(jobPost -> jobPost.getPostId() == jobId)
                .findFirst()
                .orElseThrow(() -> new NoJobFoundException("No Job found with JobId " + jobId));
    }

    public void updateJobPost(JobPost jobPost) {
        for (JobPost jobPost1 : jobs) {
            if (jobPost1.getPostId() == jobPost.getPostId()) {
                jobPost1.setPostProfile(jobPost.getPostProfile());
                jobPost1.setPostDesc(jobPost.getPostDesc());
                jobPost1.setReqExperience(jobPost.getReqExperience());
                jobPost1.setPostTechStack(jobPost.getPostTechStack());
            }
        }
    }

    public void deleteJobPost(int jobId) {
        for (JobPost jobPost : jobs) {
            if (jobPost.getPostId() == jobId) {
                jobs.remove(jobPost);
            }
        }
    }

}
