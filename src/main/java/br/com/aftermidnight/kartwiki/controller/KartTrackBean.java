package br.com.aftermidnight.kartwiki.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.aftermidnight.kartwiki.dao.hibernate.KartTrackDAO;
import br.com.aftermidnight.kartwiki.model.KartTrack;
import br.com.aftermidnight.kartwiki.service.KartTrackService;
import br.com.aftermidnight.kartwiki.util.jpa.Transactional;
import br.com.aftermidnight.kartwiki.util.jsf.FacesUtil;

@RequestScoped
@Named
public class KartTrackBean implements Serializable{
	private static final long serialVersionUID = 1L;

	@Inject	private KartTrackDAO dao;
	@Inject private KartTrackService service;
	
	/*----------- Componentes utlizados no view -------------*/
	
	//novo karttrak a ser cadastrado
	private KartTrack kartTrack = new KartTrack();
	
	private KartTrack selectedKartTrack;
	
	private List<KartTrack> kartTracks = new ArrayList<>();
	
	/*----------- Componentes utlizados no view -------------*/
	
	public KartTrackBean(){}
	
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
		if (!FacesUtil.isPostback()) {
			this.kartTracks = dao.buscarTodos();
		}		
	}
	
	public void removeKartTrack(){
		try {
			dao.remover(selectedKartTrack);
			this.kartTracks.remove(selectedKartTrack);
			FacesUtil.info("Kartódromo " + selectedKartTrack.getName() + " excluído com sucesso.");
		} catch (Exception e) {
			FacesUtil.error(e.getMessage());
		}
	}

	public void saveKartTrack(){
		try {
			service.salvar(kartTrack);
			FacesUtil.info("Kartódromo salvo com sucesso!");
			this.clean();
		} catch (Exception e) {
			FacesUtil.error(e.getMessage());
		}
	}
	
	public boolean isChanging() {
		return this.kartTrack.getId() != null;
	}
	
	private void clean() {
		this.kartTrack = new KartTrack();
	}
	
	

	public KartTrack getKartTrack() {
		return kartTrack;
	}

	public void setKartTrack(KartTrack kartTrack) {
		this.kartTrack = kartTrack;
	}

	public KartTrack getSelectedKartTrack() {
		return selectedKartTrack;
	}

	public void setSelectedKartTrack(KartTrack selectedKartTrack) {
		this.selectedKartTrack = selectedKartTrack;
	}

	public List<KartTrack> getKartTracks() {
		return kartTracks;
	}

	public void setKartTracks(List<KartTrack> kartTracks) {
		this.kartTracks = kartTracks;
	}
	
	
	
}
