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

package com.prakass.designpattern.state;

/**
 * Concrete state. It knows only about next state. It does not care about any other other states.
 *
 */
public class UsbInputState extends InputSourceState {

    public UsbInputState(MusicPlayerInputSourceButton button) {
        super(button);
    }

    @Override
    public void pressInputSourceButton() {
        button.setInputSource(new BluetoothInputState(button));
    }

    @Override
    public String toString() {
        return "USB 1 input source";
    }
}
