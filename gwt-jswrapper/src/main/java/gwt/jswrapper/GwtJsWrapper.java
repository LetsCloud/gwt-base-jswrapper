/*
 * #%L
 * LetsCloud
 * %%
 * Copyright (C) 2020 LetsCloudTeam
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */
package gwt.jswrapper;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.core.client.ScriptInjector;
import com.google.gwt.dom.client.StyleInjector;
import com.google.gwt.resources.client.TextResource;

/**
 * @author robi
 *
 */
public class GwtJsWrapper {
	static class FutureResource {
		TextResource resource;
		boolean removeTag, sourceUrl;

		public FutureResource(TextResource resource, boolean removeTag, boolean sourceUrl) {
			this.resource = resource;
			this.removeTag = removeTag;
			this.sourceUrl = sourceUrl;
		}
	}

	static List<FutureResource> futureResources;
	static boolean jqueryWarning;

	public static void injectJs(TextResource resource) {
		injectJs(resource, true, false);
	}

	public static void injectDebugJs(TextResource resource) {
		injectJs(resource, false, true);
	}

	public static void injectJs(TextResource resource, boolean removeTag, boolean sourceUrl) {
		if (!resource.getName().equals("jQuery") && !resource.getName().equals("jQueryDebug")) {
			// We need to wait for jQuery to load
			if (futureResources == null) {
				futureResources = new ArrayList<>();
			}
			futureResources.add(new FutureResource(resource, removeTag, sourceUrl));
		} else {
			directInjectJs(resource, removeTag, sourceUrl);
		}
	}

	protected static void directInjectJs(TextResource resource) {
		directInjectJs(resource, true, false);
	}

	protected static void directInjectDebugJs(TextResource resource) {
		directInjectJs(resource, false, true);
	}

	protected static void directInjectJs(TextResource resource, boolean removeTag, boolean sourceUrl) {
		String text = resource.getText() + (sourceUrl ? "//# sourceURL=" + resource.getName() + ".js" : "");

		// Inject the script resource
		ScriptInjector.fromString(text).setWindow(ScriptInjector.TOP_WINDOW).setRemoveTag(removeTag).inject();
	}

	public static void injectCss(TextResource resource) {
		StyleInjector.inject(resource.getText());
	}
}
