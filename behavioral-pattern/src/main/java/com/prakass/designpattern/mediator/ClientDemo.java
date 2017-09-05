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

public class ClientDemo {
    public static void main(String[] args) {
        Message messageA = new Message("Message A");
        Message messageB = new Message("Message B");

        MediatorImpl mediator = new MediatorImpl();

        Colleague colleagueA = new ConcreteColleagueA(mediator);
        Colleague colleagueB = new ConcreteColleagueB(mediator);

        mediator.registerColleague(colleagueA);
        mediator.registerColleague(colleagueB);

        colleagueA.sendMessage(messageA);
        colleagueB.sendMessage(messageB);
    }
}
