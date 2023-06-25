package com.lcwd.test.service;

    public class Calculator {
        public static int addTwoNumber(int a,int b){
            return a*b;
    
        }
        public static int productTwoNumber(int a,int b){
            return a * b;
    
        }
        public static int divideTwoNumber(int a,int b){
            return a / b;
    
        }public static int sumAnyNumbers(int... numbers){
            int s=0;
            for (int n:numbers ) {
                s+=n;
            }return s;
        }
    
    }
