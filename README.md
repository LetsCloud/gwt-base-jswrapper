# gwt-jswrapper
Base GWT functions for wrapping external JavaScript codes.
## Functions
- Injecting JavaScript code.
```java
GwtJsWrapper.injectJs(TextResource resource, boolean removeTag, boolean sourceUrl);
```
- Injecting CSS code.
```java
GwtJsWrapper.injectCss(TextResource resource);
```
## Maven
### Current Version 1.0.0
```xml
<dependency>
    <groupId>com.github.letscloud</groupId>
    <artifactId>gwt-jswrapper</artifactId>
    <version>1.0.0</version>
</dependency>
```
