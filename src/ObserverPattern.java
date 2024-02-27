public class ObserverPattern {
    public static void main(String[] args) {
        JobBoard jobBoard = new JobBoard();

        JobSeeker worker1 = new Worker("Alikhan");
        JobSeeker worker2 = new Worker("Alisher");

        jobBoard.registerJobSeeker(worker1);
        jobBoard.registerJobSeeker(worker2);

        jobBoard.postJob("Software Engineer");

        jobBoard.removeJobSeeker(worker2);

        jobBoard.postJob("IT Manager");
    }
}