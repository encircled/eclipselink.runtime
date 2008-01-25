/*******************************************************************************
* Copyright (c) 2007 Oracle. All rights reserved.
* This program and the accompanying materials are made available under the terms of
* the Eclipse Public License v1.0, which accompanies this distribution and is available at
* http://www.eclipse.org/legal/epl-v10.html.
*
* Contributors:
*     Oracle - initial API and implementation
******************************************************************************/
package org.eclipse.persistence.tools.workbench.test.utility.diff;

import org.eclipse.persistence.tools.workbench.test.utility.TestTools;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import junit.swingui.TestRunner;

import org.eclipse.persistence.tools.workbench.utility.diff.Diff;
import org.eclipse.persistence.tools.workbench.utility.diff.Differentiator;
import org.eclipse.persistence.tools.workbench.utility.diff.NullDifferentiator;



public class NullDiffTests extends TestCase {
	private Differentiator differentiator;
	
	public static void main(String[] args) {
		TestRunner.main(new String[] {"-c", NullDiffTests.class.getName()});
	}
	
	public static Test suite() {
		return new TestSuite(NullDiffTests.class);
	}
	
	public NullDiffTests(String name) {
		super(name);
	}

	protected void setUp() throws Exception {
		super.setUp();
		this.differentiator = NullDifferentiator.instance();
	}

	protected void tearDown() throws Exception {
		TestTools.clear(this);
		super.tearDown();
	}

	public void testSameObject() {
		Object object1 = new Integer(42);
		Object object2 = object1;
		Diff diff = this.differentiator.diff(object1, object2);
		this.verifyDiff(diff, object1, object2);
		diff = this.differentiator.keyDiff(object1, object2);
		this.verifyDiff(diff, object1, object2);
	}

	public void testDifferentObjects() {
		Object object1 = new Integer(42);
		Object object2 = new Integer(42);
		assertEquals(object1, object2);
		assertTrue(object1 != object2);
		Diff diff = this.differentiator.diff(object1, object2);
		this.verifyDiff(diff, object1, object2);
		diff = this.differentiator.keyDiff(object1, object2);
		this.verifyDiff(diff, object1, object2);
	}
	
	public void testBothNull() {
		Object object1 = null;
		Object object2 = null;
		Diff diff = this.differentiator.diff(object1, object2);
		this.verifyDiff(diff, object1, object2);
		diff = this.differentiator.keyDiff(object1, object2);
		this.verifyDiff(diff, object1, object2);
	}
	
	private void verifyDiff(Diff diff, Object object1, Object object2) {
		assertEquals(object1, diff.getObject1());
		assertEquals(object2, diff.getObject2());
		assertTrue(diff.identical());
		assertFalse(diff.different());
		assertEquals(0, diff.getDescription().length());
	}
	
	public void testUnequalObjects() {
		Object object1 = new Integer(42);
		Object object2 = new Integer(77);
		Diff diff = this.differentiator.diff(object1, object2);
		this.verifyDiff(diff, object1, object2);
		diff = this.differentiator.keyDiff(object1, object2);
		this.verifyDiff(diff, object1, object2);
	}

	public void testOneNull() {
		Object object1 = new Object();
		Object object2 = null;
		Diff diff = this.differentiator.diff(object1, object2);
		this.verifyDiff(diff, object1, object2);
		diff = this.differentiator.keyDiff(object1, object2);
		this.verifyDiff(diff, object1, object2);

		object1 = null;
		object2 = new Object();
		diff = this.differentiator.diff(object1, object2);
		this.verifyDiff(diff, object1, object2);
		diff = this.differentiator.keyDiff(object1, object2);
		this.verifyDiff(diff, object1, object2);
	}
	
}
