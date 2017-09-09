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

// Concrete visitor
public class UiCompVisitorImpl implements UiCompVisitor {

    @Override
    public void visit(UiCompButton uiCompButton) {
        // Some algorithm related to button (eg. zooming, or finding relative position, etc.) would
        // come here.
        // When we want to add/change algorithm, we wouldn't need to change the structure of the
        // button
        System.out.println("Some operation/calculation related to button performed");
    }

    @Override
    public void visit(UiCompLabel uiCompLabel) {
        System.out.println("Some operation/calculation related to Label performed");
    }

    @Override
    public void visit(UiCompSection uiCompSection) {
        System.out.println("Some operation/calculation related to Section performed");
    }

    @Override
    public void visit(UiScreen uiScreen) {
        System.out.println("Some operation/calculation related to UI Screen performed");
    }
}
