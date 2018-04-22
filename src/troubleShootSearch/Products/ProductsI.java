package troubleShootSearch.Products;

import java.util.List;

import troubleShootSearch.searchAlgorithms.SearchAlgorithmsVisitorI;

public interface ProductsI {

	List<String> technicalGuide=null;
	public void accept(SearchAlgorithmsVisitorI searchAlgorithmsVisitorI);

}