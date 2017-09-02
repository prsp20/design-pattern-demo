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

package com.prakass.designpattern.abstractfactory;

public class ClientDemo {
    public static void main(String[] args) {
        MachineFactory factory1 = MachineFactory.getInstance(MachineType.CAR);
        Machine machine1 = factory1.getMachine();
        machine1.setModelName("Tesla Model 3");

        MachineValidator validator1 = factory1.getValidator();

        System.out.println(String.format("Machine %s built!", machine1.getModelName()));
        validator1.validate(machine1);
        System.out.println(String.format("Machine %s is ready for use!", machine1.getModelName()));

        machine1.operate();
        machine1.stop();

        System.out.println("\n\n");

        MachineFactory factory2 = MachineFactory.getInstance(MachineType.ROCKET);
        Machine machine2 = factory2.getMachine();
        machine2.setModelName("PRSP-20 Dragon");

        MachineValidator validator2 = factory2.getValidator();

        System.out.println(String.format("Machine %s built!", machine2.getModelName()));
        validator2.validate(machine2);
        System.out.println(String.format("Machine %s is ready for use!", machine2.getModelName()));

        machine2.operate();
        machine2.stop();

    }
}
