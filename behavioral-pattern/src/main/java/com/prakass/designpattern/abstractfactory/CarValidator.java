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

public class CarValidator extends MachineValidator {

    @Override
    public void validate(Machine machine) {
        System.out.println("Starting the car validator...");
        System.out.println("Waking up all robots...");
        System.out.println("Performing validator");
        System.out.println(String.format("The car %s validated successfully", machine.getModelName()));
        System.out.println("");
    }

}
