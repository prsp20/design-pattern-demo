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

package com.prakass.designpattern.mediator;

import java.util.HashSet;
import java.util.Set;

/**
 * This class works as concrete mediator. It knows the implementation of each concrete colleague,
 * and it mediates the communication between those two colleagues.
 * 
 */
public class MediatorImpl implements Mediator {
    Set<Colleague> colleagues = new HashSet<>();

    public void registerColleague(Colleague colleague) {
        colleagues.add(colleague);
    }

    // This is implemented in such a way that it will send message to all colleagues other than
    // itself
    @Override
    public void sendMessage(Message message, Colleague from) {
        for (Colleague c : colleagues) {
            if (c != from) {
                c.receiveMessage(message);
            }
        }
    }
}
