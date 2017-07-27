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

import static org.junit.Assert.*;

import static org.hamcrest.Matchers.*;

import org.junit.Before;
import org.junit.Test;

public class ProductRegistryTest {
    ProductRegistry productRegistry;

    @Before
    public void setUp() {
        productRegistry = new ProductRegistry();
    }

    @Test
    public void shouldCreateAnInstanceOfProductTypeCamera() {
        assertThat(productRegistry.createProduct(ProductType.CAMERA), is(notNullValue()));
    }

    @Test
    public void shouldCreateAnInstanceOfProductTypeLaptop() {
        assertThat(productRegistry.createProduct(ProductType.LAPTOP), is(notNullValue()));
    }

    @Test
    public void instancesOfCameraShouldBeDifferent() {
        Camera camera1 = (Camera) productRegistry.createProduct(ProductType.CAMERA);
        Camera camera2 = (Camera) productRegistry.createProduct(ProductType.CAMERA);
        assertThat(camera1, is(not(camera2)));
    }

    @Test
    public void instancesOfLaptopShouldBeDifferent() {
        Laptop laptop1 = (Laptop) productRegistry.createProduct(ProductType.LAPTOP);
        Laptop laptop2 = (Laptop) productRegistry.createProduct(ProductType.LAPTOP);
        assertThat(laptop1, is(not(laptop2)));
    }

}
