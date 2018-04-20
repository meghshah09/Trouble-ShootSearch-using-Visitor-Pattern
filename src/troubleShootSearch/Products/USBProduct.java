package troubleShootSearch.Products;

import java.util.List;

import troubleShootSearch.searchAlgorithms.SearchAlgorithmsVisitorI;

public class USBProduct  implements ProductsI{
	
	private List<String> USBProductTechnicalGuide;
	private String problemKeyword;
	
	
	public List<String> getUSBProductTechnicalGuide() {
		return USBProductTechnicalGuide;
	}
	public void setUSBProductTechnicalGuide(List<String> uSBProductTechnicalGuide) {
		USBProductTechnicalGuide = uSBProductTechnicalGuide;
	}
	public String getProblemKeyword() {
		return problemKeyword;
	}
	public void setProblemKeyword(String problemKeyword) {
		this.problemKeyword = problemKeyword;
	}
	
	@Override
	public void accept(SearchAlgorithmsVisitorI searchAlgorithmsVisitorI) {
		searchAlgorithmsVisitorI.visit(this);
	}

}
