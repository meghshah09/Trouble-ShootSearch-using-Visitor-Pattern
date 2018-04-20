package troubleShootSearch.Products;

import java.util.List;

import troubleShootSearch.searchAlgorithms.SearchAlgorithmsVisitorI;

public class SSDProduct  implements ProductsI{
	private List<String> SSDProductTechnicalGuide;
	private String problemKeyword;
	
	public List<String> getSSDProductTechnicalGuide() {
		return SSDProductTechnicalGuide;
	}

	public void setSSDProductTechnicalGuide(List<String> sDDProductTechnicalGuide) {
		SSDProductTechnicalGuide = sDDProductTechnicalGuide;
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
