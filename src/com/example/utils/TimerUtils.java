package com.example.utils;

import java.util.Timer;
import java.util.TimerTask;

public class TimerUtils {
	public static void schedule(TimerTask task, int delay){
		Timer timer = new Timer();
		timer.schedule(task, delay);
	}
}
