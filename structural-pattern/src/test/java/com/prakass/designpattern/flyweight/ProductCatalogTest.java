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

package com.prakass.designpattern.flyweight;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import com.prakass.designpattern.flyweight.Product;
import com.prakass.designpattern.flyweight.ProductCatalog;

public class ProductCatalogTest {
    @Test
    public void shouldPlaceProductOnCatalogForFirstTime() {
        ProductCatalog catalog = new ProductCatalog();

        catalog.lookup("1", "My product 1");
        catalog.lookup("2", "My product 2");
        catalog.lookup("3", "My product 3");

        assertThat(catalog.getProductsCount(), is(3));
    }

    @Test
    public void shouldReturnProductFromCatalogIfExisting() {
        ProductCatalog catalog = new ProductCatalog();

        catalog.lookup("1", "My product 1");
        catalog.lookup("3", "My product 3");

        Product product = catalog.lookup("1", "My product 1");

        assertThat(product.getId(), is("1"));
        assertThat(product.getName(), is("My product 1"));

        product = catalog.lookup("3", "My product 3");

        assertThat(product.getId(), is("3"));
        assertThat(product.getName(), is("My product 3"));

        assertThat(catalog.getProductsCount(), is(2));
    }
}
