package framework.simulation;

public class SimulationStatus {
	private static boolean paused = false;
	private static int stepping = 0;
	private static boolean threadfinished = false;
	private static boolean threadnowfinished = false;
	private static long time = 0;
	private static boolean repaintAll = true;
	
	
	public static boolean isPaused() {
		return paused;
	}
	public static void setPaused(boolean paused) {
		SimulationStatus.paused = paused;
	}
	public static boolean isThreadfinished() {
		return threadfinished;
	}
	public static void setThreadfinished(boolean threadfinished) {
		SimulationStatus.threadfinished = threadfinished;
	}
	public static int getStepping() {
		return stepping;
	}
	public static void setStepping(int stepping) {
		SimulationStatus.stepping = stepping;
	}
	
	public static long getTime() {
		return time;
	}
	public static void setTime(long time) {
		SimulationStatus.time = time;
	}
	public static boolean isThreadnowfinished() {
		return threadnowfinished;
	}
	public static void setThreadnowfinished(boolean threadnowfinished) {
		SimulationStatus.threadnowfinished = threadnowfinished;
	}
	public static boolean isRepaintAll(){
		return repaintAll;
	}
	public static void setRepaintAll(boolean repaintAll) {
		SimulationStatus.repaintAll = repaintAll;
	}
}
