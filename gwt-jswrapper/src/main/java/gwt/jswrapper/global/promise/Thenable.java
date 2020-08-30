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

import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

/**
 * @author robi
 *
 */
@JsType(isNative = true, namespace = JsPackage.GLOBAL)
public class Thenable<S, E> {

	public native <T extends Thenable> T then(Fn.Arg<S> onResolve, Fn.Arg<E> onReject);

	public native <T extends Thenable> T then(Fn.NoArg onResolve, Fn.Arg<E> onReject);

	public native <T extends Thenable> T then(Fn.Arg<S> onResolve);

	public native <T extends Thenable> T then(Fn.NoArg onResolve);

	public native <R, T extends Thenable> T then(Fn.ArgRet<S, R> onResolve);

	public native <R, T extends Thenable> T then(Fn.ArgRet<S, R> onResolve, Fn.Arg<E> onReject);

	public native <R, T extends Thenable> T then(Fn.ArgRet<S, R> onResolve, Fn.ArgRet<E, E> onReject);

	@JsMethod(name = "catch")
	public native <T extends Thenable> T katch(Fn.Arg<E> onReject);

	@JsMethod(name = "catch")
	public native <T extends Thenable> T katch(Fn.ArgRet<E, E> onReject);
}
