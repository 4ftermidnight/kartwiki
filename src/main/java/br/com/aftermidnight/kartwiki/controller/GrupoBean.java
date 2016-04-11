package br.com.aftermidnight.kartwiki.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.aftermidnight.kartwiki.model.Grupo;
import br.com.aftermidnight.kartwiki.service.GrupoService;
import br.com.aftermidnight.kartwiki.util.jsf.FacesUtil;


@javax.faces.view.ViewScoped
@Named
public class GrupoBean implements Serializable {
	private static final long serialVersionUID = 1L;

	@Inject private GrupoService service;
	
	/*----------- Componentes utlizados no view -------------*/
	
	//novo objeto a ser cadastrado
	private Grupo grupo = new Grupo();
	
	private Grupo selected;
	
	private List<Grupo> grupos = new ArrayList<>();
	
	/*----------- Componentes utlizados no view -------------*/
	
	public GrupoBean(){}
	
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
			this.grupos = service.obterTodos();
		}		
	}
	
	public void remove(){
		try {
			service.remover(selected);
			this.grupos.remove(selected);
			FacesUtil.info("Grupo " + selected.getNome() + " excluído com sucesso.");
		} catch (Exception e) {
			FacesUtil.error(e.getMessage());
		}
	}

	public void save(){
		try {
			service.salvar(grupo);
			FacesUtil.info("Grupo salvo com sucesso!");
			this.clean();
		} catch (Exception e) {
			FacesUtil.error(e.getMessage());
		}
	}
	
	public boolean isChanging() {
		return this.grupo.getId() != null;
	}
	
	private void clean() {
		this.grupo = new Grupo();
	}

	public GrupoService getService() {
		return service;
	}

	public void setService(GrupoService service) {
		this.service = service;
	}

	public Grupo getGrupo() {
		return grupo;
	}

	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}

	public Grupo getSelected() {
		return selected;
	}

	public void setSelected(Grupo selected) {
		this.selected = selected;
	}

	public List<Grupo> getGrupos() {
		return grupos;
	}

	public void setGrupos(List<Grupo> grupos) {
		this.grupos = grupos;
	}

	
	

	
	
}
