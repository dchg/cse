package com.service.dchgtest.controller;



import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class TestDchgtest {

        DchgtestDelegate dchgtestDelegate = new DchgtestDelegate();


    @Test
    public void testhelloworld(){

        String expactReturnValue = "hello"; // You should put the expect String type value here.

        String returnValue = dchgtestDelegate.helloworld("hello");

        assertEquals(true, returnValue.contains(expactReturnValue));
    }

}