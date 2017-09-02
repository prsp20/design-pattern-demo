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

package com.prakass.designpattern.facade;

public class Database {
    public void initializeSchema(boolean dropExistingSchema) {
        if (dropExistingSchema) {
            System.out.println("Existing database schema dropped!");
        }

        System.out.println("Database schema initialized");
    }

    public void initializeDefaultData() {
        System.out.println("Default data populated in the database!");
    }
}
