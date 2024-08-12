package com.example.demo.controller;

import com.example.demo.model.Cliente;
import com.example.demo.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {
    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public List<Cliente> listar() {
        return clienteService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Cliente> buscar(@PathVariable Long id) {
        return clienteService.findById(id);
    }

    @PostMapping
    public Cliente adicionar(@RequestBody Cliente cliente) {
        return clienteService.save(cliente);
    }

    @DeleteMapping("/{id}")
    public void remover(@PathVariable Long id) {
        clienteService.delete(id);
    }
}
