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

package com.prakass.designpattern.interpreter;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class TerminalExpressionTest {
    @Test
    public void interpretsTheContextCorrectly() {
        TerminalExpression expression = new TerminalExpression("Apple");

        String context = "Something else \t Other Str \n Apple";
        assertThat(expression.interpret(context), is(true));

        context = "Something else \t Other Str \n Banana";
        assertThat(expression.interpret(context), is(false));
    }
}
