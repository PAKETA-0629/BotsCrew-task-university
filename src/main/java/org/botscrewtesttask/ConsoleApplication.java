package org.botscrewtesttask;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import java.util.Scanner;

public class ConsoleApplication implements CommandLineRunner {

    private static final Logger LOG = LoggerFactory
            .getLogger(BotsCrewTestTaskApplication.class);

    private static final Scanner sc = new Scanner(System.in);

    @Override
    public void run(String... args) {
        System.out.println("working...");
    }
}
