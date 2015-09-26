package com.mj.algo.tree.modal;

import java.util.ArrayList;
import java.util.List;

public class TrieNode {

	private char content;
	private int count;
	private boolean isEnd = false;
	private List<TrieNode> childList;

	public TrieNode(char c) {
		this.content = c;
		count = 0;
		isEnd = false;
		childList = new ArrayList<TrieNode>();
	}

	public TrieNode subNode(char c) {
		if (childList != null)
			for (TrieNode eachChild : childList)
				if (eachChild.content == c)
					return eachChild;
		return null;
	}

	public char getContent() {
		return content;
	}

	public void setContent(char content) {
		this.content = content;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public boolean isEnd() {
		return isEnd;
	}

	public void setEnd(boolean isEnd) {
		this.isEnd = isEnd;
	}

	public List<TrieNode> getChildList() {
		return childList;
	}

	public void setChildList(List<TrieNode> childList) {
		this.childList = childList;
	}
	
	

}
