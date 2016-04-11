package br.com.aftermidnight.kartwiki.controller;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;


@RequestScoped
@Named
public class TestBean {
	private List<String> selectedItems; // +getter +setter
	private List<String> availableItems; // +getter (no setter necessary!)

	public TestBean() {	}

	public void submit() {
	    System.out.println("Selected items: " + selectedItems);
	}

	public List<String> getSelectedItems() {
		return selectedItems;
	}

	public void setSelectedItems(List<String> selectedItems) {
		this.selectedItems = selectedItems;
	}

	public List<String> getAvailableItems() {
		availableItems = new ArrayList<String>();
	    availableItems.add("1");
	    availableItems.add("two");
	    availableItems.add("three");
		return availableItems;
	}

	public void setAvailableItems(List<String> availableItems) {
		this.availableItems = availableItems;
	}
	
	
	
	
	
}
