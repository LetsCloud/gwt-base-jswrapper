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

import jsinterop.annotations.JsConstructor;
import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

import java.util.HashMap;
import java.util.Map;

/**
 * @author robi
 *
 */
@SuppressWarnings("all")
@JsType(isNative = true, namespace = JsPackage.GLOBAL)
public class Promise<S, E> extends Thenable<S, E> {

	@JsConstructor
	public Promise(Fn.Resolver<S, E> resolver) {
	}

	public static native <A, B> Promise<A, B> all(Promise<?, ?>[] promises);

	public static native <S> Promise<S, Error> resolve(S success);

	private Fn.Arg<S> resolve;
	private Fn.Arg<E> reject;

	@JsOverlay
	public final Promise<S, E> openResolve(S success) {
		if (resolve == null) {
			throw new UnsupportedOperationException("promise is not open, use buildOpenPromise");
		}
		resolve.call(success);
		return this;
	}

	@JsOverlay
	public final Promise<S, E> openReject(E error) {
		if (reject == null) {
			throw new UnsupportedOperationException("promise is not open, use buildOpenPromise");
		}
		reject.call(error);
		return this;
	}

	@JsOverlay
	public static <S, E> Promise<S, E> buildOpenPromise() {
		final Map<String, Fn.Arg<?>> containers = new HashMap<>(2);
		Fn.Resolver<S, E> resolver = new Fn.Resolver<S, E>() {
			@Override
			public void call(Fn.Arg<S> resolve, Fn.Arg<E> reject) {
				containers.put("resolve", resolve);
				containers.put("reject", reject);
			}
		};
		Promise<S, E> openPromise = new Promise<S, E>(resolver);
		openPromise.resolve = (Fn.Arg<S>) containers.get("resolve");
		openPromise.reject = (Fn.Arg<E>) containers.get("reject");
		return openPromise;
	}
}