package com.embarkx.jobapp.job.impl;

import com.embarkx.jobapp.job.Job;
import com.embarkx.jobapp.job.JobRepository;
import com.embarkx.jobapp.job.JobService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class JobServiceImpl implements JobService {
//    private long jobId = 1L;

//    private final List<Job> jobs = new ArrayList<>();
    JobRepository jobRepository;

    public JobServiceImpl(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    @Override
    public List<Job> findAll() {
        return jobRepository.findAll();
    }

    @Override
    public void createJob(Job job) {
        jobRepository.save(job);
    }

    @Override
    public Job getJobById(long id) {
        return jobRepository.findById(id).orElse(null);
    }

    @Override
    public Boolean deleteJobById(long id) {
        try{
            jobRepository.deleteById(id);
            return true;
        }
        catch (Exception ex){
            return false;
        }
    }

    @Override
    public Job updateJobById(long id, Job job) {
        Optional<Job> jobOptional = jobRepository.findById(id);

        if (jobOptional.isPresent()) {
            Job jb = jobOptional.get();
            if (job.getDescription() != null) jb.setDescription(job.getDescription());
            if (job.getLocation() != null) jb.setLocation(job.getLocation());
            if (job.getTitle() != null) jb.setTitle(job.getTitle());
            if (job.getMinSalary() != null) jb.setMinSalary(job.getMinSalary());
            if (job.getMaxSalary() != null) jb.setMaxSalary(job.getMaxSalary());
            return jb;
        }
        return null;
    }

}
