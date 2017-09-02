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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * It represents a container containing components. The components may be stored in sequential, or
 * hierarchical, or in any order.
 *
 */
public class ComponentContainer implements Iterable<Component> {
    // Let's imagine it has list of UI components
    private List<Component> uiComponents = new ArrayList<>();

    // Also a dummy map containing binary components
    private Map<String, Component> binaryComponents = new HashMap<>();

    Iterator<Component> iterator = null;

    public ComponentContainer() {}

    public void addUiComponent(Component component) {
        uiComponents.add(component);
    }

    public void addBinaryComponent(String key, Component component) {
        binaryComponents.put(key, component);
    }

    @Override
    public Iterator<Component> iterator() {
        if (iterator == null) {
            // Quick and dirty iterator implementation
            iterator = new Iterator<Component>() {
                private Object currentIteratingCollection = uiComponents;
                private Object[] keyset = binaryComponents.keySet().toArray();
                int index = 0;

                @Override
                public Component next() {
                    if (!hasNext()) {
                        throw new RuntimeException("Item not found!");
                    }

                    Component component = null;
                    if (currentIteratingCollection instanceof List) {
                        if (uiComponents.size() == 0) {
                            currentIteratingCollection = binaryComponents;
                        } else {
                            component = uiComponents.get(index);
                            index++;
                        }
                    }

                    if (currentIteratingCollection instanceof Map) {
                        String componentKey = keyset[index].toString();
                        component = binaryComponents.get(componentKey);
                        index++;
                    }

                    if (currentIteratingCollection instanceof List && index == uiComponents.size()) {
                        // Last item reached on UI components. So reset the index. Also switch the
                        // item to iterate
                        index = 0;
                        currentIteratingCollection = binaryComponents;
                    }

                    return component;
                }

                @Override
                public boolean hasNext() {
                    if (currentIteratingCollection instanceof List) {
                        return index < uiComponents.size()
                                || (uiComponents.size() == 0 && keyset.length > 0);
                    } else {
                        return index < keyset.length;
                    }
                }
            };
        }
        return iterator;
    }
}
