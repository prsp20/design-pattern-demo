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

/**
 * Example class, of which the object is to be built
 * 
 * @author Prakash Sapkota
 *
 */
public class Rocket {

    /**
     * Rocket builder class.
     *
     */
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

    public Rocket(RocketBuilder builder) {
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
