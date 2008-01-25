/*******************************************************************************
* Copyright (c) 2007 Oracle. All rights reserved.
* This program and the accompanying materials are made available under the terms of
* the Eclipse Public License v1.0, which accompanies this distribution and is available at
* http://www.eclipse.org/legal/epl-v10.html.
*
* Contributors:
*     Oracle - initial API and implementation
******************************************************************************/
package org.eclipse.persistence.tools.workbench.test.mappingsmodel.query.xml;

import org.eclipse.persistence.tools.workbench.test.models.projects.EmployeeEisProject;
import org.eclipse.persistence.tools.workbench.test.utility.TestTools;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.eclipse.persistence.tools.workbench.mappingsmodel.query.xml.MWEisInteraction;
import org.eclipse.persistence.tools.workbench.mappingsmodel.query.xml.MWEisQueryManager;

public class MWEisInteractionTests extends TestCase {
	
	private EmployeeEisProject employeeProject;

	public static void main(String[] args) 
	{
		junit.swingui.TestRunner.main(new String[] {"-c", MWEisInteractionTests.class.getName()});
	}
	
	public static Test suite() 
	{
		return new TestSuite(MWEisInteractionTests.class);
	}

	public MWEisInteractionTests(String name)
	{
		super(name);
	}

	protected void setUp() throws Exception {
		super.setUp();
		this.employeeProject = new EmployeeEisProject();
	}

	protected void tearDown() throws Exception {
		TestTools.clear(this);
		super.tearDown();
	}
	
	//test for bug #4360797
	public void testAddingNullArguments()
	{
		MWEisInteraction interaction = ((MWEisQueryManager)employeeProject.getEmployeeDescriptor().getQueryManager()).getReadObjectInteraction();
		//just check for no null pointer exceptions
		try {
			interaction.addInputArgument(null, null);
			interaction.addOutputArgument(null, null);
			interaction.addProperty(null, null);
		} catch (NullPointerException exception) {
			fail("Should not be getting the NullPointerException in this scenario, it should be handled.");
		}
	}
	
}
