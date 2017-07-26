/*******************************************************************************
 * MIT License
 * 
 * Copyright (c) 2017 Prakash Sapkota
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 ******************************************************************************/
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
