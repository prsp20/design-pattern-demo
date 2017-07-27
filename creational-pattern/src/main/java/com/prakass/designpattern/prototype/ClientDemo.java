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

package com.prakass.designpattern.prototype;

public class ClientDemo {

    public static void main(String[] args) {
        ProductRegistry registry = new ProductRegistry();

        // For each run, every instance of both camera and laptop will be unique
        for (int i = 1; i <= 10; i++) {
            System.out.println(String.format("Run %s:", i));

            // Here we get the unique instance of Camera without using "new" operator
            Camera camera = (Camera) registry.createProduct(ProductType.CAMERA);

            // Similarly, here we get the unique instance of Laptop without using "new" operator
            Laptop laptop = (Laptop) registry.createProduct(ProductType.LAPTOP);

            // Each instance should be unique
            System.out.println(camera);
            System.out.println(laptop);
            System.out.println("");
        }
    }
}
