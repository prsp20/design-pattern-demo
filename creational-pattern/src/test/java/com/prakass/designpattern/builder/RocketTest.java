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
package com.prakass.designpattern.builder;

import static org.junit.Assert.*;

import static org.hamcrest.Matchers.*;

import org.junit.Test;

public class RocketTest {

    @Test
    public void shouldBuildRocketCorrectly() {
        Rocket.RocketBuilder builder = new Rocket.RocketBuilder();
        Rocket rocket = builder.modelName("PRSP-3 Dragon").manufactorCompanyName("Prakass").manufactorYear(2017).fuelQuantity(2000)
                .payloadSystemName("Heavy layload system").propulsionSystemName("Super propulsion system").build();

        assertThat(rocket.getModelName(), is("PRSP-3 Dragon"));
        assertThat(rocket.getManufactorCompanyName(), is("Prakass"));
        assertThat(rocket.getManufactorYear(), is(equalTo(2017)));
        assertThat(rocket.getFuelQuantity(), is(equalTo(2000.0)));
        assertThat(rocket.getPayloadSystemName(), is("Heavy layload system"));
        assertThat(rocket.getPropulsionSystemName(), is("Super propulsion system"));
    }

}
