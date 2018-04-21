/*package troubleShootSearch.Products;

import java.util.List;

import troubleShootSearch.searchAlgorithms.SearchAlgorithmsVisitorI;

public class SSDProduct  implements ProductsI{
	private List<String> SSDProductTechnicalGuide;
	private String problemKeyword;
	private List<String> input;
        
        public SSDProduct(List<String> in){
            input = in;
        }
        
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
		for(String s : input){
                    this.setProblemKeyword(s);
                    searchAlgorithmsVisitorI.visit(this);
                }
	}

}
*/