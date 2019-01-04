package team_3;

import java.io.IOException;
import java.util.ArrayList;

public class WebsiteRank {
	ArrayList<Keyword> keywords = new KeywordList().add();
	ArrayList<WebTree> rank;
	
	public WebsiteRank() {
		this.rank = new ArrayList<>();
	}
	
	public void addTree(String title, String rootUrl) throws IOException{
		WebTree tree = new WebTree(title, rootUrl);
		tree.createTree();
		tree.calTreeScore(keywords);
		rank.add(tree);
	}
	
	public void output() {
		for(WebTree web : rank) {
			System.out.println(web.rootNode.webPage.title + ' '+ web.rootNode.webPage.url);
			System.out.println(web.score);
		}
	}
	
	public void sort() {
		this.rank = doQuickSort(this.rank);
	}
	
	private ArrayList<WebTree> doQuickSort(ArrayList<WebTree> list){
		if(list.size()<=1) {
			return list;
		}
		ArrayList<WebTree> less = new ArrayList<>();
		ArrayList<WebTree> equal = new ArrayList<>();
		ArrayList<WebTree> greater = new ArrayList<>();
		// result//
		ArrayList<WebTree> retVal = new ArrayList<>();
	
		int indexOfPivot = list.size()/2;
		WebTree pivot = list.get(indexOfPivot);
		for (WebTree webTree : list) {
			if(webTree.score > pivot.score) {
				less.add(webTree);
			} else if(webTree.score < pivot.score) {
				greater.add(webTree);
			} else {
				equal.add(webTree);
			}
		}
		
		retVal.addAll(doQuickSort(less));
		retVal.addAll(equal);
		retVal.addAll(doQuickSort(greater));
		
		return retVal;
	}
}
