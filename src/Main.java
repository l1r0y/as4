import java.util.ArrayList;
import java.util.List;

interface JobSeeker {
    void update(String job);
}

interface JobPublisher {
    void registerJobSeeker(JobSeeker jobSeeker);
    void removeJobSeeker(JobSeeker jobSeeker);
    void notifyJobSeekers(String job);
}

class JobBoard implements JobPublisher {
    private List<JobSeeker> jobSeekers = new ArrayList<>();

    @Override
    public void registerJobSeeker(JobSeeker jobSeeker) {
        jobSeekers.add(jobSeeker);
    }

    @Override
    public void removeJobSeeker(JobSeeker jobSeeker) {
        jobSeekers.remove(jobSeeker);
    }

    @Override
    public void notifyJobSeekers(String job) {
        for (JobSeeker jobSeeker : jobSeekers) {
            jobSeeker.update(job);
        }
    }

    public void postJob(String job) {
        System.out.println("Job posted: " + job);
        notifyJobSeekers(job);
    }
}

class Worker implements JobSeeker {
    private String name;

    public Worker(String name) {
        this.name = name;
    }

    @Override
    public void update(String job) {
        System.out.println(name + ": New job available - " + job);
    }
}