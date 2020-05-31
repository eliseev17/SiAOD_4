public class Deque {
    private int dequeSize;
    private char[] dequeArray;
    private int top;
    private int bot;

    public Deque(int n) {
        this.dequeSize = n;
        this.dequeArray = new char[dequeSize];
        this.top = dequeSize / 2;
        this.bot = dequeSize / 2;
    }

    public char[] getDequeArray() {
        return dequeArray;
    }

    public void addElementTop(char element) {
        dequeArray[++top] = element;
    }

    public void addElementBot(char element) {
        dequeArray[--bot] = element;
    }

    public int deleteElementTop() {
        return dequeArray[top--];
    }

    public int deleteElementBot() {
        return dequeArray[bot++];
    }

    public int getTop() {
        return dequeArray[top];
    }

    public int getBot() {
        return dequeArray[bot];
    }

    public boolean isEmpty() {
        return (top == -1 && bot == dequeSize);
    }

    public boolean isFull() {
        return (top == bot);
    }

    public int getDequeSize() {
        return dequeSize;
    }
}