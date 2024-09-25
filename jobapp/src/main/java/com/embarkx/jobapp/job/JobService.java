package com.embarkx.jobapp.job;

import java.util.List;

public interface JobService {

    List<Job> findAll();
    void createJob(Job job);
    Job getJobById(long id);

    Boolean deleteJobById(long id);

    Job updateJobById(long id, Job job);
}
