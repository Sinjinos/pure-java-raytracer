package carlvbn.raytracing.rendering;

import java.util.concurrent.ArrayBlockingQueue;

public class ThreadPool {
    private final ArrayBlockingQueue<Runnable> taskQueue;
    private final Thread[] workers;
    private volatile boolean isRun = true;

    //Constructeur qui initialise le pool
    public ThreadPool(int numT, int queueSize) {
        taskQueue = new ArrayBlockingQueue<>(queueSize);
        workers = new Thread[numT];

        //Crée et démarre les threads qui consommeront les tâches de la file
        for (int i=0; i<numT; i++) {
            workers[i] = new Thread(() -> {
                while (isRun || !taskQueue.isEmpty()) {
                    try {
                        //Récupére et exécute les tâches de la file
                        Runnable task = taskQueue.take();
                        task.run();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            });
            workers[i].start();
        }
    }

    public void submit(Runnable task) throws InterruptedException {
        taskQueue.put(task); //Ajoute la tâche dans la file bloquante
    }

    //Méthode pour arrêter
    public void shutdown() {
        isRun = false;
        for (Thread worker : workers) {
            worker.interrupt();
        }
    }
}