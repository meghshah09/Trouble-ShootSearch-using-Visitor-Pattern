package troubleShootSearch.Products;

import java.util.List;

import troubleShootSearch.searchAlgorithms.SearchAlgorithms;

public class HDDProduct1 implements HDDProductI{
	
	private List<String> HDDProductTechnicalGuide;
	
	public List<String> getHDDProductTechnicalGuide() {
		return HDDProductTechnicalGuide;
	}


	public void setHDDProductTechnicalGuide(List<String> hDDProductTechnicalGuide) {
		HDDProductTechnicalGuide = hDDProductTechnicalGuide;
	}
	
	public void accept(SearchAlgorithms searchAlgorithms){
		searchAlgorithms.visit(this);
	}



}
