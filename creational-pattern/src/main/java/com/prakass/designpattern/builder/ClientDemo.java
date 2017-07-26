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

public class ClientDemo {
    public static void main(String[] args) {
        Rocket.RocketBuilder builder = new Rocket.RocketBuilder();
        Rocket rocket = builder.modelName("PRSP-3 Dragon").manufactorCompanyName("Prakass").manufactorYear(2017).fuelQuantity(2000)
                .payloadSystemName("Heavy layload system").propulsionSystemName("Super propulsion system").build();
        System.out.println("Rocket build!");
        System.out.println("Ready to be lunched...");
        System.out.println("Rocket info:");
        System.out.println(rocket);
    }
}
