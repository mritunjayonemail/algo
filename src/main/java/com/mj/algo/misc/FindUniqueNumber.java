package com.mj.algo.misc;

import java.util.ArrayList;
import java.util.List;

//Given the list of IDs, which contains many duplicate integers and one unique integer, 
//find the unique integer.
public class FindUniqueNumber {
	
	public int findUnique(List<Integer> deliveryIdList){
		int unique_delivery_id = 0;
				
		for(Integer deliveryId : deliveryIdList){
			unique_delivery_id ^= deliveryId;
		}
		
		return unique_delivery_id;
	}
	
	public static void main(String[] args){
		List<Integer> deliveryIdList = new ArrayList<Integer>();
		deliveryIdList.add(1);
		deliveryIdList.add(2);
		deliveryIdList.add(3);
		deliveryIdList.add(4);
		deliveryIdList.add(1);
		deliveryIdList.add(2);
		deliveryIdList.add(3);
		
		FindUniqueNumber findUniqueNumber = new FindUniqueNumber();
		System.out.println(findUniqueNumber.findUnique(deliveryIdList));
		
	}

}
