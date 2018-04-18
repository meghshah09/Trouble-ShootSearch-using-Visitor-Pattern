package troubleShootSearch.searchAlgorithms;

import java.util.ArrayList;
import java.util.List;

import troubleShootSearch.Products.HDDProduct1;

public class NaiveStemmingMatch implements SearchAlgorithms{

	@Override
	public void visit(HDDProduct1 hddProduct1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<String> search(String problemKeyword, List<String> technicalProblemGuide) {
		
		String [] tempArray = problemKeyword.trim().split("\\s+");
		List<String> naiveStemmingMatchOutput = new ArrayList<String>();
		for(String string: technicalProblemGuide) {
			if(string.contains(tempArray[0])) {
			naiveStemmingMatchOutput.add(string);
			}
		}
		
		return naiveStemmingMatchOutput;
	}

}
