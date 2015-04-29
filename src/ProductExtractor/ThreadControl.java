//@author Lee

package ProductExtractor;

import java.util.ArrayList;
import java.util.Iterator;

/*
 * A class to control the amount of threads active at any one time, and
 * ensures that all threads are completed before moving onto outputting the products
 * to a text file
 */
public class ThreadControl {
	
	private ArrayList<Thread> waitingthreads;
	private ArrayList<Thread> runningthreads;
	private int maxThreads;
	private int completed;
	
	public ThreadControl(int maxThreads) {
		this.maxThreads = maxThreads + 1;
		waitingthreads = new ArrayList<Thread>();
		runningthreads = new ArrayList<Thread>();
		completed = 0;
	}
	
	public void addThread(Thread t) {
		waitingthreads.add(t);
	}

	public void run() {
		while (runningthreads.size() > 0 || waitingthreads.size() > 0) {
			if (runningthreads.size() < maxThreads && waitingthreads.size() > 0) {
				Thread t = waitingthreads.get(0);
				t.start();
				runningthreads.add(t);
				waitingthreads.remove(t);
			}
			
			Iterator<Thread> itr = runningthreads.iterator();
			while (itr.hasNext()) {
				Thread t = itr.next();
				if (!t.isAlive()) {
					itr.remove();
					completed++;
				}
			}
			System.out.print(completed + " completed threads/" + runningthreads.size() + " running threads/" + waitingthreads.size() + " waiting threads, " + (completed * 100 / (completed + runningthreads.size() + waitingthreads.size())) + "%\r");
		}
	}
	
}
