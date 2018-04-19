package troubleShootSearch.Products;

import java.util.List;

import troubleShootSearch.searchAlgorithms.SearchAlgorithmsVisitorI;

public class HDDProduct implements ProductsI{
	
	private List<String> HDDProductTechnicalGuide;
	private String ProblemKeyword;
	
	public String getProblemKeyword() {
		return ProblemKeyword;
	}
	public void setProblemKeyword(String problemKeyword) {
		ProblemKeyword = problemKeyword;
	}
	public List<String> getHDDProductTechnicalGuide() {
		return HDDProductTechnicalGuide;
	}
	public void setHDDProductTechnicalGuide(List<String> hDDProductTechnicalGuide) {
		HDDProductTechnicalGuide = hDDProductTechnicalGuide;
	}
	
	public void accept(SearchAlgorithmsVisitorI searchAlgorithmsVisitorI){
		searchAlgorithmsVisitorI.visit(this, ProblemKeyword);
	}

}
