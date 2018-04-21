/*package troubleShootSearch.Products;

import java.util.List;

import troubleShootSearch.searchAlgorithms.SearchAlgorithmsVisitorI;

public class HDDProduct implements ProductsI{

	private List<String> HDDProductTechnicalGuide;
	private String ProblemKeyword;
	private List<String> inputs;

	public HDDProduct(List<String> in){
		inputs = in;
	}
	public String getProblemKeyword() {
		return ProblemKeyword;
	}
	public void setProblemKeyword(String problemKeywordIn) {
		ProblemKeyword = problemKeywordIn;
	}
	public List<String> getHDDProductTechnicalGuide() {
		return HDDProductTechnicalGuide;
	}
	public void setHDDProductTechnicalGuide(List<String> hDDProductTechnicalGuide) {
		HDDProductTechnicalGuide = hDDProductTechnicalGuide;
	}

	@Override
	public void accept(SearchAlgorithmsVisitorI searchAlgorithmsVisitorI){
		for(String s :inputs){
			this.setProblemKeyword(s);
			searchAlgorithmsVisitorI.visit(this);
		}
		//searchAlgorithmsVisitorI.visit(this);
	}

}
*/