package Interfaces;

public interface EventInterface<T> {
	
	void subscribe(T listener);
	void unsubscribe(T listener);
	void notifyListeners();
}
