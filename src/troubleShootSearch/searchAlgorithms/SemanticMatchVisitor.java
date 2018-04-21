package troubleShootSearch.searchAlgorithms;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import troubleShootSearch.Products.DSeagateProducts;
/*import troubleShootSearch.Products.HDDProduct;
import troubleShootSearch.Products.MediaPlayers;
import troubleShootSearch.Products.SSDProduct;
import troubleShootSearch.Products.USBProduct;
 */
import troubleShootSearch.util.FileProcessor;
import troubleShootSearch.util.FilesLoader;

public class SemanticMatchVisitor implements SearchAlgorithmsVisitorI{

	private Map<String,List<String>> synonyms;
	private FilesLoader fl;
	private FileProcessor fp;
	public SemanticMatchVisitor(String fileIn, FileProcessor fpIn){
		fl = new FilesLoader(fpIn);
		synonyms = fl.loadSynFile(fileIn);
	}
	List<String> technicalProblemGuideForHDDProduct;
	List<String> technicalProblemGuideForSDDProduct;
	List<String> technicalProblemGuideForUSBProduct;
	List<String> technicalProblemGuideForMediaPlayerProduct;

	@Override
	public void visit(DSeagateProducts dSeagateProducts) {
		technicalProblemGuideForHDDProduct = dSeagateProducts.getHDDProductTechnicalGuide();
		this.search(dSeagateProducts.getProblemKeyword(), technicalProblemGuideForHDDProduct);

		technicalProblemGuideForSDDProduct = dSeagateProducts.getSDDProductTechnicalGuide();
		this.search(dSeagateProducts.getProblemKeyword(), technicalProblemGuideForSDDProduct);

		technicalProblemGuideForUSBProduct = dSeagateProducts.getUSBProductTechnicalGuide();
		this.search(dSeagateProducts.getProblemKeyword(), technicalProblemGuideForUSBProduct);

		technicalProblemGuideForMediaPlayerProduct = dSeagateProducts.getMediaPlayerProductTechnicalGuide();
		this.search(dSeagateProducts.getProblemKeyword(), technicalProblemGuideForMediaPlayerProduct);

	}

	/*	@Override
	public void visit(HDDProduct hddProduct1) {
		List<String> technicalProblemGuide = hddProduct1.getHDDProductTechnicalGuide();
		this.search(hddProduct1.getProblemKeyword(), technicalProblemGuide);
	}	
	@Override
	public void visit(MediaPlayers mediaPlayers) {
		List<String> technicalProblemGuide = mediaPlayers.getMediaPlayerTechnicalGuide();
		this.search(mediaPlayers.getProblemKeyword(), technicalProblemGuide);
	}	
	@Override
	public void visit(SSDProduct sddProduct) {
		List<String> technicalProblemGuide = sddProduct.getSSDProductTechnicalGuide();
		this.search(sddProduct.getProblemKeyword(), technicalProblemGuide);
	}	
	@Override
	public void visit(USBProduct usbProduct) {
		List<String> technicalProblemGuide = usbProduct.getUSBProductTechnicalGuide();
		this.search(usbProduct.getProblemKeyword(), technicalProblemGuide);
	}	
	 */
	@Override
	public List<String> search(String problemKeyword, List<String> technicalProblemGuide) {
		String tempArray[]=problemKeyword.trim().split(" ");
		String lastElement=tempArray[tempArray.length-1];
		List <String> tempSynonyms;
		List<String> semanticMatchOutput = new ArrayList<String>();
		if(lastElement != null) {
			tempSynonyms= synonyms.get(lastElement);
			if(tempSynonyms != null){
				for(String s : tempSynonyms){
					if(technicalProblemGuide != null) {
						for(String string: technicalProblemGuide) {
							if(string.contains(s)) {
								semanticMatchOutput.add(string);
							}
						}
					}
				}
			}
		}
		for(String string : semanticMatchOutput) {
			System.out.println("Semantic Match : "+ string);
		}
		return semanticMatchOutput;
	}

}
