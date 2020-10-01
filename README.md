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
### Current Version: 0.0.3-SNAPSHOT
```xml
<dependency>
    <groupId>com.github.letscloud</groupId>
    <artifactId>gwt-jswrapper</artifactId>
    <version>0.0.3-SNAPSHOT</version>
</dependency>
```
