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

public class ClientDemo {

    public static void main(String[] args) {
        // The class MyApplication works as the facade. It hides complexity of
        // initializing application (eg. initializing logger, initializing
        // database, registering different kinds of filters for application,
        // configuring listeners for the application and so on. By hiding the
        // complexity, it provides a simple interface for the client to
        // initialize the application.
        MyApplication sampleApplication = new MyApplication();
        sampleApplication.initializeApplication(8080);
    }
}
