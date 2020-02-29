package com.codenation.modulo06.service;

import com.codenation.modulo06.entity.Cliente;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
public class ClienteServiceTest {

    @Autowired
    ClienteService clienteServiceTest;

    @Test
    void salvarClienteNoBanco() {
        // given
        Cliente cli = new Cliente();
        cli.setCpf("12346789015");
        cli.setNome("Taina");

        // when
        Cliente clienteSalvo = clienteServiceTest.add(cli);

        // then
        assertThat(clienteSalvo).isNotNull();
    }

    @Test
    void verificarIdDoClienteSalvo() {
        // given
        Cliente cli = new Cliente();
        cli.setCpf("12346789015");
        cli.setNome("Taina");

        // when
        Cliente clienteSalvo = clienteServiceTest.add(cli);

        // then
        assertThat(clienteSalvo.getID()).isEqualTo(1);
    }

    @Test
    public void getUserByID() {
        // given
        Cliente cli = new Cliente();

        cli.setCpf("12346789015");
        cli.setNome("Taina");

        clienteServiceTest.add(cli);

        // when
        Cliente found = clienteServiceTest.get(cli.getID());

        // then
        assertThat(found.getNome())
                .isEqualTo(cli.getNome());
    }

    @Test
    public void contaQuantosClientesNoBanco() {
        // given
        Cliente cli = new Cliente();

        cli.setCpf("12346789015");
        cli.setNome("Taina");

        clienteServiceTest.add(cli);

        // when
        long qtd = clienteServiceTest.quantidaClientes();

        // then
        assertThat(qtd).isEqualTo(1);
    }
}
