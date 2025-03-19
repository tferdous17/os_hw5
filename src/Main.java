import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // Initialize processes with burst times
        Process[] processes = {
                new Process("P1", 2),
                new Process("P2", 1),
                new Process("P3", 8),
                new Process("P4", 4),
                new Process("P5", 5)
        };

        // FCFS Scheduling
        System.out.println("----------------------FCFS Scheduling----------------------");
        calculateFCFS(processes.clone());

        // SJF Scheduling
        System.out.println("\n----------------------SJF Scheduling----------------------");
        calculateSJF(processes.clone());
    }

    // FCFS Scheduling
    public static void calculateFCFS(Process[] processes) {
        int currentTime = 0;
        double totalTurnaroundTime = 0;
        double totalWaitingTime = 0;

        // Calculate completion, turnaround, and waiting times
        for (Process p : processes) {
            currentTime += p.burstTime;
            p.completionTime = currentTime;
            p.turnaroundTime = p.completionTime;
            p.waitingTime = p.turnaroundTime - p.burstTime;

            totalTurnaroundTime += p.turnaroundTime;
            totalWaitingTime += p.waitingTime;
        }

        // Print results
        printResults(processes, totalTurnaroundTime, totalWaitingTime);
    }

    // SJF Scheduling
    public static void calculateSJF(Process[] processes) {
        // Sort processes by burst time (shortest first)
        Arrays.sort(processes, (a, b) -> Integer.compare(a.burstTime, b.burstTime));

        int currentTime = 0;
        double totalTurnaroundTime = 0;
        double totalWaitingTime = 0;

        // Calculate completion, turnaround, and waiting times
        for (Process p : processes) {
            currentTime += p.burstTime;
            p.completionTime = currentTime;
            p.turnaroundTime = p.completionTime; // Arrival time = 0
            p.waitingTime = p.turnaroundTime - p.burstTime;

            totalTurnaroundTime += p.turnaroundTime;
            totalWaitingTime += p.waitingTime;
        }

        // Print results
        printResults(processes, totalTurnaroundTime, totalWaitingTime);
    }

    public static void printResults(Process[] processes, double totalTurnaroundTime, double totalWaitingTime) {
        System.out.println("Process\tBurst Time\tCompletion Time\tTurnaround Time\tWaiting Time");
        for (Process p : processes) {
            System.out.printf("%s\t%d\t\t%d\t\t%d\t\t%d%n",
                    p.name, p.burstTime, p.completionTime, p.turnaroundTime, p.waitingTime);
        }
        double avgTurnaroundTime = totalTurnaroundTime / processes.length;
        double avgWaitingTime = totalWaitingTime / processes.length;
        System.out.printf("AVERAGE TURNAROUND TIME: %.2f ms%n", avgTurnaroundTime);
        System.out.printf("AVERAGE WAITING TIME: %.2f ms%n", avgWaitingTime);
    }
}
