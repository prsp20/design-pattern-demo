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

package com.prakass.designpattern.proxy;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class SpecificationImplementationProxyTest {

    ImplementationProxy proxy;
    Implementation implementation;

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void shouldThrowExceptionForInvalidRole() {
        proxy = new ImplementationProxy("Invalid-role");

        expectedException.expect(RuntimeException.class);
        expectedException.expectMessage(containsString("does not have"));
        expectedException.expectMessage(containsString("access rights"));

        proxy.doSomething();
    }

    @Test
    public void shouldDelegateToImplementationForValidRole() {
        implementation = mock(Implementation.class);
        proxy = new ImplementationProxy("ADMIN", implementation);

        proxy.doSomething();

        verify(implementation).doSomething();
    }
}
