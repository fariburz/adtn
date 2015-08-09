package com.hyper.sonar;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestSomeClass {

	SomeClass someClass;

	@Before
	public void runBeforeEachTest() {
		someClass = new SomeClass();
	}

	@Test
	public void testPrintHyper() {
		someClass.printHyper();
		String text = "hyper";
		Assert.assertEquals("hyper", text);
		Assert.assertEquals("success", someClass.printHyper(text));

	}

}
