package org.botscrewtesttask;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class BotsCrewTestTaskApplication implements CommandLineRunner {

    private static final Logger LOG = LoggerFactory
            .getLogger(BotsCrewTestTaskApplication.class);

    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        SpringApplication.run(BotsCrewTestTaskApplication.class, args);
    }

    @Override
    public void run(String... args) {

    }
}
