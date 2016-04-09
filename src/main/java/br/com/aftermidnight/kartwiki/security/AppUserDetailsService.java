package br.com.aftermidnight.kartwiki.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import br.com.aftermidnight.kartwiki.dao.hibernate.UsuarioDAO;
import br.com.aftermidnight.kartwiki.model.Grupo;
import br.com.aftermidnight.kartwiki.model.Usuario;
import br.com.aftermidnight.kartwiki.util.cdi.CDIServiceLocator;

/*Provedor de autenticação customizado. */
public class AppUserDetailsService implements UserDetailsService {

	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		//Esta classe é um Bean do springSecurity e nao um Bean do CDI. 
		UsuarioDAO dao = CDIServiceLocator.getBean(UsuarioDAO.class);
		Usuario usuario = dao.buscarPorEmail(email);
		
		UsuarioSistema user = null;
		
		if (usuario != null) {
			user = new UsuarioSistema(usuario, getGrupos(usuario));
		}
		
		return user;
	}

	private Collection<? extends GrantedAuthority> getGrupos(Usuario usuario) {
		List<SimpleGrantedAuthority> authorities = new ArrayList<>();
		
		for (Grupo grupo : usuario.getGrupos()) {
			authorities.add(new SimpleGrantedAuthority(grupo.getNome().toUpperCase()));
		}
		
		return authorities;
	}

}