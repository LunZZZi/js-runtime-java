/**
 * public APIs of the runtime
 *
 *
 * global objects:
 * - eventLoop
 * - fs
 *
 */

/**
 * setTimeout
 * @param {function} cb
 * @param {number} time millisecond
 * @returns {number}
 */
function setTimeout(cb, time) {
  return eventLoop.setTimeout(cb, time);
}

/**
 * read file
 * @param path the file path
 * @param callback
 */
function readFile(path, callback) {
  fs.readFile(path, callback);
}
