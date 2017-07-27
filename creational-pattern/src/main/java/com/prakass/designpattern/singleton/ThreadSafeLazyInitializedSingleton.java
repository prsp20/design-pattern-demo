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

package com.prakass.designpattern.singleton;

/**
 * Demo of singleton pattern with lazy initialization. Thread safe.
 * 
 * @author Prakash Sapkota
 *
 */
public class ThreadSafeLazyInitializedSingleton {
    private static volatile ThreadSafeLazyInitializedSingleton instance = null;

    private ThreadSafeLazyInitializedSingleton() {
    }

    public static ThreadSafeLazyInitializedSingleton getInstance() {
        if (instance == null) {
            synchronized (ThreadSafeLazyInitializedSingleton.class) {
                if (instance == null) {
                    instance = new ThreadSafeLazyInitializedSingleton();
                }
            }
        }
        return instance;
    }
}
