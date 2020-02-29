package com.codenation.modulo06.component;

import com.codenation.modulo06.entity.Cliente;
import com.codenation.modulo06.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CommandLineAppStartupRunner implements CommandLineRunner {

    @Autowired
    ClienteService clienteService;

    @Override
    public void run(String... args){
        this.criarCliente();
    }

    private void criarCliente(){
        Cliente cli = new Cliente();

        cli.setCpf("12346789015");
        cli.setNome("Taina");

        clienteService.add(cli);
    }
}
