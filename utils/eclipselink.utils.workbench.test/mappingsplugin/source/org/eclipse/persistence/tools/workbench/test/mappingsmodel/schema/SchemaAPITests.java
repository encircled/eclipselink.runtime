/*******************************************************************************
* Copyright (c) 2007 Oracle. All rights reserved.
* This program and the accompanying materials are made available under the terms of
* the Eclipse Public License v1.0, which accompanies this distribution and is available at
* http://www.eclipse.org/legal/epl-v10.html.
*
* Contributors:
*     Oracle - initial API and implementation
******************************************************************************/
package org.eclipse.persistence.tools.workbench.test.mappingsmodel.schema;

import java.net.MalformedURLException;
import java.net.URL;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class SchemaAPITests 
	extends TestCase
{
	public static void main(String[] args) {
		junit.swingui.TestRunner.main(new String[] {"-c", SchemaAPITests.class.getName()});
	}
	
	public static Test suite() {
		return new TestSuite(SchemaAPITests.class);
	}
	
	public SchemaAPITests(String name) {
		super(name);
	}
	
	
	/** Change this to change what schema you're test-loading */
	private final String schemaLocation = "file://C:/Paul/Documents/XMLSchema/TestJaxbGroup.xsd";
		/**
		 choices:
		 	http://www.w3.org/2001/XMLSchema.xsd
		 	file://C:/Paul/Documents/XMLSchema/TestJaxbGroup.xsd
		 	file://C:/Paul/XMLSpy/Examples/ipo.xsd
		 	file://C:/Paul/XMLSpy/Examples/OrgChart.xsd
		 	file://C:/Development/TopLink/Main/mwdev-schema/resource/schema/BasicAttributeGroup.xsd
		 	file://C:/Development/TopLink/Main/mwdev-schema/resource/schema/BasicContentModels.xsd
		 	file://C:/Development/TopLink/Main/mwdev-schema/resource/schema/BasicSubstitutionGroup.xsd
			file://C:/Development/TopLink/Main/mwdev-schema/resource/schema/SchemaWithIdentityConstraints.xsd
			file://C:/Development/TopLink/Main/mwdev-schema/resource/schema/TempForTesting.xsd
		*/
	
	private URL schemaUrl;
	
	private URL schemaUrl()
		throws MalformedURLException
	{
		return new URL(this.schemaLocation);
	}
	
}
