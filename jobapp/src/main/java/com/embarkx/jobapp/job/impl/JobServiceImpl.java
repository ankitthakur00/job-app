package com.embarkx.jobapp.job.impl;

import com.embarkx.jobapp.job.Job;
import com.embarkx.jobapp.job.JobService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JobServiceImpl implements JobService {
    private long jobId = 1L;

    private final List<Job> jobs = new ArrayList<>();

    @Override
    public List<Job> findAll() {
        return jobs;
    }

    @Override
    public void createJob(Job job) {
        job.setId(this.jobId);
        jobs.add(job);
        jobId++;
    }

    @Override
    public Job getJobById(long id) {
        for (Job job : jobs)
            if (job.getId().equals(id)) return job;
        return null;
    }

    @Override
    public Boolean deleteJobById(long id) {
        for (Job job : jobs) {
            if (job.getId().equals(id)){
                jobs.remove(job);
                return true;
            }
        }
        return false;
    }

    @Override
    public Job updateJobById(long id, Job job) {
        for (Job jb : jobs) {
            if (jb.getId() == id) {
                if (job.getDescription() != null) jb.setDescription(job.getDescription());
                if (job.getLocation() != null) jb.setLocation(job.getLocation());
                if (job.getTitle() != null) jb.setTitle(job.getTitle());
                if (job.getMinSalary() != null) jb.setMinSalary(job.getMinSalary());
                if (job.getMaxSalary() != null) jb.setMaxSalary(job.getMaxSalary());
                return jb;
            }
        }
        return null;
    }

}
