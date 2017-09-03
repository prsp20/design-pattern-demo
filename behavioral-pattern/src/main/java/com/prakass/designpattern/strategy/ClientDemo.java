/*
 * Copyright 2017 the original author.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.prakass.designpattern.strategy;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * As I got lazy to write a complete code sample for the strategy pattern, I decided to reuse one of
 * the most commonly used strategy pattern from Java standard library.
 *
 */
public class ClientDemo {
    public static void main(String[] args) {
        // Build list of employees
        Employee e1 = new Employee("Z B", "");
        Employee e2 = new Employee("z n", "");
        Employee e3 = new Employee("C d", "");
        Employee e4 = new Employee("F G", "");

        List<Employee> employees = Arrays.asList(new Employee[] {e1, e2, e3, e4});

        // Here the Collections#sort() method takes the strategy/algorithm to sort the employees at
        // runtime
        // So, this is considered as strategy pattern
        Collections.sort(employees, new Comparator<Employee>() {
            public int compare(Employee employee1, Employee employee2) {
                // Sort only by name
                return employee1.getName().compareTo(employee2.getName());
            };
        });

        // Employees sorted. Let's print them, just for fun ;)
        for (Employee e : employees) {
            System.out.println(e.getName());
        }
    }
}
