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

import java.util.HashMap;
import java.util.Map;

public class ProductRegistry {
    private Map<ProductType, Product> products = new HashMap<>();

    public ProductRegistry() {
        loadProducts();
    }

    public Product createProduct(ProductType type) {
        Product product = null;
        try {
            product = (Product) products.get(type).clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
        return product;
    }

    private void loadProducts() {
        Camera camera = new Camera();
        Laptop laptop = new Laptop();

        products.put(ProductType.CAMERA, camera);
        products.put(ProductType.LAPTOP, laptop);
    }
}
