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

package com.prakass.designpattern.bridge;

public class RemoteMachineControlPanelBasicImpl extends RemoteMachineControlPanel {

    public RemoteMachineControlPanelBasicImpl(RemoteMachineController remoteMachineController) {
        super(remoteMachineController);
    }

    @Override
    public void displayManu() {
        System.out.println("Press the 'Start' button, and enter machine ID to start the machine.");
        System.out.println("Press the 'Stop' button, and enter machine ID to stop the machine.");
    }

    @Override
    public void startMachine(String machineId) {
        remoteMachineController.start(machineId);
    }

    @Override
    public void stopMachine(String machineId) {
        remoteMachineController.stop(machineId);
    }
}
