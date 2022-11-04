
package mini_twitter;

// Use of the Observer pattern, where users are the observers.

public interface Observer 
{
    public void update(String msg, Subject sub);
}
