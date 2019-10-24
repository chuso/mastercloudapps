package mastermindWeek3.santaTecla.utils;

public interface Originator {

    void restore(Memento memento);

    Memento createMemento();

}
