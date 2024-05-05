package com.example.JobSpringRestApplication.service;

import com.example.JobSpringRestApplication.model.JobPost;
import com.example.JobSpringRestApplication.repository.IJobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobService implements IJobService {

    @Autowired
    private IJobRepository jobRepository;

    public List<JobPost> returnAllJobPosts() {
        return jobRepository.returnAllJobPosts();
    }

    public void addJobRequest(JobPost jobPost) {
        jobRepository.addJobPost(jobPost);
    }

    public JobPost getJob(int jobId) {
        return jobRepository.getJob(jobId);
    }

    public void updateJobPost(JobPost jobPost) {
        jobRepository.updateJobPost(jobPost);
    }

    public void deleteJobPost(int jobId) {
        jobRepository.deleteJobPost(jobId);
    }

}
