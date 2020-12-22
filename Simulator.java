package csi405.homework.hw04;

/**
 * A {@code Simulator} performs scheduled {@code Task}s at the specified simulation times.
 * 
 * @author Quincy Asemota CSI405
 */
public class Simulator {

	/**
	 * The scheduled {@code Task}s.
	 */
	protected MultiValuedTreeMap<Double, Task> scheduledTasks = new MultiValuedTreeMap<Double, Task>();

	/**
	 * Schedules the specified {@code Task}.
	 * 
	 * @param task
	 *            the {@code Task} to schedule.
	 * @param simulationTime
	 *            the simulation time at which the {@code Task} needs to be executed.
	 */
	public void schedule(Task task, double simulationTime) { 
		// Problem 4
		scheduledTasks.add(simulationTime, task);
		
	}

	/**
	 * Starts this {@code Simulator}.
	 */
	public void start() {
		// Problem 5
		while (!scheduledTasks.isEmpty()) {
			Pair<Double, Task> p = scheduledTasks.removeFirst();
			// Call run method
			p.second().run(p.first());

		}

	}

	/**
	 * The main method.
	 * 
	 * @param args
	 *            the program arguments.
	 */
	public static void main(String[] args) {
		Simulator simulator = new Simulator(); // construct a Simulator
		simulator.schedule(new Task() { // schedule a task that prints "1: " and then the simulation time 1000
			public void run(double simulationTime) {
				System.out.println("1: " + simulationTime);
			}
		}, 1000);
		simulator.schedule(new Task() { // schedule a task that prints "2: " and then the simulation time 2000
			public void run(double simulationTime) {
				System.out.println("2: " + simulationTime);
			}
		}, 2000);
		simulator.schedule(new Task() { // schedule a task that prints "3: " and then the simulation time 1000
			public void run(double simulationTime) {
				System.out.println("3: " + simulationTime);
			}
		}, 1000);
		simulator.start();
	}
}