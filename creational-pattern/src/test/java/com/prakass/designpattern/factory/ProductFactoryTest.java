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

package com.prakass.designpattern.factory;

import static org.junit.Assert.*;

import static org.hamcrest.Matchers.*;

import org.junit.Test;

public class ProductFactoryTest {

    @Test
    public void shouldCreateCameraProduct() {
        Product product = ProductFactory.getProduct(ProductType.CAMERA);
        assertThat(product.constructProductDescription(), containsString("camera"));
    }

    @Test
    public void shouldCreateLaptopProduct() {
        Product product = ProductFactory.getProduct(ProductType.LAPTOP);
        assertThat(product.constructProductDescription(), containsString("laptop"));
    }

    @Test
    public void shouldReturnNullForUnknownType() {
        Product product = ProductFactory.getProduct(null);
        assertThat(product, is(nullValue()));
    }

}
