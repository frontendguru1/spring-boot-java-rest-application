package com.example.JobSpringRestApplication.repository;

import com.example.JobSpringRestApplication.model.JobPost;

import java.util.List;

public interface IJobRepository {
    public List<JobPost> returnAllJobPosts();
    public void addJobPost(JobPost job);
    public JobPost getJob(int jobId);
    public void updateJobPost(JobPost jobPost);
    public void deleteJobPost(int jobId);
}
