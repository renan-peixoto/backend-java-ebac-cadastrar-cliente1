package com.br.rpeixoto.dao;

import java.util.Collection;

import com.br.rpeixoto.domain.Cliente;

public interface IClienteDAO {

  public Boolean registrar(Cliente cliente);

  public void apagar(Long cpf);

  public void alterar(Cliente client);

  public Cliente consultar(Long cpf);

  public Collection<Cliente> buscarTodos();
}
