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
/**
 * 
 */
package gwt.jswrapper.global.promise;

import jsinterop.annotations.JsFunction;

/**
 * @author robi
 *
 */
public abstract class Fn {
	private Fn() {
	}

	@JsFunction
	public interface NoArg {
		void call();
	}

	@JsFunction
	public interface Arg<A> {
		void call(A arg);
	}

	@JsFunction
	public interface ArgRet<A, R> {
		R call(A arg);
	}

	@JsFunction
	public interface Args {
		void call(Object... args);
	}

	@JsFunction
	public interface Resolver<S, E> {
		void call(Fn.Arg<S> resolve, Fn.Arg<E> reject);
	}

	@JsFunction
	public interface OpenResolver<S, E> {
		void call(Fn.Arg<S> resolve, Fn.Arg<E> reject);
	}
}
