/*
 * Copyright 2017 the original author.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */

package com.prakass.designpattern.memento;

public class ClientDemo {
    public static void main(String[] args) {
        Caretaker caretaker = new Caretaker();

        // Create a button component
        UiComp button = new UiComp("Button", 5, 5);

        // Render it to see how it looks
        button.drawUi();

        // Save the original state
        caretaker.save(button);

        // Rename the button and save the change
        button.rename("Button 1");
        caretaker.save(button);


        // Resize it and save the change
        button.resize(4, 4);
        caretaker.save(button);

        // Move it and save the change
        button.move(2, 6);

        // Render
        button.drawUi();

        // Position does not look good. Let's undo it, and restore to the previously saved state
        caretaker.revertLastChange(button);

        // Render it again to see how it looks
        button.drawUi();

        // Set a new position
        button.move(1, 3);
        caretaker.save(button);

        button.drawUi(); // Now the position looks good

        // We're done experimenting. Let's take it back to the original state step by step.
        caretaker.revertLastChange(button);
        button.drawUi();
        caretaker.revertLastChange(button);
        button.drawUi();
        caretaker.revertLastChange(button);
        button.drawUi();
    }
}
