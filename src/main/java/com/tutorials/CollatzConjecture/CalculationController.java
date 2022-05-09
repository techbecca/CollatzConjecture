package com.tutorials.CollatzConjecture;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class CalculationController {
//    private static final String template = "For the number %d, it takes %d steps of the Collatz Conjecture to reach 1";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/calculate")
    public String calculate(@RequestParam(value="number", defaultValue = "3") long num) {
        long result = calculateCollatzConjecture(num);
        final Calculation calculation = new Calculation(counter.incrementAndGet(), num, result);
        return calculation.toString();
    }

    private long calculateCollatzConjecture(long num) {
        // Check number is above 1
        if ( num <= 1) {
            return -1;
        }

        // Count the number of steps
        long count = 0;
        while (num > 1) {
            if (num % 2 == 0) {
                // If n is even, divide n by 2
                num /= 2;
            } else {
                // If n is odd, multiply it by 3 and add 1.
                num = num * 3 + 1;
            }
            count++;
        }
        return count;
    }


}
