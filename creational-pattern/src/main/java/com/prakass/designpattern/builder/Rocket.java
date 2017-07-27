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

/**
 * Example class, of which the object is to be built
 * 
 * @author Prakash Sapkota
 *
 */
public class Rocket {

    public static class RocketBuilder {
        private Rocket rocket;

        public RocketBuilder() {
            rocket = new Rocket();
        }

        public Rocket build() {
            return new Rocket(this);
        }

        public RocketBuilder modelName(String modelName) {
            rocket.modelName = modelName;
            return this;
        }

        public RocketBuilder manufactorCompanyName(String manufactorCompanyName) {
            rocket.manufactorCompanyName = manufactorCompanyName;
            return this;
        }

        public RocketBuilder manufactorYear(int manufactorYear) {
            rocket.manufactorYear = manufactorYear;
            return this;
        }

        public RocketBuilder propulsionSystemName(String propulsionSystemName) {
            rocket.propulsionSystemName = propulsionSystemName;
            return this;
        }

        public RocketBuilder payloadSystemName(String payloadSystemName) {
            rocket.payloadSystemName = payloadSystemName;
            return this;
        }

        public RocketBuilder fuelQuantity(double fuelQuantity) {
            rocket.fuelQuantity = fuelQuantity;
            return this;
        }
    }

    private String modelName;
    private String manufactorCompanyName;
    private int manufactorYear;
    private String propulsionSystemName;
    private String payloadSystemName;
    private double fuelQuantity;

    private Rocket() {
    }

    private Rocket(RocketBuilder builder) {
        this.modelName = builder.rocket.modelName;
        this.manufactorCompanyName = builder.rocket.manufactorCompanyName;
        this.manufactorYear = builder.rocket.manufactorYear;
        this.propulsionSystemName = builder.rocket.propulsionSystemName;
        this.payloadSystemName = builder.rocket.payloadSystemName;
        this.fuelQuantity = builder.rocket.fuelQuantity;
    }

    public String getModelName() {
        return modelName;
    }

    public String getManufactorCompanyName() {
        return manufactorCompanyName;
    }

    public int getManufactorYear() {
        return manufactorYear;
    }

    public String getPropulsionSystemName() {
        return propulsionSystemName;
    }

    public String getPayloadSystemName() {
        return payloadSystemName;
    }

    public double getFuelQuantity() {
        return fuelQuantity;
    }

    @Override
    public String toString() {
        return "Rocket [modelName=" + modelName + ", manufactorCompanyName=" + manufactorCompanyName + ","
                +" manufactorYear=" + manufactorYear + "]";
    }
}
