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

package com.prakass.designpattern.chainofresponsibility;

import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.isNull;

import org.junit.Test;

public class FilterConfigTest {

    @Test
    public void shouldInitializeProperly() {
        RequestFilter filter = FilterConfig.config();

        assertThat(filter, is(instanceOf(EncodingFilter.class)));
        assertThat(filter.nextFilter, is(instanceOf(RequestProcessingFilter.class)));
        assertThat(filter.nextFilter.nextFilter, is(instanceOf(AuthenticationFilter.class)));
        assertThat(filter.nextFilter.nextFilter.nextFilter,
                is(instanceOf(ContextInitializationFilter.class)));
        assertThat(filter.nextFilter.nextFilter.nextFilter.nextFilter, is(isNull()));
    }
}
