package com.br.rpeixoto.dao;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.br.rpeixoto.domain.Cliente;

/**
 * ClienteMapDAO
 */
public class ClienteMapDAO implements IClienteDAO {

  private Map<Long, Cliente> map;

  public ClienteMapDAO() {
    this.map = new HashMap<>();
  }

  @Override
  public Boolean registrar(Cliente cliente) {

    if (this.map.containsKey(cliente.getCpf())) {
      return false;
    }
    return true;
  }

  @Override
  public void apagar(Long cpf) {
    Cliente clienteCadastrado = this.map.get(cpf);

    if (clienteCadastrado != null) {
      this.map.remove(clienteCadastrado.getCpf(), clienteCadastrado);
    }
  }

  @Override
  public void alterar(Cliente cliente) {

    Cliente clienteCadastrado = this.map.get(cliente.getCpf());
    if (clienteCadastrado != null) {
      clienteCadastrado.setNome(cliente.getNome());
      clienteCadastrado.setTel(cliente.getTel());
      clienteCadastrado.setNum(cliente.getNum());
      clienteCadastrado.setEnd(cliente.getEnd());
      clienteCadastrado.setCidade(cliente.getCidade());
      clienteCadastrado.setEstado(cliente.getEstado());
    }
  }

  @Override
  public Cliente consultar(Long cpf) {
    return this.map.get(cpf);
  }

  @Override
  public Collection<Cliente> buscarTodos() {
    return this.map.values();
  }

}