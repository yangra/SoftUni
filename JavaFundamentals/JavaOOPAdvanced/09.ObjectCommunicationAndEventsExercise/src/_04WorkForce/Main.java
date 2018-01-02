package _04WorkForce;

import _04WorkForce.interfaces.*;
import _04WorkForce.models.Job;
import _04WorkForce.models.ObserverImpl;
import _04WorkForce.models.employees.PartTimeEmployee;
import _04WorkForce.models.employees.StandardEmployee;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Employee> employees = new LinkedHashMap<>();
        Map<String, ObservableAction> jobs = new LinkedHashMap<>();
        ObservationInfo observer = ObserverImpl.instance();

        while (true) {
            String[] command = reader.readLine().split("\\s+");
            if ("End".equals(command[0])) {
                break;
            }

            switch (command[0]) {
                case "StandartEmployee":
                    Employee employee1 = new StandardEmployee(command[1]);
                    employees.put(command[1], employee1);
                    break;
                case "PartTimeEmployee":
                    Employee employee2 = new PartTimeEmployee(command[1]);
                    employees.put(command[1], employee2);
                    break;
                case "Job":
                    ObservableAction job = new Job(command[1], Integer.parseInt(command[2]), employees.get(command[3]));
                    jobs.put(command[1], job);
                    break;
                case "Pass":
                    for (ObservableAction action : jobs.values()) {
                        action.update();
                    }
                    if(observer.getFinished().size()>0){
                        for (ObservableAction action : observer.getFinished()) {
                            System.out.printf("Job %s done!\n", action.getName());
                            jobs.remove(action.getName());
                        }
                        observer.emptyNotifications();
                    }
                    break;
                case "Status":
                    for (ObservableAction action : jobs.values()) {
                        System.out.printf("Job: %s Hours Remaining: %d\n", action.getName(), action.getWorkHoursRequired());
                    }
                    break;

            }
        }
    }
}
