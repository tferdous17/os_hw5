public class Process {
    String name;
    int burstTime;
    int completionTime;
    int turnaroundTime;
    int waitingTime;

    public Process(String name, int burstTime) {
        this.name = name;
        this.burstTime = burstTime;
    }

    public Process(String name, int burstTime, int completionTime, int turnaroundTime, int waitingTime) {
        this.name = name;
        this.burstTime = burstTime;
        this.completionTime = completionTime;
        this.turnaroundTime = turnaroundTime;
        this.waitingTime = waitingTime;
    }
}