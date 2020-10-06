package com.totvs.guild_java.construcao_objetos;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ConnectionTest {

    @Test
    @DisplayName("Caso seja feito o release em uma conexão, ela volta a estar disponível na próxima chamada")
    void mesmaConexao() {
        Connection first = Connection.getConnection();
        first.execute("INSERT INTO TASK (ID, DESCRIPTION) VALUES (1, 'BUY SOME BEER')");
        first.release();
        Connection second = Connection.getConnection();
        second.execute("INSERT INTO TASK (ID, DESCRIPTION) VALUES (2, 'WASH THE CAR')");
        Assertions.assertEquals(first, second);
    }

    @Test
    @DisplayName("Se não fizer o release, a fabrica deverá criar uma nova")
    void conexoesDiferentes() {
        Connection first = Connection.getConnection();
        first.execute("INSERT INTO TASK (ID, DESCRIPTION) VALUES (1, 'BUY SOME BEER')");
        Connection second = Connection.getConnection();
        second.execute("INSERT INTO TASK (ID, DESCRIPTION) VALUES (2, 'WASH THE CAR')");
        Assertions.assertNotEquals(first, second);
    }
}
