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

import java.util.Arrays;
import java.util.List;

/**
 * This class works as the facade class
 *
 */
public class MyApplication {
    private Logger logger;
    private Database databaseResource;
    private List<Filter> filters;
    private List<Listener> listeners;

    public MyApplication() {
        this.logger = Logger.getInstance();;
        this.databaseResource = new Database();;
        this.filters = Arrays.asList(new Filter[] {new Filter()});;
        this.listeners = Arrays.asList(new Listener[] {new Listener()});;
    }

    public void initializeApplication(int port) {
        // Initialize logger. Just as an example.
        logger.initialize();

        // Configure all application listeners
        for (Listener listener : listeners) {
            listener.configure();
        }

        // Initialize database schema and populate default data
        databaseResource.initializeSchema(true);
        databaseResource.initializeDefaultData();

        // Register all filters
        for (Filter filter : filters) {
            filter.register();
        }
        System.out.println("Filter chain registered for the application");

        System.out.println(String.format(
                "My application initialized successfully. Listening on port %s...", port));
    }
}
