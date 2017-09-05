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

/**
 * The originator class representing a simple UI component.
 *
 */
public class UiComp {
    private String name;
    private double xCordinate = 0;
    private double yCordinate = 0;
    private double height = 0;
    private double width = 0;

    public UiComp(String name, double height, double width) {
        this.name = name;
    }

    public void rename(String name) {
        this.name = name;
    }

    public void move(double finalXCordinate, double finalYCordinate) {
        this.xCordinate = finalXCordinate;
        this.yCordinate = finalYCordinate;
    }

    public void resize(double height, double width) {
        this.height = height;
        this.width = width;
    }

    public void drawUi() {
        System.out.println(String.format("------------- %s ----------------", name));
        System.out.println(String.format("X: %s Y: %s Height: %s Width: %s", xCordinate,
                yCordinate, height, width));
        System.out.println("-------------------------------------");
    }

    public UiCompMemento save() {
        return new UiCompMemento(name, xCordinate, yCordinate, height, width);
    }

    public void revert(UiCompMemento momento) {
        this.name = momento.getName();
        this.xCordinate = momento.getxCordinate();
        this.yCordinate = momento.getyCordinate();
        this.height = momento.getHeight();
        this.width = momento.getWidth();
    }
}
