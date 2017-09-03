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

public class ClientDemo {
    public static void main(String[] args) {

        // Vegetables
        String context = "Tomato Cucumber";
        System.out.println("Is the given context vegetable? "
                + bildExpressionTreeForVegetables().interpret(context)); // Prints: true
        context = "Apple";
        System.out.println("Is the given context vegetable? "
                + bildExpressionTreeForVegetables().interpret(context)); // Prints: false

        // Fruits
        context = "Banana";
        System.out.println("Is the given context fruits? "
                + bildExpressionTreeForFruits().interpret(context)); // Prints: true
        context = "Tomato";
        System.out.println("Is the given context fruits? "
                + bildExpressionTreeForFruits().interpret(context)); // Prints: false

        // Fruits or vegetables
        context = "Broccoli Apple Banana Cucumber";
        System.out.println("Is the given context fruits or vegetable? "
                + bildExpressionTreeForFruitsOrVegetables().interpret(context)); // Prints: true
        context = "Orange";
        System.out.println("Is the given context fruits or vegetable? "
                + bildExpressionTreeForFruitsOrVegetables().interpret(context)); // Prints: true

        // Fruits and vegetables
        context = "Broccoli Tomato Banana Orange";
        System.out.println("Is the given context fruits and vegetable? "
                + bildExpressionTreeForFruitsAndVegetables().interpret(context)); // Prints: true
        context = "Apple Orange";
        System.out.println("Is the given context fruits and vegetable? "
                + bildExpressionTreeForFruitsAndVegetables().interpret(context)); // Prints: false
    }

    private static Expression bildExpressionTreeForVegetables() {
        Expression expression1 = new TerminalExpression("Tomato");
        Expression expression2 = new TerminalExpression("Broccoli");
        Expression expression3 = new TerminalExpression("Cucumber");

        Expression compoundExpression1 = new OrExpression(expression1, expression2);
        Expression compoundExpression2 = new OrExpression(compoundExpression1, expression3);

        return compoundExpression2;
    }

    private static Expression bildExpressionTreeForFruits() {
        Expression expression1 = new TerminalExpression("Apple");
        Expression expression2 = new TerminalExpression("Orange");
        Expression expression3 = new TerminalExpression("Banana");

        Expression compoundExpression1 = new OrExpression(expression1, expression2);
        Expression compoundExpression2 = new OrExpression(compoundExpression1, expression3);

        return compoundExpression2;
    }

    private static Expression bildExpressionTreeForFruitsOrVegetables() {
        return new OrExpression(bildExpressionTreeForVegetables(), bildExpressionTreeForFruits());
    }

    private static Expression bildExpressionTreeForFruitsAndVegetables() {
        return new AndExpression(bildExpressionTreeForVegetables(), bildExpressionTreeForFruits());
    }
}
