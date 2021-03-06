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

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class ManagerTest {
    @Test
    public void shouldAddSubordinates() {
        Manager manager = new GeneralManager("Name", "Title");
        manager.addSubordinateEmployee(new Engineer("", "Title 1"));
        manager.addSubordinateEmployee(new Engineer("", ""));
        manager.addSubordinateEmployee(new Engineer("A", "B"));

        assertThat(manager.getSubordinateEmployees().size(), is(3));
        assertThat(manager.getSubordinateEmployees().get(2).getName(), is("A"));
        assertThat(manager.getSubordinateEmployees().get(0).getTitle(), is("Title 1"));
    }
}
