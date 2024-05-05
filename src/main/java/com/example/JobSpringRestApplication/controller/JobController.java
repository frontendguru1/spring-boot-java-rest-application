package com.example.JobSpringRestApplication.controller;

import com.example.JobSpringRestApplication.model.JobPost;
import com.example.JobSpringRestApplication.service.IJobService;
import com.example.JobSpringRestApplication.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000/")
public class JobController {

    @Autowired
    private IJobService jobService;

    @GetMapping("jobs")
    public List<JobPost> home() {
        System.out.println("Get all job request");
        return jobService.returnAllJobPosts();
    }

    @GetMapping("job/{jobId}")
    public JobPost getJob(@PathVariable int jobId) {
        return jobService.getJob(jobId);
    }

    @PostMapping("job")
    public JobPost addJob(@RequestBody JobPost jobPost) {
        jobService.addJobRequest(jobPost);
        return jobService.getJob(jobPost.getPostId());
    }

    @PutMapping("job")
    public JobPost updateJob(@RequestBody JobPost jobPost) {
        jobService.updateJobPost(jobPost);
        return jobService.getJob(jobPost.getPostId());
    }

    @DeleteMapping("job/{jobId}")
    public String deleteJob(@PathVariable int jobId) {
        jobService.deleteJobPost(jobId);
        return "Deleted";
    }
}
