package com.example.JobSpringRestApplication.service;

import com.example.JobSpringRestApplication.model.JobPost;
import com.example.JobSpringRestApplication.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobService {

    @Autowired
    private JobRepository jobRepository;

    public List<JobPost> returnAllJobPosts() {
        return jobRepository.returnAllJobPosts();
    }

    public void addJobRequest(JobPost jobPost) {
        jobRepository.addJobPost(jobPost);
    }
}
