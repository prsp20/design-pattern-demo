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

package com.prakass.designpattern.iterator;

public class ClientDemo {
    public static void main(String[] args) {
        ComponentContainer container = new ComponentContainer();

        for (int i = 1; i <= 10; i++) {
            container.addUiComponent(new UiComponent("UI component " + i, 1, 1));
        }

        for (int i = 1; i <= 10; i++) {
            Component binaryComp = new BinaryComponent("Binary component " + i, new byte[2]);
            container.addBinaryComponent("Key" + i, binaryComp);
        }

        // Traverse through all components
        Iterator<Component> iterator = container.iterator();
        while (iterator.hasNext()) {
            Component c = iterator.next();
            System.out.println(c.getName());
        }
    }
}
