package br.com.aftermidnight.kartwiki.security;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import br.com.aftermidnight.kartwiki.model.Usuario;

//Classe que representa o usuario do sistema pensando no SpringSecurity
//Foi criado uma classe chamada UsuarioSistema para poder armazenar o objeto usuario
public class UsuarioSistema extends User {

	private static final long serialVersionUID = 1L;
	
	private Usuario usuario;
	
	public UsuarioSistema(Usuario usuario, Collection<? extends GrantedAuthority> authorities) {
		super(usuario.getEmail(), usuario.getSenha(), authorities);
		this.usuario = usuario;
	}

	public Usuario getUsuario() {
		return usuario;
	}

}