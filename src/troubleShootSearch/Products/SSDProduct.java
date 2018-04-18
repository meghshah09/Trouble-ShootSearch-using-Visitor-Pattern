package troubleShootSearch.Products;

import java.util.List;

import troubleShootSearch.searchAlgorithms.SearchAlgorithms;

public class SSDProduct  implements ProductsI{
	private List<String> SDDProductTechnicalGuide;
	private String problemKeyword;
	
	public List<String> getSDDProductTechnicalGuide() {
		return SDDProductTechnicalGuide;
	}

	public void setSDDProductTechnicalGuide(List<String> sDDProductTechnicalGuide) {
		SDDProductTechnicalGuide = sDDProductTechnicalGuide;
	}

	public String getProblemKeyword() {
		return problemKeyword;
	}

	public void setProblemKeyword(String problemKeyword) {
		this.problemKeyword = problemKeyword;
	}
	@Override
	public void accept(SearchAlgorithms searchAlgorithms) {
		searchAlgorithms.visit(this, problemKeyword);
		
	}

}
