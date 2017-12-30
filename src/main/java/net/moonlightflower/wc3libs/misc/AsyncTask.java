package net.moonlightflower.wc3libs.misc;

import javafx.application.Platform;

import javax.annotation.Nonnull;

public abstract class AsyncTask extends Thread {
	public class FinishedException extends RuntimeException {
		
	}

	@Override
	public abstract void run();
	public abstract void onPostExec();
	
	public interface FinishedHandler {
		void finished();
	}
	
	private final FinishedHandler _finishedHandler;
	
	@Override
	public void start() {
		setDaemon(true);
		setUncaughtExceptionHandler((thread, exception) -> Platform.runLater(() -> {
			if (exception instanceof FinishedException) {
				onPostExec();
			} else {
				exception.printStackTrace();
			}

			_finishedHandler.finished();
		}));
		
		super.start();
	}
	
	public AsyncTask(@Nonnull FinishedHandler finishedHandler) {
		_finishedHandler = finishedHandler;
	}
}