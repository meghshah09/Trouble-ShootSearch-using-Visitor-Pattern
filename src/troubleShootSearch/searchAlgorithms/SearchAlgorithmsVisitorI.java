package troubleShootSearch.searchAlgorithms;
import java.util.List;

import troubleShootSearch.Products.DSeagateProducts;

public interface SearchAlgorithmsVisitorI {
	public void visit(DSeagateProducts dSeagateProducts);	

	public List<String> search(String problemKeyword, List<String> technicalProblemGuide);
	
}
