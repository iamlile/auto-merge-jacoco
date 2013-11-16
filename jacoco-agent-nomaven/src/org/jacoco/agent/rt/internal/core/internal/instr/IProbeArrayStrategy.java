/*******************************************************************************
 * Copyright (c) 2009, 2013 Mountainminds GmbH & Co. KG and Contributors
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Marc R. Hoffmann - initial API and implementation
 *    
 *******************************************************************************/
package org.jacoco.agent.rt.internal.core.internal.instr;

import org.jacoco.agent.rt.internal.asm.ClassVisitor;
import org.jacoco.agent.rt.internal.asm.MethodVisitor;

/**
 * Strategies to retrieve the probe array instance for each method within a
 * type. This abstraction is required as we need to follow a different strategy
 * depending on whether the instrumented type is a class or interface.
 */
interface IProbeArrayStrategy {

	/**
	 * Creates code that stores the probe array instance in the given variable.
	 * 
	 * @param mv
	 *            visitor to create code
	 * @param variable
	 *            variable index to store probe array to
	 * @return maximum stack size required by the generated code
	 */
	int storeInstance(MethodVisitor mv, int variable);

	/**
	 * Adds additional class members required by this strategy.
	 * 
	 * @param delegate
	 *            visitor to create fields and classes
	 */
	void addMembers(ClassVisitor delegate);

}
