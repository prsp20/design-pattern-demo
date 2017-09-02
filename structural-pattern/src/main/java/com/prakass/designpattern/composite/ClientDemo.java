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

package com.prakass.designpattern.composite;

public class ClientDemo {
    public static void main(String[] args) {
        // Two Engineers
        Employee engineer1 = new Engineer("Engineer 1", "Sr. Software Engineer");
        Employee engineer2 = new Engineer("Engineer 2", "Software Engineer Trainee");
        Employee engineer3 = new Engineer("Engineer 3", "Software Engineer");

        // Engineering manager
        Manager engineeringManager = new EngineeringManager("Boss", "Engineering Manager");

        // General manager
        Manager generalManager = new GeneralManager("Bigger Boss", "General Manager");

        // Engineers work under engineering manager
        engineeringManager.addSubordinateEmployee(engineer1);
        engineeringManager.addSubordinateEmployee(engineer2);
        engineeringManager.addSubordinateEmployee(engineer3);

        // Engineering manager works under general manager
        generalManager.addSubordinateEmployee(engineeringManager);

        // There we go. We have the structure. Let's browse the structure.
        // First, general manager
        generalManager.printBusinessCard();

        // Browse subordinates of the general managers
        System.out.println("Subordinates of the general manager:");
        for (Employee e : generalManager.getSubordinateEmployees()) {
            e.printBusinessCard();

            if (e instanceof Manager) {
                // Then employees under managers
                System.out.println(String.format("Subordinates of %s:", e.getName()));
                Manager manager = (Manager) e;
                for (Employee e1 : manager.getSubordinateEmployees()) {
                    e1.printBusinessCard();
                }
            }
        }
    }
}
