package com.example.JobSpringRestApplication.controller;

import com.example.JobSpringRestApplication.model.JobPost;
import com.example.JobSpringRestApplication.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000/")
public class JobController {

    @Autowired
    private JobService jobService;

    @GetMapping("jobs")
    public List<JobPost> home() {
        System.out.println("Get all job request");
        return jobService.returnAllJobPosts();
    }

//    @GetMapping("addjob")
//    public String addJob() {
//        return "addjob";
//    }
//
//    @PostMapping("handleForm")
//    public String handleForm(JobPost jobPost) {
//        System.out.println("jobPost" + jobPost);
//        jobService.addJobRequest(jobPost);
//        return "success";
//    }
//
//    @GetMapping("viewalljobs")
//    public String viewJobs(Model model) {
//        List<JobPost> jobPosts = jobService.returnAllJobPosts();
//        model.addAttribute("jobPosts", jobPosts);
//        return "viewalljobs";
//    }
}
