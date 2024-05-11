package com.example.JobSpringRestApplication.service;

import com.example.JobSpringRestApplication.model.JobPost;

import java.util.List;


public interface IJobService {
    List<JobPost> returnAllJobPosts();
    void addJobRequest(JobPost jobPost);
    JobPost getJob(int jobId);
    void updateJobPost(JobPost jobPost);
    void deleteJobPost(int jobId);
    void loadJobData();
    List<JobPost> search(String keyword);
}
