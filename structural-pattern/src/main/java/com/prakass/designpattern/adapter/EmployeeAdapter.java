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

/**
 * The adapter class
 *
 */
public class EmployeeAdapter implements Employee {
    private EmployeeFromLegacyDB employeeFromLegacyDB;

    public EmployeeAdapter(EmployeeFromLegacyDB employeeFromLegacyDB) {
        this.employeeFromLegacyDB = employeeFromLegacyDB;
    }

    @Override
    public String getId() {
        return employeeFromLegacyDB.getUid();
    }

    @Override
    public String getName() {
        return String.format("%s %s", employeeFromLegacyDB.getFirstName(),
                employeeFromLegacyDB.getLastName());
    }

    @Override
    public String getEmail() {
        return employeeFromLegacyDB.getEmailAddress();
    }

    @Override
    public double getSalary() {
        return employeeFromLegacyDB.getMonthlySalary();
    }
}
