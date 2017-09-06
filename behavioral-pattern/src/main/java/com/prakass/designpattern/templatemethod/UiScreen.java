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

package com.prakass.designpattern.templatemethod;

import java.util.ArrayList;
import java.util.List;

/**
 * Abstract class defining a template method
 *
 */
public abstract class UiScreen {
    protected double height;
    protected double width;
    protected List<UiComp> components = new ArrayList<>();

    public void setScreenSize(double height, double width) {
        this.height = height;
        this.width = width;
    }

    public void addUiComponent(UiComp uiComp) {
        components.add(uiComp);
    }

    public void removeUiComponent(UiComp uiComp) {
        components.remove(uiComp);
    }

    // Template method. This must be implemented by concrete UI screen.
    public abstract void drawUi();
}
