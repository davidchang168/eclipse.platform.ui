/*******************************************************************************
 * Copyright (c) 2004 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Common Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/cpl-v10.html
 * 
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.ui.help;

import org.eclipse.help.IContext;
import org.eclipse.jface.action.IAction;
import org.eclipse.swt.events.HelpListener;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.ui.commands.ICommand;

/**
 * <p>
 * The interface that is used to access the workbench help system. Replaces
 * static methods on <code>WorkbenchHelp</code>.
 * </p>
 * <p>
 * This interface is not intended to be implemented by clients.
 * </p>
 * @since 3.1
 */
public interface IWorkbenchHelpSystem {

	/**
	 * Returns whether there is a UI help system installed.
	 * 
	 * @return whether there is a UI help system installed
	 */
	boolean hasHelpUI();
	
	/**
	 * Displays the entire help bookshelf.
	 * <p>
	 * Ignored if no help UI is available.
	 * </p>
	 */
	void displayHelp();

	/**
	 * Displays context-sensitive help for the given context.
	 * <p>
	 * (x,y) coordinates specify the location where the context sensitive help
	 * UI will be presented. These coordinates are screen-relative (ie: (0,0) is
	 * the top left-most screen corner). The platform is responsible for calling
	 * this method and supplying the appropriate location.
	 * </p>
	 * <p>
	 * Ignored if no help UI is available.
	 * </p>
	 * 
	 * @param context
	 *            the context to display
	 * @param x
	 *            horizontal position
	 * @param y
	 *            verifical position
	 */
	void displayContext(IContext context, int x, int y);

	/**
	 * Displays help content for the help resource with the given URL.
	 * <p>
	 * This method is called by the platform to launch the help system UI,
	 * displaying the documentation identified by the <code>href</code>
	 * parameter.
	 * </p>
	 * <p>
	 * The help system makes no guarantee that all the help resources can be
	 * displayed or how they are displayed.
	 * </p>
	 * <p>
	 * Ignored if no help UI is available.
	 * </p>
	 * 
	 * @param href
	 *            the URL of the help resource.
	 *            <p>
	 *            Valid href are as described in
	 *            {@link  org.eclipse.help.IHelpResource#getHref() IHelpResource.getHref()}
	 *            </p>
	 */
	void displayHelpResource(String href);

	/**
	 * Creates a new help listener for the given command. This retrieves the
	 * help context ID from the command, and creates an appropriate listener
	 * based on this.
	 * 
	 * @param command
	 *            The command for which the listener should be created; must not
	 *            be <code>null</code>.
	 * @return A help listener; never <code>null</code>.
	 */
	HelpListener createHelpListener(ICommand command);

	/**
	 * Calls the help support system to display the given help context id.
	 * <p>
	 * May only be called from a UI thread.
	 * <p>
	 * 
	 * @param contextId
	 *            the id of the context to display
	 */
	void displayHelp(String contextId);

	/**
	 * Displays context-sensitive help for the given context.
	 * <p>
	 * May only be called from a UI thread.
	 * <p>
	 * 
	 * @param context
	 *            the context to display
	 */
	void displayHelp(IContext context);

	/**
	 * Returns whether the context-sensitive help window is currently being
	 * displayed. Returns <code>false</code> if the help UI has not been
	 * activated yet.
	 * 
	 * @return <code>true</code> if the context-sensitive help window is
	 *         currently being displayed, <code>false</code> otherwise
	 */
	boolean isContextHelpDisplayed();

	/**
	 * Sets the given help context id on the given action.
	 * 
	 * @param action
	 *            the action on which to register the context id
	 * @param contextId
	 *            the context id to use when F1 help is invoked
	 */
	void setHelp(IAction action, String contextId);

	/**
	 * Sets the given help context id on the given control.
	 * 
	 * @param control
	 *            the control on which to register the context id
	 * @param contextId
	 *            the context id to use when F1 help is invoked
	 */
	void setHelp(Control control, String contextId);

	/**
	 * Sets the given help context id on the given menu.
	 * 
	 * @param menu
	 *            the menu on which to register the context id
	 * @param contextId
	 *            the context id to use when F1 help is invoked
	 */
	void setHelp(Menu menu, String contextId);

	/**
	 * Sets the given help context id on the given menu item.
	 * 
	 * @param item
	 *            the menu item on which to register the context id
	 * @param contextId
	 *            the context id to use when F1 help is invoked
	 */
	void setHelp(MenuItem item, String contextId);
}
