package com.jun.plugin.guava;

import static org.junit.Assert.assertEquals;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Sets;

public class CollectionTest {

    // Some customers
    Customer bob = new Customer(1, "Bob");
    Customer lisa = new Customer(2, "Lisa");
    Customer stephen = new Customer(3, "Stephen");
    Customer ken = new Customer(null, "Ken");

    @Test
    public void someSets() {
        ImmutableSet<Customer> customers1 = ImmutableSet.of(bob, lisa, stephen);
        ImmutableSet<Customer> customers2 = ImmutableSet.of(stephen, ken);

        assertEquals(4, Sets.union(customers1, customers2).size());

        assertEquals(ImmutableSet.of(stephen),
                Sets.intersection(customers1, customers2));
    }


    @Test
    public void some() {
        // TODO: Add more collections demos
    }

}
