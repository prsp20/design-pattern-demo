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
import static org.mockito.Mockito.spy;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.prakass.designpattern.flyweight.Order;
import com.prakass.designpattern.flyweight.ProductCatalog;
import com.prakass.designpattern.flyweight.ProductShop;

public class ProductShopTest {
    List<Order> orders = null;
    ProductCatalog catalog = null;
    ProductShop shop = null;

    @Test
    public void shouldPlaceOrder() {
        orders = spy(new ArrayList<>());
        catalog = spy(new ProductCatalog());
        shop = new ProductShop(catalog, orders);

        shop.placeOrder("1", "Product 1");

        assertThat(catalog.getProductsCount(), is(1));
        assertThat(orders.size(), is(1));

        shop.placeOrder("2", "Product 2");
        shop.placeOrder("2", "Product 2");
        shop.placeOrder("2", "Product 2");
        shop.placeOrder("3", "Product 3");

        assertThat(catalog.getProductsCount(), is(3));
        assertThat(orders.size(), is(5));
    }
}
