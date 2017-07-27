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
