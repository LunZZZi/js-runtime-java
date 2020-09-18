# js-runtime-java

给nashorn JS引擎提供一个runtime，计划支持如下特殊：
- setTimeout
- XmlHttpRequest
- readFileSync


## Nashorn 预定义的函数

```
exit(code); quit();

print(...); echo(...);

var result1 = load("script path or URL");

load({ name: "myScript", script: "var z = x + y;" });

loadWithNewGlobal("script path or URL", args);
```