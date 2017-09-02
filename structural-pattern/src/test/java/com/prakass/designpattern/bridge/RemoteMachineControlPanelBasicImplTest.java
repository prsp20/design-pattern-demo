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

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;

public class RemoteMachineControlPanelBasicImplTest {
    RemoteMachineControlPanel controlPanel;
    RemoteMachineController controller;

    @Before
    public void testSetup() {
        controller = mock(RemoteMachineController.class);
        controlPanel = new RemoteMachineControlPanelBasicImpl(controller);
    }

    @Test
    public void startMachine_delegatesFunctionalityToMachineController() {
        controlPanel.startMachine("ID-1");

        verify(controller).start("ID-1");
    }

    @Test
    public void stopMachine_delegatesFunctionalityToMachineController() {
        controlPanel.stopMachine("ID-1");

        verify(controller).stop("ID-1");
    }
}
