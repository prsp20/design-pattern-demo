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

package com.prakass.designpattern.visitor;

import java.util.ArrayList;
import java.util.List;

public class UiScreen implements UiComp {
    private double height;
    private double width;

    List<UiComp> uiComps = new ArrayList<>();

    public UiScreen(double height, double width) {
        this.height = height;
        this.width = width;
    }

    public void addUiComp(UiComp uiComp){
        uiComps.add(uiComp);
    }

    @Override
    public void accept(UiCompVisitor visitor) {
        for (UiComp comp : uiComps) {
            comp.accept(visitor);
        }
        visitor.visit(this);
    }

    @Override
    public double getHeight() {
        return height;
    }

    @Override
    public double getWidth() {
        return width;
    }
}
