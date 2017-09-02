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

package com.prakass.designpattern.composite;

public class GeneralManager extends Manager {
    private String name;
    private String title;

    public GeneralManager(String name, String title) {
        this.name = name;
        this.title = title;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public void printBusinessCard() {
        StringBuilder builder = new StringBuilder();
        builder.append(getName() + "\n");
        builder.append(getTitle() + "\n");
        builder.append("Human Resources and Development" + "\n");
        builder.append("Compnay Ltd.");

        System.out.println(builder.toString());
    }
}
