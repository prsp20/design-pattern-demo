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

package com.prakass.designpattern.adapter;

public class ClientDemo {
    public static void main(String[] args) {
        Payroll payroll = new Payroll();

        // The following two employees can be normally processed by payroll
        Employee employee =
                new EmployeeFromDB("1", "fName lName", "fName.lName@example.com", 10000);
        Employee employee1 =
                new EmployeeFromDB("2", "fName1 lName1", "fName1.lName1@example.com", 10001);
        payroll.addEmployeeToPayroll(employee);
        payroll.addEmployeeToPayroll(employee1);

        // The following employee, however, cannot be processed. That's where we need the adapter
        EmployeeFromLegacyDB legacyEmployee = new EmployeeFromLegacyDB();
        legacyEmployee.setUid("2234343ak22343dkkd");
        legacyEmployee.setFirstName("fName2");
        legacyEmployee.setLastName("lName2");
        legacyEmployee.setEmailAddress("fName2.lName2@example.com");
        legacyEmployee.setMonthlySalary(10002);

        Employee employeeAdapter = new EmployeeAdapter(legacyEmployee);
        payroll.addEmployeeToPayroll(employeeAdapter);

        // Now we're ready to process the payroll of employees from both sources
        payroll.processPayRoll();
    }
}
