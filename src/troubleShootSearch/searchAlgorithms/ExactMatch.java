package troubleShootSearch.searchAlgorithms;

import java.util.ArrayList;
import java.util.List;

import troubleShootSearch.Products.HDDProduct1;

public class ExactMatch implements SearchAlgorithms {

	@Override
	public void visit(HDDProduct1 hddProduct1) {
		
	}

	@Override
	public List<String> search(String problemKeyword, List<String> technicalProblemGuide) {
		List<String> exactMatchOutput = new ArrayList<String>();
		for(String string :technicalProblemGuide) {
		if(string.matches("(.*)problemKeyword(.*)")){
				exactMatchOutput.add(string);
			}
		}
		return exactMatchOutput;
	}
	
}
