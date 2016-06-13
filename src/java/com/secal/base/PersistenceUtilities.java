package com.secal.base;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PersistenceUtilities {

    public static EntityManagerFactory factory;

    public static EntityManagerFactory getFactory() {
        if (factory == null) {
            factory = Persistence.createEntityManagerFactory("SanalTicaretPU");
        }
        return factory;
    }

}
