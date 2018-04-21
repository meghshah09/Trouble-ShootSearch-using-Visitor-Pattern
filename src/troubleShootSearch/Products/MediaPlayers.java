/*package troubleShootSearch.Products;

import java.util.List;

import troubleShootSearch.searchAlgorithms.SearchAlgorithmsVisitorI;

public class MediaPlayers  implements ProductsI{
	private List<String> mediaPlayerTechnicalGuide;
	private String problemKeyword;
	private List<String> inputs;
        
        public MediaPlayers(List<String> in){
            inputs = in;
        }
	public List<String> getMediaPlayerTechnicalGuide() {
		return mediaPlayerTechnicalGuide;
	}

	public void setMediaPlayerTechnicalGuide(List<String> mediaPlayerTechnicalGuide) {
		this.mediaPlayerTechnicalGuide = mediaPlayerTechnicalGuide;
	}

	public String getProblemKeyword() {
		return problemKeyword;
	}

	public void setProblemKeyword(String problemKeyword) {
		this.problemKeyword = problemKeyword;
	}
	@Override
	public void accept(SearchAlgorithmsVisitorI searchAlgorithmsVisitorI) {
            for(String s : inputs ){
                this.setProblemKeyword(s);
                searchAlgorithmsVisitorI.visit(this);
            }
                
	}
}
*/