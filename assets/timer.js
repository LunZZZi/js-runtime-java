var timer = new java.util.Timer()

timer.schedule(
    new java.util.TimerTask({
        run: function() {
            print("Tick")
        }
    }), 0, 100
)

java.lang.Thread.sleep(5000)
timer.cancel()
