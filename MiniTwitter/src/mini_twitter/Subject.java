
package mini_twitter;

// Users are the subject of the Observer pattern. Followers observe news feed of
// those they are following, then attach the observer (the user) to following.

public interface Subject 
{
    public void register(Observer obj);
    public void notifyObserver();
    public Object getUpdate(Observer obj);
}
