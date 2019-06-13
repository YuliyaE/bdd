package by.yuliya.calculator.teststeps;

import by.yuliya.calculator.util.TestListener;
import org.testng.TestNG;
import org.testng.xml.XmlSuite;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Runner {

	public static void main(String[] args) {
		TestNG testNg = new TestNG();

		XmlSuite suite = new XmlSuite();
		suite.setSuiteFiles(Arrays.asList("./src/test/resources/testng.xml"));

		List<XmlSuite> suites = new ArrayList<XmlSuite>();
		suites.add(suite);
		
		testNg.setXmlSuites(suites);
		testNg.run();
	}

}
