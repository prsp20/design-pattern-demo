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

/**
 * The Memento class
 *
 */
public class UiCompMemento {
    private String name;
    private double xCordinate;
    private double yCordinate;
    private double height;
    private double width;

    public UiCompMemento(String name, double xCordinate, double yCordinate, double height,
            double width) {
        this.name = name;
        this.xCordinate = xCordinate;
        this.yCordinate = yCordinate;
        this.height = height;
        this.width = width;
    }

    public String getName() {
        return name;
    }

    public double getxCordinate() {
        return xCordinate;
    }

    public double getyCordinate() {
        return yCordinate;
    }

    public double getHeight() {
        return height;
    }

    public double getWidth() {
        return width;
    }
}
