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

package com.prakass.designpattern.proxy;

/**
 * This is the proxy class. It delegates the functionality to the {@code Implementation}. In
 * addition to delegating the real functionality to the real implementation, it may add additional
 * functionality.
 * 
 */
public class ImplementationProxy implements Specification {
    private Implementation realImplementation;
    private String role;

    public ImplementationProxy(String role) {
        if (realImplementation == null) {
            realImplementation = new Implementation();
        }

        this.role = role;
    }

    ImplementationProxy(String role, Implementation realImplementation) {
        this.realImplementation = realImplementation;
        this.role = role;
    }

    public void doSomething() {
        // Some additional functionality
        // Eg. checking access rights
        if (!"ADMIN".equals(role)) {
            throw new RuntimeException("User does not have sufficient access rights!");
        }

        // Delegating the functionality to real implementation
        realImplementation.doSomething();

    }

}
