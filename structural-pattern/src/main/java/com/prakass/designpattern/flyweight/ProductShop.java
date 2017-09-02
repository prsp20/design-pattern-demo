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

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ProductShop {
    private ProductCatalog catalog = new ProductCatalog();
    private List<Order> orders = new ArrayList<>();

    public ProductShop() {}

    // Enabling DI for testing purpose. Not accessible from outside the package.
    ProductShop(ProductCatalog catalog, List<Order> orders) {
        this.catalog = catalog;
        this.orders = orders;
    }

    public void placeOrder(String productId, String productName) {
        Product product = catalog.lookup(productId, productName);

        Order order = new Order(UUID.randomUUID().toString(), product);
        orders.add(order);
    }

    public void processOrders() {
        List<Order> processedOrders = new ArrayList<>();
        for (Order order : orders) {
            order.processOrder();
            processedOrders.add(order);
        }
        orders.removeAll(processedOrders);
    }

    public void checkOrders() {
        System.out.println(String.format("Count of total orders: %s", orders.size()));
    }

    public void checkCatalog() {
        System.out.println(String.format("Count of total products in the catalog: %s",
                catalog.getProductsCount()));
    }
}
