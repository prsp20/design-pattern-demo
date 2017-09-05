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

package com.prakass.designpattern.memento;

import java.util.Stack;

/**
 * Caretaker class. Implementation based on {@code Stack}
 *
 */
public class Caretaker {
    private Stack<UiCompMemento> uiComponentStates = new Stack<>();

    public void save(UiComp uiComp) {
        uiComponentStates.push(uiComp.save());
    }

    public void revertLastChange(UiComp uiComp) {
        if (uiComponentStates.size() == 0) {
            System.out.println("Cannot revert. Nothing to revert from!");
            return;
        }
        uiComp.revert(uiComponentStates.pop());
    }
}
