package org.botscrewtesttask;

import org.botscrewtesttask.model.Lector;
import org.botscrewtesttask.service.impl.DepartmentServiceImpl;
import org.botscrewtesttask.service.impl.LectorServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class BotsCrewTestTaskApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(BotsCrewTestTaskApplication.class, args);
    }
    private final Logger LOG = LoggerFactory
            .getLogger(BotsCrewTestTaskApplication.class);

    private final Scanner sc = new Scanner(System.in);
    private final DepartmentServiceImpl departmentService;
    private final LectorServiceImpl lectorService;
    @Autowired
    public BotsCrewTestTaskApplication(DepartmentServiceImpl departmentService, LectorServiceImpl lectorService) {
        this.departmentService = departmentService;
        this.lectorService = lectorService;
    }

    @Override
    public void run(String... args) {
        System.out.printf("%s%s%s\n", "#".repeat(10), "Type one of the command", "#".repeat(10));

        boolean flag = true;
        while (flag) {
            String[] input = sc.nextLine().split(" ");
            String argument = input[1].replace("_", " ");
            String answer = "";
            switch (input[0]) {
                case "DEPARTMENT_HEAD":
                    Lector lector = departmentService.findHead(argument);
                    answer = "Head of" + argument + "department is " + lector.getSurname() + " " + lector.getName();
                    break;
                case "AVG_SALARY":
                    answer = "The average salary of " + argument + " is " + departmentService.getAverageSalary(argument);
                    break;
                case "COUNT_EMPLOYEE":
                    answer = departmentService.countEmployee(argument).toString();
                    break;
                case "DEPARTMENT_STATISTICS":
                    //todo
                    answer = departmentService.getStatistics(argument).toString();
                    break;
                case "GLOBAL_SEARCH":
                    answer = lectorService.searchByTemplate(argument).toString(); break;
                case "EXIT": flag = false; break;
                default: break;

            }
            System.out.println(answer);
        }

    }

}
