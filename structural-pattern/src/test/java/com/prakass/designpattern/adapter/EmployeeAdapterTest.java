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

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class EmployeeAdapterTest {

    @Test
    public void shouldConvertToNewEmployee() {
        EmployeeFromLegacyDB legacyEmployee = new EmployeeFromLegacyDB();
        legacyEmployee.setUid("2234343ak22343dkkd");
        legacyEmployee.setFirstName("fName2");
        legacyEmployee.setLastName("lName2");
        legacyEmployee.setEmailAddress("fName2.lName2@example.com");
        legacyEmployee.setMonthlySalary(10002);

        Employee employee = new EmployeeAdapter(legacyEmployee);
        assertThat(employee.getId(), is("2234343ak22343dkkd"));
        assertThat(employee.getName(), is("fName2 lName2"));
        assertThat(employee.getEmail(), is("fName2.lName2@example.com"));
        assertThat(employee.getSalary(), is(10002.0));
    }
}
