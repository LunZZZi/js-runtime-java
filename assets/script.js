var count = 0;

// timer
setTimeout(function() {
  count++;
  print(count)
}, 2000);

// read file
readFile(".gitignore", function(data) {
    print(".gitignore");
    print(data);
});
