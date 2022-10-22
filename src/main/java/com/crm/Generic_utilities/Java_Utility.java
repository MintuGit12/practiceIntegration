package com.crm.Generic_utilities;

import java.util.Random;

public class Java_Utility {
/**
 * This method is used to avoid Duplicate values
 * @return
 */
public int getRanDomNum()
{
	Random r=new Random();
	int i = r.nextInt();
	return i;
}

}
