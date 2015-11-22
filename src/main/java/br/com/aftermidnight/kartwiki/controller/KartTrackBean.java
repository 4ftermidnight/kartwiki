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

@RequestScoped
@Named
public class KartTrackBean implements Serializable{

	@Inject	private KartTrackDAO dao;
	
	private KartTrack kartTrack;
	
	private KartTrack selectedKartTrack;
	
	private List<KartTrack> kartTracks = new ArrayList<>();
	
	public KartTrackBean(){}
	
	@PostConstruct
    public void afterCreate() {
		
    }
	
	@PreDestroy
    public void preDestroy() {
		
    }
	
	public void init(){
		if (this.kartTrack == null) {
			this.clean();
		}
		
		this.kartTracks = dao.buscarTodos();
//		this.categorias = Arrays.asList(Categoria.values());
	}
	
	public void removeKartTrack(){
//		try {
//			dao.excluir(selectedKartTrack);
//			this.kartTracks.remove(selectedKartTrack);
//			FacesUtil.info("Kartódromo " + selectedKartTrack.getName() + " excluído com sucesso.");
//		} catch (BusinessException e) {
//			FacesUtil.error(e.getMessage());
//		}
	}
	
	public void saveKartTrack(){
//		try {
//			this.cadastroKartTrackService.salvar(kartTrack);
//			FacesUtil.info("Kartódromo salvo com sucesso!");
//			this.clean();
//		} catch (BusinessException e) {
//			FacesUtil.error(e.getMessage());
//		}
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
