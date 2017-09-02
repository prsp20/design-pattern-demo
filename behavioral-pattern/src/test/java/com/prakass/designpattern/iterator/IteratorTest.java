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

package com.prakass.designpattern.iterator;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class IteratorTest {
    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void iterate_emptyContainer() {
        ComponentContainer container = new ComponentContainer();
        Iterator<Component> iterator = container.iterator();

        assertThat(iterator.hasNext(), is(false));

        exception.expect(RuntimeException.class);
        iterator.next();
    }

    @Test
    public void iterate_withSingleUiComponent() {
        ComponentContainer container = new ComponentContainer();

        Component component = new UiComponent("UIComp", 1, 1);
        container.addUiComponent(component);

        Iterator<Component> iterator = container.iterator();

        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.hasNext(), is(true));

        // Get the item
        Component fetched = iterator.next();
        assertThat(fetched, is(component));

        assertThat(iterator.hasNext(), is(false));

        exception.expect(RuntimeException.class);
        iterator.next();
    }

    @Test
    public void iterate_withMultipleUiComponent() {
        ComponentContainer container = new ComponentContainer();

        for (int i = 0; i < 10; i++) {
            container.addUiComponent(new UiComponent("UIComp", 1, 1));
        }

        Iterator<Component> iterator = container.iterator();

        for (int i = 0; i < 10; i++) {
            assertThat(iterator.hasNext(), is(true));
            iterator.next();
        }

        assertThat(iterator.hasNext(), is(false));

        exception.expect(RuntimeException.class);
        iterator.next();
    }

    @Test
    public void iterate_withSingleBinaryComponent() {
        ComponentContainer container = new ComponentContainer();

        Component component = new BinaryComponent("BinaryComp", new byte[2]);
        container.addBinaryComponent("Key1", component);

        Iterator<Component> iterator = container.iterator();

        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.hasNext(), is(true));

        // Get the item
        Component fetched = iterator.next();
        assertThat(fetched, is(component));

        assertThat(iterator.hasNext(), is(false));

        exception.expect(RuntimeException.class);
        iterator.next();
    }

    @Test
    public void iterate_withMultipleBinaryComponent() {
        ComponentContainer container = new ComponentContainer();

        for (int i = 0; i < 10; i++) {
            Component binaryComp = new BinaryComponent("BinaryComp", new byte[2]);
            container.addBinaryComponent("Key" + i, binaryComp);
        }

        Iterator<Component> iterator = container.iterator();

        for (int i = 0; i < 10; i++) {
            assertThat(iterator.hasNext(), is(true));
            iterator.next();
        }

        assertThat(iterator.hasNext(), is(false));

        exception.expect(RuntimeException.class);
        iterator.next();
    }

    @Test
    public void iterate_withSingleUiComponentAndSingleBinaryComponent() {
        ComponentContainer container = new ComponentContainer();

        Component uiComp = new UiComponent("UIComp", 1, 1);
        Component binaryComp = new BinaryComponent("BinaryComp", new byte[2]);
        container.addUiComponent(uiComp);
        container.addBinaryComponent("Key1", binaryComp);

        Iterator<Component> iterator = container.iterator();

        assertThat(iterator.hasNext(), is(true));
        Component comp1 = iterator.next();
        assertThat(iterator.hasNext(), is(true));
        Component comp2 = iterator.next();

        assertThat(comp1, is(uiComp));
        assertThat(comp2, is(binaryComp));

        assertThat(iterator.hasNext(), is(false));

        exception.expect(RuntimeException.class);
        iterator.next();
    }

    @Test
    public void iterate_withTwoUiComponentAndTwoBinaryComponent() {
        ComponentContainer container = new ComponentContainer();

        container.addUiComponent(new UiComponent("UIComp", 1, 1));
        container.addUiComponent(new UiComponent("UIComp", 1, 1));
        container.addBinaryComponent("Key1", new BinaryComponent("BinaryComp", new byte[2]));
        container.addBinaryComponent("Key2", new BinaryComponent("BinaryComp", new byte[2]));

        Iterator<Component> iterator = container.iterator();

        for (int i = 0; i < 4; i++) {
            assertThat(iterator.hasNext(), is(true));
            iterator.next();
        }

        assertThat(iterator.hasNext(), is(false));

        exception.expect(RuntimeException.class);
        iterator.next();
    }

    @Test
    public void iterate_withMultipleUiComponentAndMultipleBinaryComponent() {
        ComponentContainer container = new ComponentContainer();

        for (int i = 0; i < 10; i++) {
            Component binaryComp = new BinaryComponent("BinaryComp", new byte[2]);
            container.addBinaryComponent("Key" + i, binaryComp);
        }

        for (int i = 0; i < 10; i++) {
            container.addUiComponent(new UiComponent("UIComp", 1, 1));
        }

        Iterator<Component> iterator = container.iterator();

        for (int i = 0; i < 20; i++) {
            assertThat(iterator.hasNext(), is(true));
            iterator.next();
        }

        assertThat(iterator.hasNext(), is(false));

        exception.expect(RuntimeException.class);
        iterator.next();
    }
}
