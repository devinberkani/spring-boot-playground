package com.in28minutes.learnspringframework.examples.c1;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

//@Component
@Repository
@Qualifier("mySQLQualifier")
public class MySQLDataService implements DataService {

	@Override
	public int[] retrieveData() {
		return new int[] {1,2,3,4,5};
	}

}
