package com.splwg;

import com.splwg.base.api.testers.ContextTestCase;
import com.splwg.shared.logging.Logger;
import com.splwg.shared.logging.LoggerFactory;

public class TestJugad_Test extends ContextTestCase{

	Logger logger = LoggerFactory.getLogger(TestJugad_Test.class);
	
	public void testA()
	{
		logger.info("Executing test case A");
		assertEquals(true, false);

	}
	
	
	
	public void testB()
	{
		logger.info("Executing test case B");
		
		assertEquals(true, true);

	}
	
}
