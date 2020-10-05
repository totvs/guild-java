package com.totvs.guild_java.construcao_objetos;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class Connection {

    private static final List<Connection> POOL = new ArrayList<>(10);

    private final Consumer<Connection> onRelease;

    public static Connection getConnection() {
        synchronized (POOL) {
            if (POOL.isEmpty()) {
                return new Connection(POOL::add);
            }
            return POOL.remove(0);
        }
    }

    private Connection(Consumer<Connection> onRelease) {
        this.onRelease = onRelease;
    }

    public void execute(String sql) {
        System.out.println("Executing with connection " + this);
        System.out.println("SQL: " + sql);
    }

    public void release() {
        onRelease.accept(this);
    }
}
