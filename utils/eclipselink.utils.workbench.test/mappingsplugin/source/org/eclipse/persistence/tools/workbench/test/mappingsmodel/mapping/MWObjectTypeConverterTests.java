/*******************************************************************************
* Copyright (c) 2007 Oracle. All rights reserved.
* This program and the accompanying materials are made available under the terms of
* the Eclipse Public License v1.0, which accompanies this distribution and is available at
* http://www.eclipse.org/legal/epl-v10.html.
*
* Contributors:
*     Oracle - initial API and implementation
******************************************************************************/
package org.eclipse.persistence.tools.workbench.test.mappingsmodel.mapping;

import org.eclipse.persistence.tools.workbench.test.mappingsmodel.ModelProblemsTestCase;
import org.eclipse.persistence.tools.workbench.test.models.projects.CrimeSceneProject;

import junit.framework.Test;
import junit.framework.TestSuite;
import org.eclipse.persistence.tools.workbench.mappingsmodel.ProblemConstants;
import org.eclipse.persistence.tools.workbench.mappingsmodel.mapping.MWObjectTypeConverter;
import org.eclipse.persistence.tools.workbench.mappingsmodel.mapping.relational.MWDirectToFieldMapping;



public class MWObjectTypeConverterTests extends ModelProblemsTestCase {

	public static void main(String[] args) {
		junit.swingui.TestRunner.main(new String[] {"-c", MWObjectTypeConverterTests.class.getName()});
	}

	public MWObjectTypeConverterTests(String name) {
		super(name);
	}
		
	public static Test suite() {
		return new TestSuite(MWObjectTypeConverterTests.class);
	}
	
	//TODO see MWObjectTypeConverterMapping for why this is commented out
//	public void testDatabaseTypeMatchesFieldTypesProblem() {
//	
//		String errorName = "029";
//		
//		checkMappingsForFalseFailures( errorName, MWDirectToFieldMapping.class );
//	
//		CrimeSceneProject csp = new CrimeSceneProject();
//		MWDirectToFieldMapping mapping = csp.getGenderMappingInPerson();
//		MWObjectTypeConverter objectTypeConverter = (MWObjectTypeConverter) mapping.getConverter();
//		objectTypeConverter.setDataType(csp.getProject().typeFor(Integer.class));
//		
//		assertTrue("The mapping should have the problem: " + errorName, hasProblem(errorName, mapping));
//	}
	
	public void testObjectTypeMappingsHaveBeenSpecifiedProblem() {
		String errorName = ProblemConstants.MAPPING_VALUE_PAIRS_NOT_SPECIFIED;
		
		checkMappingsForFalseFailures( errorName, MWDirectToFieldMapping.class );
	
		CrimeSceneProject csp = new CrimeSceneProject();
		MWDirectToFieldMapping mapping = csp.getGenderMappingInPerson();
		MWObjectTypeConverter objectTypeConverter = (MWObjectTypeConverter) mapping.getConverter();
		objectTypeConverter.clearValuePairs();
		
		assertTrue("The mapping should have the problem: " + errorName, hasProblem(errorName, mapping));
	}
}
