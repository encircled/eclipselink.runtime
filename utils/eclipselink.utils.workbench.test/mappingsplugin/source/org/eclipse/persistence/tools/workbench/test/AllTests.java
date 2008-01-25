/*******************************************************************************
* Copyright (c) 2007 Oracle. All rights reserved.
* This program and the accompanying materials are made available under the terms of
* the Eclipse Public License v1.0, which accompanies this distribution and is available at
* http://www.eclipse.org/legal/epl-v10.html.
*
* Contributors:
*     Oracle - initial API and implementation
******************************************************************************/
package org.eclipse.persistence.tools.workbench.test;

import org.eclipse.persistence.tools.workbench.test.utility.TestTools;

import junit.framework.Test;
import junit.framework.TestSuite;
import junit.swingui.TestRunner;

import org.eclipse.persistence.tools.workbench.utility.ClassTools;


/**
 * Pull together the tests from all the libraries and plug-ins.
 */
public class AllTests {

	public static void main(String[] args) {
		TestRunner.main(new String[] {"-c", AllTests.class.getName()});
	}

	public static Test suite() {
		return suite(true);
	}

	/**
	 * for now, there is only one difference between "All" and "Most" tests...
	 */
	static Test suite(boolean all) {
		TestTools.setUpJUnitThreadContextClassLoader();
		TestTools.invalidateSystemStreams();
		TestTools.setUpOracleProxy();

		String quantity = all ? "All" : "Most";
		TestSuite suite = new TestSuite(quantity + " EclipseLink Workbench Tests");

		// resolve all the classes dynamically, so we don't have compile dependencies
		suite.addTest(suiteForClassNamed("org.eclipse.persistence.tools.workbench.test.utility.AllUtilityTests", all));
		suite.addTest(suiteForClassNamed("org.eclipse.persistence.tools.workbench.test.uitools.AllUIToolsTests", all));
		suite.addTest(suiteForClassNamed("org.eclipse.persistence.tools.workbench.test.framework.AllFrameworkTests", all));
		suite.addTest(suiteForClassNamed("org.eclipse.persistence.tools.workbench.test.platformsplugin.AllPlatformsPluginTests", all));
		suite.addTest(suiteForClassNamed("org.eclipse.persistence.tools.workbench.test.mappingsmodel.AllMappingsModelTests", all));
		suite.addTest(suiteForClassNamed("org.eclipse.persistence.tools.workbench.test.mappingsplugin.AllMappingsPluginTests", all));
		suite.addTest(suiteForClassNamed("org.eclipse.persistence.tools.workbench.test.mappingsio.AllMappingsIOTests", all));
		suite.addTest(suiteForClassNamed("org.eclipse.persistence.tools.workbench.test.scplugin.AllSCTests", all));

		return suite;
	}

	private static Test suiteForClassNamed(String javaClassName, boolean all) {
		return (Test) ClassTools.invokeStaticMethod(ClassTools.classForName(javaClassName), "suite", boolean.class, Boolean.valueOf(all));
	}

	private AllTests() {
		super();
		throw new UnsupportedOperationException();
	}
}