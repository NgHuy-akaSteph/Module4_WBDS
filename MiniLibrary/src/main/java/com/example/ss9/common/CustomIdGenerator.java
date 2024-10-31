package com.example.ss9.common;

import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

import java.io.Serializable;
import java.util.UUID;

public class CustomIdGenerator implements IdentifierGenerator {

    @Override
    public Serializable generate(SharedSessionContractImplementor session, Object object) {
        var code = UUID.randomUUID().hashCode();
        return Math.abs(code) % 100000;
    }

    private boolean isIdExists(SharedSessionContractImplementor session, int id) {
        String query = "SELECT 1 FROM borrowed_book WHERE id = :id";
        return session.createNativeQuery(query)
                .setParameter("id", id)
                .uniqueResult() != null;
    }
}
