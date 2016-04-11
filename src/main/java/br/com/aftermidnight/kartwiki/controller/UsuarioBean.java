package br.com.aftermidnight.kartwiki.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.aftermidnight.kartwiki.model.Usuario;
import br.com.aftermidnight.kartwiki.service.UsuarioService;
import br.com.aftermidnight.kartwiki.util.jsf.FacesUtil;


@javax.faces.view.ViewScoped
@Named
public class UsuarioBean implements Serializable {
	private static final long serialVersionUID = 1L;

	@Inject private UsuarioService service;
	
	/*----------- Componentes utlizados no view -------------*/
	
	//novo usuario a ser cadastrado
	private Usuario usuario = new Usuario();
	
	private Usuario selected;
	
	private List<Usuario> usuarios = new ArrayList<>();
	
	/*----------- Componentes utlizados no view -------------*/
	
	public UsuarioBean(){}
	
	@PostConstruct
    public void afterCreate() {
		
    }
	
	@PreDestroy
    public void preDestroy() {
		
    }
	
	// metodo chamado por meio da página (no prerender da view).
	public void init(){
		// isPostback checa se já é postback (se não é o primeiro carregamento
		// da pagina)
		if (FacesUtil.isNotPostback()) {
			this.usuarios = service.obterTodos();
		}		
	}
	
	public void remove(){
		try {
			service.remover(selected);
			this.usuarios.remove(selected);
			FacesUtil.info("Usuário " + selected.getNome() + " excluído com sucesso.");
		} catch (Exception e) {
			FacesUtil.error(e.getMessage());
		}
	}


	public void save(){
		try {
			service.salvar(usuario);
			FacesUtil.info("Usuário salvo com sucesso!");
			this.clean();
		} catch (Exception e) {
			FacesUtil.error(e.getMessage());
		}
	}
	
	public boolean isChanging() {
		return this.usuario.getId() != null;
	}
	
	private void clean() {
		this.usuario = new Usuario();
	}

	public UsuarioService getService() {
		return service;
	}

	public void setService(UsuarioService service) {
		this.service = service;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Usuario getSelected() {
		return selected;
	}

	public void setSelected(Usuario selected) {
		this.selected = selected;
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
	
	

	
	
}
