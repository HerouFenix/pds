package ex01Vasco;

public interface Observer {
    public abstract void update(String message);

    public abstract String getType();
}