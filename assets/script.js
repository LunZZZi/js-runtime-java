var os = Java.type("OS");
var console = Java.type("Console");
var setTimeout = os.setTimeout;

os.setTimeout(function() {
  console.log("Hello world")
}, 2000);